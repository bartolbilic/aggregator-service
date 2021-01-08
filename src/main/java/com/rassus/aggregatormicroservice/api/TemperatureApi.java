package com.rassus.aggregatormicroservice.api;

import com.rassus.aggregatormicroservice.models.TemperatureResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface TemperatureApi {
    @GET
    @Path("/current-reading")
    TemperatureResponse getTemperature();
}
