package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentElement {

    @JsonProperty("title")
    private String title;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("default_action")
    private AttachmentDefaultActionDTO defaultAction;
    @JsonProperty("buttons")
    public List<GenericButton> buttons;
}
