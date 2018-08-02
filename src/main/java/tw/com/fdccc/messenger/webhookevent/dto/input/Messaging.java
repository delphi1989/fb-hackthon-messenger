package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tw.com.fdccc.messenger.webhookevent.dto.Recipient;
import tw.com.fdccc.messenger.webhookevent.dto.Sender;

@Data
public class Messaging {

    @JsonProperty("sender")
    private Sender sender;
    @JsonProperty("recipient")
    private Recipient recipient;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("postback")
    private Postback postback;
    @JsonProperty("optin")
    private Optin optin;
    @JsonProperty("message")
    private Message message;
}
