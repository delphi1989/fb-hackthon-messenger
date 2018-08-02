package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Postback {

    @JsonProperty("title")
    private String title;
    @JsonProperty("payload")
    private String payload;
    @JsonProperty("referral")
    private Referral referral;
}
