package com.rassus.aggregatormicroservice.services;

import com.rassus.aggregatormicroservice.client.MyEurekaClient;
import com.rassus.aggregatormicroservice.client.HumidityClient;
import com.rassus.aggregatormicroservice.client.TemperatureClient;
import com.rassus.aggregatormicroservice.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscoveryService {
    @Value("${service.temperature}")
    private String temperatureServiceName;

    @Value("${service.humidity}")
    private String humidityServiceName;

    private final MyEurekaClient client;

    public DiscoveryService(MyEurekaClient client) {
        this.client = client;
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
        return "http://" + service.getApplication().getInstance().get(0).getIpAddr() + ":" +
                service.getApplication().getInstance().get(0).getPort().getPort();
    }
}
