package com.rassus.aggregatormicroservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PortDto {
    @JsonProperty("$")
    private int port;
}
