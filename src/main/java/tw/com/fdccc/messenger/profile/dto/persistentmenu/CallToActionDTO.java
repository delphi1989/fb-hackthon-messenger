package tw.com.fdccc.messenger.profile.dto.persistentmenu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallToActionDTO {

    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("payload")
    private String payload;
    @JsonProperty("call_to_actions")
    private List<CallToActionComponent> callToActions;
}
