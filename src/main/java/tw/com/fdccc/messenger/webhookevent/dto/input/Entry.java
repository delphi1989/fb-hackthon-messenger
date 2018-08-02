package tw.com.fdccc.messenger.webhookevent.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
public class Entry {

    @JsonProperty("id")
    private String id;
    @JsonProperty("time")
    private String time;
    @JsonProperty("messaging")
    private List<Messaging> messaging;
}
