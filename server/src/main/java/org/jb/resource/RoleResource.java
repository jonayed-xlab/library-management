package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jb.entity.Role;
import org.jb.service.RoleService;

import java.util.List;

@Path("/{app.version}/role")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleResource {
    @Inject
    private RoleService roleService;

    @GET
    public Response getAllRole() {
        List<Role> roleList = roleService.getAllRole();
        if (roleList != null && roleList.size() > 0) {
            return Response.status(Response.Status.OK)
                    .entity(roleList)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Role not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @POST
    public Response addRole(Role role) {
        Role roleResponse = roleService.addRoleWithMenus(role);
        if (roleResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(roleResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Role not created")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("/{roleId}")
    public Response updateRole(@PathParam("roleId") Long roleId, Role role) {
        Role roleResponse = roleService.updateRole(roleId, role);
        if (roleResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(roleResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Role not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @DELETE
    @Path("/{roleId}")
    public Response deleteRole(@PathParam("roleId") Long roleId) {
        String roleResponse = roleService.deleteRole(roleId);
        return Response.status(Response.Status.OK)
                .entity(roleResponse)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
