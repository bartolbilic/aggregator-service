package com.rassus.aggregatormicroservice.models;

import lombok.Data;

@Data
public class InstanceDto {
    private String ipAddr;
    private PortDto port;
}
