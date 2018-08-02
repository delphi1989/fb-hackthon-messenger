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

public class RankingBoardMessageFactory {

    public static SendMessageDTO build(String recipientId) {

        AttachmentElement rankLike
                = getNoBtnsAttachmentElement("按讚王", "http://dreamers.tw/wp-content/uploads/2017/08/%E6%8C%89%E8%AE%9A-01.jpg", "本週情報官，貼文逃不脫你的手掌!");
        AttachmentElement rankComment
                = getNoBtnsAttachmentElement("留言王", "https://blog.feversocial.com/tw/wp-content/uploads/sites/9/2012/04/%E7%95%99%E8%A8%80.png", "本週師爺，舌辯群雄!");
        AttachmentElement rankRate
                = getNoBtnsAttachmentElement("評價王", "http://gamewikia.com/uploads/2018/05/12/1.1-e5afd2a1d5b3310a67c96c528a4c0294.jpg", "本週神秘客，拜託您高抬貴手...");

        List<AttachmentElement> elements = new LinkedList<>();
        elements.add(rankLike);
        elements.add(rankComment);
        elements.add(rankRate);


        GenericButton rankBoardButton
                = getWeburlButton("更多名單", "http://rank.shoryuken.com/rankings/rank/SF5");
        List<GenericButton> buttons = new LinkedList<>();
        buttons.add(rankBoardButton);

        AttachmentPayloadDTO payloadDTO = new AttachmentPayloadDTO();
        payloadDTO.setTemplateType("list");
        payloadDTO.setTopElementStyle("LARGE");
        payloadDTO.setElements(elements);
        payloadDTO.setButtons(buttons);

        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setType("template");
        attachmentDTO.setPayload(payloadDTO);

        MessageDTO message = new MessageDTO();
        message.setAttachment(attachmentDTO);

        Recipient recipient = new Recipient();
        recipient.setId(recipientId);

        SendMessageDTO sendMessageDTO = new SendMessageDTO();
        sendMessageDTO.setRecipient(recipient);
        sendMessageDTO.setMessage(message);

        return sendMessageDTO;
    }

    private static AttachmentElement getNoBtnsAttachmentElement(
            String title,
            String imageUrl,
            String subtitle) {

        AttachmentElement element = new AttachmentElement();

        element.setTitle(title);
        element.setImageUrl(imageUrl);
        element.setSubtitle(subtitle);

        return element;
    }

    private static GenericButton getWeburlButton(String title, String url) {

        GenericButton button = new GenericButton();
        button.setType("web_url");
        button.setTitle(title);
        button.setUrl(url);

        return button;
    }
}
