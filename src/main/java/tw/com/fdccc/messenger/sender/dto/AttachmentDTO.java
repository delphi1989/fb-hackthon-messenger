package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AttachmentDTO {

    @JsonProperty("type")
    private String type;
    @JsonProperty("payload")
    private AttachmentPayloadDTO payload;
}
