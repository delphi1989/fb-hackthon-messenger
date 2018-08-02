package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;

@Data
public class SendMessageDTO {

    @JsonProperty("messaging_type")
    private String messagingType;
    @JsonProperty("recipient")
    private Recipient recipient;
    @JsonProperty("message")
    private MessageDTO message;
}
