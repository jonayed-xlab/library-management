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
    public  User updateUser(User user){
        return userService.updateUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id){
        userService.deleteUser(id);
    }
}
