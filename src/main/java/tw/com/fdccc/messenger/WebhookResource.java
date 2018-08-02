package tw.com.fdccc.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tw.com.fdccc.messenger.sender.service.SenderService;
import tw.com.fdccc.messenger.sender.util.CurrentPropertyMessageFactory;
import tw.com.fdccc.messenger.sender.util.DashBoardMessageFactory;
import tw.com.fdccc.messenger.sender.util.GetStartMessageFactory;
import tw.com.fdccc.messenger.sender.util.MissionListMessageFactory;
import tw.com.fdccc.messenger.sender.util.RankingBoardMessageFactory;
import tw.com.fdccc.messenger.sender.util.RewardListMessageFactory;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;
import tw.com.fdccc.messenger.webhookevent.dto.Sender;
import tw.com.fdccc.messenger.webhookevent.dto.constant.WebhookEventType;
import tw.com.fdccc.messenger.webhookevent.dto.input.Entry;
import tw.com.fdccc.messenger.webhookevent.dto.input.Message;
import tw.com.fdccc.messenger.webhookevent.dto.input.MessageContainer;
import tw.com.fdccc.messenger.webhookevent.dto.input.Optin;
import tw.com.fdccc.messenger.webhookevent.dto.input.Postback;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/webhook")
public class WebhookResource {

    @Value("${facebook.verify_token}")
    public String VERIFY_TOKEN;
    private SenderService senderService;

    @Autowired
    public WebhookResource(SenderService senderService) {

        this.senderService = senderService;
    }

    @GetMapping
    public ResponseEntity validateWebhook(
        @RequestParam(value = "hub.mode") String mode,
        @RequestParam(value = "hub.verify_token") String verifyToken,
        @RequestParam(value = "hub.challenge") String challenge) {

        log.info("[FDCCC][Webhook Validate] Mode - [{}], verify token - [{}], challenge - [{}].",
                mode, verifyToken, challenge);

        if (StringUtils.isEmpty(verifyToken)) {

            return ResponseEntity.badRequest().build();
        }

        if (mode.equals("subscribe") && verifyToken.equals(VERIFY_TOKEN)) {

            return ResponseEntity.ok(challenge);
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity receiveWebhook(@RequestBody MessageContainer messageContainer) {

        log.info("[FDCCC][Webhook Event Discovery] Enter!");

        final List<Entry> entries = messageContainer.getEntry();

        entries.forEach(entry ->
                entry.getMessaging()
                    .forEach(messaging -> {

            final Recipient recipient = messaging.getRecipient();
            final Sender sender = messaging.getSender();

            final Message message = messaging.getMessage();
            final Optin optin = messaging.getOptin();
            final Postback postback = messaging.getPostback();


            if (Objects.nonNull(message)) {

                log.info("[FDCCC][Webhook Event Discovery] Sender - [{}], recipient - [{}], content - [{}].",
                        sender, recipient, message);
            }

            if (Objects.nonNull(optin)) {

                log.info("[FDCCC][Webhook Event Discovery] Sender - [{}], recipient - [{}], content - [{}].",
                        sender, recipient, optin);
            }

            if (Objects.nonNull(postback)) {

                log.info("[FDCCC][Webhook Event Discovery] Sender - [{}], recipient - [{}], content - [{}].",
                        sender, recipient, postback);

                log.info("[FDCCC][Webhook Event Discovery][測試] Title - [{}].", postback.getTitle());

                final String title = postback.getTitle();

                if (title.equals(WebhookEventType.MISSION_LIST.getEventType())) {

                    senderService.sendMission(MissionListMessageFactory.build(sender.getId()));

                } else if (title.equals(WebhookEventType.CURRENT_PROPERTY.getEventType())) {

                    senderService.sendMission(CurrentPropertyMessageFactory.build(sender.getId()));

                } else if (title.equals(WebhookEventType.RANKING_BOARD.getEventType())) {

                    senderService.sendMission(RankingBoardMessageFactory.build(sender.getId()));

                } else if (title.equals(WebhookEventType.APPLY_REWARD.getEventType())) {

                    senderService.sendMission(RewardListMessageFactory.build(sender.getId()));

                } else if (title.equals(WebhookEventType.GET_STARTED.getEventType())) {

                    senderService.sendMission(DashBoardMessageFactory.build(sender.getId()));
                    senderService.sendMission(GetStartMessageFactory.build(sender.getId()));
                }
            }

        }));

        return ResponseEntity.ok().build();
    }
}
