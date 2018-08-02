package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentPayloadDTO {

    @JsonProperty("template_type")
    private String templateType;
    @JsonProperty("elements")
    private List<AttachmentElement> elements;
    @JsonProperty("text")
    private String text;
    @JsonProperty("buttons")
    private List<GenericButton> buttons;
    @JsonProperty("top_element_style")
    private String topElementStyle;
}
