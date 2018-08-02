package tw.com.fdccc.messenger.sender.util;

import tw.com.fdccc.messenger.sender.dto.GenericButton;
import tw.com.fdccc.messenger.sender.dto.AttachmentDTO;
import tw.com.fdccc.messenger.sender.dto.AttachmentElement;
import tw.com.fdccc.messenger.sender.dto.AttachmentPayloadDTO;
import tw.com.fdccc.messenger.sender.dto.MessageDTO;
import tw.com.fdccc.messenger.sender.dto.SendMessageDTO;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;

import java.util.LinkedList;
import java.util.List;

public class MissionListMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        GenericButton browseButton
            = getPostbackButton("詳細內容", "this is a test of message postback");
        GenericButton mission1AcceptButton
            = getWeburlButton("領取任務", "https://www.facebook.com/permalink.php?story_fbid=271419233414072&id=151792128710117");

        List<GenericButton> mission1Buttons = new LinkedList<>();
        mission1Buttons.add(browseButton);
        mission1Buttons.add(mission1AcceptButton);


        GenericButton mission2AcceptButton
                = getWeburlButton("領取任務", "https://www.facebook.com/permalink.php?story_fbid=271423920080270&id=151792128710117");

        List<GenericButton> mission2Buttons = new LinkedList<>();
        mission2Buttons.add(browseButton);
        mission2Buttons.add(mission2AcceptButton);

        GenericButton mission3AcceptButton
                = getWeburlButton("領取任務", "https://www.facebook.com/permalink.php?story_fbid=271424393413556&id=151792128710117");

        List<GenericButton> mission3Buttons = new LinkedList<>();
        mission3Buttons.add(browseButton);
        mission3Buttons.add(mission3AcceptButton);

        AttachmentElement mission1
            = getAttachmentElement("任務一", "http://canadianmk.net/Portals/cmkn/Images/mission%202%20small.png", "互動-留下屬於你的表情", mission1Buttons);
        AttachmentElement mission2
            = getAttachmentElement("任務二", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSczi1qUCwV878vejyAgA8Mth3JTPTZCyo0c522R7hAqCH2r_H", "互動-評論一篇貼文", mission2Buttons);
        AttachmentElement mission3
            = getAttachmentElement("任務三", "http://www.axema.fr/PublishingImages/Pages%20institutionnelles/706%20x%20360/Mission-entreprise.jpg", "互動-在指定貼文按讚", mission3Buttons);

        List<AttachmentElement> elements = new LinkedList<>();
        elements.add(mission1);
        elements.add(mission2);
        elements.add(mission3);

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
