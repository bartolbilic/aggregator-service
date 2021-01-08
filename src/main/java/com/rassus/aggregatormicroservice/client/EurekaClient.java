package com.rassus.aggregatormicroservice.client;

import com.rassus.aggregatormicroservice.api.EurekaApi;
import com.rassus.aggregatormicroservice.models.ServiceResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import org.springframework.beans.factory.annotation.Value;

public class EurekaClient {
    @Value("eureka.url")
    private String url;

    private final EurekaApi api;

    public EurekaClient() {
        this.api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(EurekaApi.class, url);
    }

    public ServiceResponse getService(String instanceId) {
        return this.api.getService(instanceId);
    }
}
