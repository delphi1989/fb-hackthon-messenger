package tw.com.fdccc.messenger.profile.dto.persistentmenu;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
public class PersistentMenuDTO {

    @JsonProperty("locale")
    private String locale;
    @JsonProperty("composer_input_disabled")
    private boolean composerInputDisabled;
    @JsonProperty("call_to_actions")
    private List<CallToActionDTO> callToActions;
}
