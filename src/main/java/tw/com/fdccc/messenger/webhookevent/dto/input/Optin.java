package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Optin {

    @JsonProperty("ref")
    private String ref;
    @JsonProperty("user_ref")
    private String userRef;
}
