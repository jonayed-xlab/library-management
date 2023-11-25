package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jb.entity.User;
import org.jb.service.UserService;

import java.util.List;

@Path("/{app.version}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @POST
    public User addUser(User user){
        return userService.addUser(user);
    }

    @PUT
    @Path("/{userId}")
    public  User updateUser(@PathParam("userId") Long userId, User user){
        return userService.updateUser(userId, user);
    }

    @DELETE
    @Path("/{userId}")
    public void deleteUser(@PathParam("userId") Long id){
        userService.deleteUser(id);
    }
}
