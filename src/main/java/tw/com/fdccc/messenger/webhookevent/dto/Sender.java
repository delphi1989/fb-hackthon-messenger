package tw.com.fdccc.messenger.webhookevent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Sender {

    @JsonProperty("id")
    private String id;
}
