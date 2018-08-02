package tw.com.fdccc.messenger.sender.util;

import tw.com.fdccc.messenger.sender.dto.AttachmentDTO;
import tw.com.fdccc.messenger.sender.dto.AttachmentElement;
import tw.com.fdccc.messenger.sender.dto.AttachmentPayloadDTO;
import tw.com.fdccc.messenger.sender.dto.GenericButton;
import tw.com.fdccc.messenger.sender.dto.MessageDTO;
import tw.com.fdccc.messenger.sender.dto.SendMessageDTO;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;

import java.util.LinkedList;
import java.util.List;

public class GetStartMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        GenericButton missionProcessingButton
                = getPostbackButton("進行中的任務", "this is a test of message postback");
        GenericButton coinInfoButton
                = getPostbackButton("金幣查詢", "this is a test of message postback");
        GenericButton applyRewardButton
                = getPostbackButton("兌換獎勵", "this is a test of message postback");

        List<GenericButton> mission1Buttons = new LinkedList<>();
        mission1Buttons.add(missionProcessingButton);
        mission1Buttons.add(coinInfoButton);
        mission1Buttons.add(applyRewardButton);

        AttachmentElement mission1
                = getAttachmentElement("#Impressions", "http://playerone-studio.com/wp-content/uploads/2017/02/welcome-banner.jpg", "Dashboard", mission1Buttons);

        List<AttachmentElement> elements = new LinkedList<>();
        elements.add(mission1);

        AttachmentPayloadDTO payloadDTO = new AttachmentPayloadDTO();
        payloadDTO.setTemplateType("generic");
        payloadDTO.setElements(elements);

        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setType("template");
        attachmentDTO.setPayload(payloadDTO);

        MessageDTO message = new MessageDTO();
        message.setAttachment(attachmentDTO);

        SendMessageDTO sendMessageDTO = new SendMessageDTO();
        sendMessageDTO.setRecipient(recipient);
        sendMessageDTO.setMessage(message);

        return sendMessageDTO;
    }

    private static GenericButton getPostbackButton(String title, String payload) {

        GenericButton button = new GenericButton();
        button.setType("postback");
        button.setTitle(title);
        button.setPayload(payload);

        return button;
    }

    private static AttachmentElement getAttachmentElement(
            String title,
            String imageUrl,
            String subtitle,
            List<GenericButton> buttons) {

        AttachmentElement element = new AttachmentElement();

        element.setTitle(title);
        element.setImageUrl(imageUrl);
        element.setSubtitle(subtitle);
        element.setButtons(buttons);

        return element;
    }
}
