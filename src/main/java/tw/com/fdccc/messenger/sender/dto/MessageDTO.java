package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {

    @JsonProperty("text")
    private String text;
    @JsonProperty("attachment")
    private AttachmentDTO attachment;
}
