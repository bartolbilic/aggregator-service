package com.rassus.aggregatormicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Measurement {
    private double temperature;
    private double humidity;
}
