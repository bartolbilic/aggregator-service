package com.rassus.aggregatormicroservice.api;

import com.rassus.aggregatormicroservice.models.ServiceResponse;
import feign.Headers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EurekaApi {

    @Headers("Accept: application/json")
    @Path("/eureka/apps/{instanceId}")
    @GET
    ServiceResponse getService(@PathParam("instanceId") String instanceId);
}
