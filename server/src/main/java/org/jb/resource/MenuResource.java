package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jb.entity.Menu;
import org.jb.service.MenuService;

import java.util.List;

@Path("/{app.version}/menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuResource {

    @Inject
    MenuService menuService;

    @GET
    public Response getAllMenu() {
        List<Menu> menuList = menuService.getAllMenu();
        if (menuList != null && menuList.size() > 0) {
            return Response.status(Response.Status.OK)
                    .entity(menuList)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Menu not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @POST
    public Response addMenu(Menu menu) {
        Menu menuResponse = menuService.addMenu(menu);
        if (menuResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(menuResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Menu not created")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("/{menuId}")
    public Response updateMenu(@PathParam("menuId") Long menuId, Menu Menu) {
        Menu menuResponse = menuService.updateMenu(menuId, Menu);
        if (menuResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(menuResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Menu not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @DELETE
    @Path("/{menuId}")
    public Response deleteMenu(@PathParam("menuId") Long menuId) {
        String menuResponse = menuService.deleteMenu(menuId);
        return Response.status(Response.Status.OK)
                .entity(menuResponse)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
