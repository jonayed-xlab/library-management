package org.jb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jb.entity.Book;
import org.jb.service.BookService;

import java.util.List;

@Path("/{app.version}/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookService bookService;

    @GET
    public Response getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        if (bookList != null && bookList.size() > 0) {
            return Response.status(Response.Status.OK)
                    .entity(bookList)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @POST
    public Response addBook(Book book) {
        Book bookResponse = bookService.addBook(book);
        if (bookResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(bookResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Book not created")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("/{bookId}")
    public Response updateBook(@PathParam("bookId") Long bookId, Book Book) {
        Book bookResponse = bookService.updateBook(bookId, Book);
        if (bookResponse != null) {
            return Response.status(Response.Status.OK)
                    .entity(bookResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @DELETE
    @Path("/{bookId}")
    public Response deleteBook(@PathParam("bookId") Long bookId) {
        String bookResponse = bookService.deleteBook(bookId);
        return Response.status(Response.Status.OK)
                .entity(bookResponse)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
