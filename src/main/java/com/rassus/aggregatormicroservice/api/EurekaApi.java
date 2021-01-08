package com.rassus.aggregatormicroservice.api;

import com.rassus.aggregatormicroservice.models.ServiceResponse;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface EurekaApi {

    @Path("/eureka/apps/{instanceId}")
    @GET
    ServiceResponse getService(@RequestParam String instanceId);
}
