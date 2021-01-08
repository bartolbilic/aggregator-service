package com.rassus.aggregatormicroservice.api;

import com.rassus.aggregatormicroservice.models.HumidityResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface HumidityApi {
    @GET
    @Path("/current-reading")
    HumidityResponse getHumidity();
}
