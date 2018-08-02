package tw.com.fdccc.messenger.profile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tw.com.fdccc.messenger.profile.dto.getstarted.GetStartedDTO;
import tw.com.fdccc.messenger.profile.dto.persistentmenu.PersistentMenuDTO;

import java.util.List;

@Data
public class BotPropertyDTO {

    // @JsonProperty(value = "account_linking_url")
    // private String accountLinkingUrl;
    @JsonProperty(value = "persistent_menu")
    private List<PersistentMenuDTO> persistentMenu;
    @JsonProperty(value = "get_started")
    private GetStartedDTO getStarted;
}
