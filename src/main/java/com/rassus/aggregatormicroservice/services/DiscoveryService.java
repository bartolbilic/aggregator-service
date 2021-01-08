package com.rassus.aggregatormicroservice.services;

import com.rassus.aggregatormicroservice.client.EurekaClient;
import com.rassus.aggregatormicroservice.client.HumidityClient;
import com.rassus.aggregatormicroservice.client.TemperatureClient;
import com.rassus.aggregatormicroservice.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Value;

public class DiscoveryService {
    @Value("service.temperature")
    private String temperatureServiceName;

    @Value("service.humidity")
    private String humidityServiceName;

    private final EurekaClient client;

    public DiscoveryService() {
        this.client = new EurekaClient();
    }

    public TemperatureClient getTemperatureClient() {
        String url = toAddress(client.getService(temperatureServiceName));
        return new TemperatureClient(url);
    }

    public HumidityClient getHumidityClient() {
        String url = toAddress(client.getService(humidityServiceName));
        return new HumidityClient(url);
    }

    public String toAddress(ServiceResponse service) {
        return service.getApplication().getInstance().getIpAddr() + ":" +
                service.getApplication().getInstance().getPort().getPort();
    }
}