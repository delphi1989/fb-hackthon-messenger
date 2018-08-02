package tw.com.fdccc.messenger.sender.util;

import tw.com.fdccc.messenger.sender.dto.AttachmentDTO;
import tw.com.fdccc.messenger.sender.dto.AttachmentPayloadDTO;
import tw.com.fdccc.messenger.sender.dto.GenericButton;
import tw.com.fdccc.messenger.sender.dto.MessageDTO;
import tw.com.fdccc.messenger.sender.dto.SendMessageDTO;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;

import java.util.LinkedList;
import java.util.List;

public class DashBoardMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        GenericButton dashboardButton
                = getWeburlButton("前往 KOL", "https://kol-2018.appspot.com/");
        List<GenericButton> buttons = new LinkedList<>();
        buttons.add(dashboardButton);

        AttachmentPayloadDTO payloadDTO = new AttachmentPayloadDTO();
        payloadDTO.setTemplateType("button");
        payloadDTO.setText("Welcome to our home page !!!");
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

    private static GenericButton getWeburlButton(String title, String url) {

        GenericButton button = new GenericButton();
        button.setType("web_url");
        button.setTitle(title);
        button.setUrl(url);

        return button;
    }
}
