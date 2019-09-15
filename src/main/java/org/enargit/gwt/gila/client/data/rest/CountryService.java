package org.enargit.gwt.gila.client.data.rest;

import org.enargit.gwt.gila.client.dto.CountryDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public interface CountryService extends RestService {


    String BASE_URL = "/api/countries";

    @GET
    @Path("/api/countries")
    void findAll(MethodCallback<List<CountryDto>> countries);

    @GET
    @Path("/api/countries/{id}")
    void findById(@PathParam("id") Long id, MethodCallback<CountryDto> country);

    @POST
    @Path("/api/countries")
    void save(CountryDto role, MethodCallback<CountryDto> callback);

    @GET
    @Path("/api/countries")
    void findAll(@QueryParam("offset") long offset, @QueryParam("limit") int limit, MethodCallback<List<CountryDto>> countries);


}
