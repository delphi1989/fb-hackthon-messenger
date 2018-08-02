package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
public class MessageContainer {

    @JsonProperty("object")
    private String object;
    @JsonProperty("entry")
    private List<Entry> entry;
}
