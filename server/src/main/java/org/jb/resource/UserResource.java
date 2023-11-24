package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.jb.service.UserService;

@Path("/{app.version}")
public class UserResource {
    @Inject
    private UserService userService;
}
