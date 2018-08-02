package tw.com.fdccc.messenger.profile.dto.persistentmenu;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CallToActionComponent {

    @JsonProperty("title")
    public String title;
    @JsonProperty("type")
    public String type;
    @JsonProperty("payload")
    public String payload;
    @JsonProperty("url")
    public String url;
    @JsonProperty("webview_height_ratio")
    public String webviewHeightRatio;
}
