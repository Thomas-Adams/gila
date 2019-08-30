package org.enargit.gwt.gila.client.data.rest;

import org.enargit.gwt.gila.client.dto.RoleDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public interface RoleService extends RestService {

    @GET
    @Path("/api/roles")
    void getRoles(@HeaderParam("Authentication") String authentication, MethodCallback<List<RoleDto>> roles);

    @POST
    @Path("/api/roles")
    void saveRole(@HeaderParam("Authentication") String authentication, RoleDto role, MethodCallback<RoleDto> callback);

}
