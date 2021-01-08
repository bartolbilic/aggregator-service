package com.rassus.aggregatormicroservice.controllers;

import com.rassus.aggregatormicroservice.models.Measurement;
import com.rassus.aggregatormicroservice.services.MeasurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {
    private final MeasurementService service;

    public AggregatorController(MeasurementService service) {
        this.service = service;
    }

    @GetMapping("/readings")
    public Measurement getReadings() {
        return new Measurement(service.getTemperature(), service.getHumidity());
    }

}
