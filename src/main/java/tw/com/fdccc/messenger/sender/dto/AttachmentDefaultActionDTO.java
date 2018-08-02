package tw.com.fdccc.messenger.sender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AttachmentDefaultActionDTO {

    @JsonProperty("type")
    public String type;
    @JsonProperty("url")
    public String url;
    @JsonProperty("webview_height_ratio")
    public String webviewHeightRatio;
}
