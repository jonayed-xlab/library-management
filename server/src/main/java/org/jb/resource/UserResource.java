package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jb.entity.User;
import org.jb.service.UserService;

import java.util.List;

@Path("/{app.version}/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    public Response getAllUser() {
        List<User> userList = userService.getAllUser();
        if (userList != null && userList.size() > 0) {
            return Response.status(Response.Status.OK)
                    .entity(userList)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @POST
    public Response addUser(User user) {
        User userResponse = userService.addUser(user);
        if (userResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(userResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("User not created")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") Long userId, User user) {
        User userResponse = userService.updateUser(userId, user);
        if (userResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(userResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") Long id) {
        String userResponse = userService.deleteUser(id);
        return Response.status(Response.Status.OK)
                .entity(userResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
