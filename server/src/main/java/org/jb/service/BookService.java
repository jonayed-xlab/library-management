package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.entity.Book;
import org.jb.repository.BookRepository;

import java.util.List;

@ApplicationScoped
public class BookService {

    @Inject
    private BookRepository bookRepository;

    public List<Book> getAllBook() {
        return bookRepository.getAllBooks();
    }

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public Book updateBook(Long bookId, Book book){
        return bookRepository.updateBook(bookId, book);
    }

    public String deleteBook(Long bookId){
        return bookRepository.deleteBook(bookId);
    }
}