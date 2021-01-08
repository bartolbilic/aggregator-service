package com.rassus.aggregatormicroservice.models;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationDto {
    private String name;
    private List<InstanceDto> instance;
}
