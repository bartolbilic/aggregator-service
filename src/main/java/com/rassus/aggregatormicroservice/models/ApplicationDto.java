package com.rassus.aggregatormicroservice.models;

import lombok.Data;

@Data
public class ApplicationDto {
    private String name;
    private InstanceDto instance;
}
