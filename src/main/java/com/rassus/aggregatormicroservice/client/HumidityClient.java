package com.rassus.aggregatormicroservice.client;

import com.rassus.aggregatormicroservice.api.HumidityApi;
import com.rassus.aggregatormicroservice.models.HumidityResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

public class HumidityClient {
    private final HumidityApi api;

    public HumidityClient(String url) {
        this.api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(HumidityApi.class, url);
    }

    public HumidityResponse getCurrentHumidity() {
        return this.api.getHumidity();
    }
}
