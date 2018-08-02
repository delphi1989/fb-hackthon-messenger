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

public class RewardListMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        GenericButton browseButton
                = getPostbackButton("兌換", "this is a test of message postback");
        GenericButton mission1AcceptButton
                = getWeburlButton("了解更多", "https://www.facebook.com/permalink.php?story_fbid=271419233414072&id=151792128710117");

        List<GenericButton> mission1Buttons = new LinkedList<>();
        mission1Buttons.add(browseButton);
        mission1Buttons.add(mission1AcceptButton);

        List<GenericButton> mission2Buttons = new LinkedList<>();
        mission2Buttons.add(browseButton);
        mission2Buttons.add(mission1AcceptButton);

        List<GenericButton> mission3Buttons = new LinkedList<>();
        mission3Buttons.add(browseButton);
        mission3Buttons.add(mission1AcceptButton);

        AttachmentElement reward1
                = getAttachmentElement("粉絲頁貼紙", "https://i.pinimg.com/originals/2a/7e/b3/2a7eb3843bf3964d00e7fd7ab4d9a66c.jpg", "造型貼紙 \n 350 枚金幣", mission1Buttons);
        AttachmentElement reward2
                = getAttachmentElement("杯套", "https://cdn01.pinkoi.com/product/CF8PSTHF/0/500x0.jpg", "造型杯套 \n 600 枚金幣", mission2Buttons);
        AttachmentElement reward3
                = getAttachmentElement("手機保護殼", "https://media-01.creema.net/user/1302517/exhibits/4434377/0_847d785f4a216a5a79fb990d712ce9d1_583x585.jpg", "手機保護殼 \n 1200 枚金幣", mission3Buttons);

        List<AttachmentElement> elements = new LinkedList<>();
        elements.add(reward1);
        elements.add(reward2);
        elements.add(reward3);

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

    private static GenericButton getWeburlButton(String title, String url) {

        GenericButton button = new GenericButton();
        button.setType("web_url");
        button.setTitle(title);
        button.setUrl(url);

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
