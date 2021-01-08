package com.rassus.aggregatormicroservice.controllers;

import com.rassus.aggregatormicroservice.models.Measurement;
import com.rassus.aggregatormicroservice.services.DiscoveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {
    private final DiscoveryService service;

    public AggregatorController(DiscoveryService service) {
        this.service = service;
    }

    @GetMapping("/readings")
    public Measurement getReadings() {
        return new Measurement(
                service.getTemperatureClient().getCurrentTemperature().getValue(),
                service.getHumidityClient().getCurrentHumidity().getValue());
    }

}
