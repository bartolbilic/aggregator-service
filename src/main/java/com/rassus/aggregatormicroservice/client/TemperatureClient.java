package com.rassus.aggregatormicroservice.client;

import com.rassus.aggregatormicroservice.api.TemperatureApi;
import com.rassus.aggregatormicroservice.models.TemperatureResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

public class TemperatureClient {
    private final TemperatureApi api;

    public TemperatureClient(String url) {
        this.api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(TemperatureApi.class, url);
    }

    public TemperatureResponse getCurrentTemperature() {
        return api.getTemperature();
    }

}
