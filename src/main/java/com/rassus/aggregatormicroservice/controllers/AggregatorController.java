package com.rassus.aggregatormicroservice.controllers;

import com.rassus.aggregatormicroservice.models.Measurement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

    @GetMapping("/readings")
    public Measurement getReadings() {
        return new Measurement(25, 12);
    }

}
