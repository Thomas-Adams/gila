package org.enargit.gwt.gila.client.data.rest;

import org.enargit.gwt.gila.client.data.dispatcher.BasicAuthDispatcher;
import org.enargit.gwt.gila.client.data.request.RoleRequest;
import org.enargit.gwt.gila.client.dto.RoleDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public interface RoleService extends RestService {

    @GET
    @Path("/api/roles")
    void findAll(MethodCallback<List<RoleDto>> roles);

    @GET
    @Path("/api/roles/{id}")
    void findById(@PathParam("id") Long id, MethodCallback<RoleDto> role);

    @POST
    @Path("/api/roles")
    void save(RoleDto role, MethodCallback<RoleDto> callback);

    @GET
    @Path("/api/roles")
    void findAll(@QueryParam("offset") long offset, @QueryParam("limit") int limit, MethodCallback<List<RoleDto>> roles);


    @GET
    @Path("/api/roles")
    @Options(dispatcher= BasicAuthDispatcher.class)
    void findAll(RoleRequest roleRequest, MethodCallback<List<RoleDto>> roles);

}
