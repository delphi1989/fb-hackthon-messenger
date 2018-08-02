package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Referral {

    @JsonProperty("ref")
    private String ref;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
}
