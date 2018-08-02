package tw.com.fdccc.messenger.profile.dto.getstarted;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GetStartedDTO {

    @JsonProperty("payload")
    private String payload;
}
