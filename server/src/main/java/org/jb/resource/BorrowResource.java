package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jb.entity.Borrow;
import org.jb.service.BorrowService;

import java.util.List;

@Path("/{app.version}/borrow")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BorrowResource {

    @Inject
    private BorrowService borrowService;

    @GET
    public Response getAllBorrow() {
        List<Borrow> borrowList = borrowService.getAllBorrows();
        if (borrowList != null && borrowList.size() > 0) {
            return Response.status(Response.Status.OK)
                    .entity(borrowList)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Borrow not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @POST
    public Response addBorrow(Borrow menu) {
        Borrow borrowResponse = borrowService.addBorrow(menu);
        if (borrowResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(borrowResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Borrow not created")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("/{borrowId}")
    public Response updateBorrow(@PathParam("borrowId") Long borrowId, Borrow Borrow) {
        Borrow borrowResponse = borrowService.updateBorrow(borrowId, Borrow);
        if (borrowResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(borrowResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Borrow not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @DELETE
    @Path("/{borrowId}")
    public Response deleteBorrow(@PathParam("borrowId") Long borrowId) {
        String borrowResponse = borrowService.deleteBorrow(borrowId);
        return Response.status(Response.Status.OK)
                .entity(borrowResponse)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
