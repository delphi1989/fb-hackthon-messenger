package tw.com.fdccc.messenger.sender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import tw.com.fdccc.messenger.sender.dto.SendMessageDTO;

import java.net.URI;

@Slf4j
@Service
public class SenderService {

    @Value("${page.access_token}")
    private String pageAccessToken;

    private final String MESSENGER_SENDER_URI
            = "https://graph.facebook.com/v3.0/me/messages";

    private RestTemplate restTemplate;

    public SenderService(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendMission(SendMessageDTO sendMessageDTO) {

        final URI sendMessageUri = UriComponentsBuilder.fromHttpUrl(MESSENGER_SENDER_URI)
                .queryParam("access_token", pageAccessToken)
                .build()
                .toUri();

        final String sendMessageResponse
                = restTemplate.postForObject(sendMessageUri, sendMessageDTO, String.class);

        log.info("[FDCCC][Messenger][Send Message] Result - [{}].", sendMessageResponse);
    }

}
