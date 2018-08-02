package tw.com.fdccc.messenger.sender.util;

import tw.com.fdccc.messenger.sender.dto.AttachmentDTO;
import tw.com.fdccc.messenger.sender.dto.AttachmentPayloadDTO;
import tw.com.fdccc.messenger.sender.dto.GenericButton;
import tw.com.fdccc.messenger.sender.dto.MessageDTO;
import tw.com.fdccc.messenger.sender.dto.SendMessageDTO;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;

import java.util.LinkedList;
import java.util.List;

public class CurrentPropertyMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        GenericButton browseButton
                = getPayloadButton("詳細內容", "this is a test of message postback");
        List<GenericButton> buttons = new LinkedList<>();
        buttons.add(browseButton);

        AttachmentPayloadDTO payloadDTO = new AttachmentPayloadDTO();
        payloadDTO.setTemplateType("button");
        payloadDTO.setText("你現在所擁有的財產為: 100 $");
        payloadDTO.setButtons(buttons);

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

    private static GenericButton getPayloadButton(String title, String payload) {

        GenericButton button = new GenericButton();
        button.setType("postback");
        button.setTitle(title);
        button.setPayload(payload);

        return button;
    }
}
