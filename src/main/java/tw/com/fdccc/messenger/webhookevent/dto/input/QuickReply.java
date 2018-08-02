package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QuickReply {

    @JsonProperty("payload")
    private String payload;
}
