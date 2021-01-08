package com.rassus.aggregatormicroservice.services;

import com.rassus.aggregatormicroservice.client.HumidityClient;
import com.rassus.aggregatormicroservice.client.TemperatureClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {
    private final DiscoveryService discoveryService;
    private final TemperatureClient temperatureClient;
    private final HumidityClient humidityClient;

    @Value("${temperature.unit}")
    private String unit;

    public MeasurementService(DiscoveryService discoveryService) {
        this.discoveryService = discoveryService;
        this.temperatureClient = discoveryService.getTemperatureClient();
        this.humidityClient = discoveryService.getHumidityClient();
    }

    public double getTemperature() {
        return convert(temperatureClient.getCurrentTemperature().getValue());
    }

    public double getHumidity() {
        return humidityClient.getCurrentHumidity().getValue();
    }

    private double convert(double temperature) {
        if("K".equals(unit)) {
            return 273.15 + temperature;
        }
        return temperature;
    }
}
