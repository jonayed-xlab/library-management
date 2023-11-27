package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jb.dto.LoginDto;
import org.jb.dto.LoginResponseDto;
import org.jb.entity.Borrow;
import org.jb.entity.Role;
import org.jb.entity.User;
import org.jb.repository.UserRepository;
import org.jb.service.LoginService;
import org.jb.service.RoleService;
import org.jb.service.UserService;

import java.util.List;

@Path("/{app.version}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @Inject
    private LoginService loginService;

    @GET()
    @Path("/login")
    public Response getLoginInfo(@RequestBody LoginDto loginDto) {
        LoginResponseDto responseDto = loginService.getLoginInfo(loginDto);
        if (responseDto != null) {
            return Response.status(Response.Status.OK)
                    .entity(responseDto)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User name or password incorrect!")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("logout/{userId}")
    public Response logOut(@PathParam("userId") Long userid ){
        String response = loginService.logOut(userid);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(response)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
