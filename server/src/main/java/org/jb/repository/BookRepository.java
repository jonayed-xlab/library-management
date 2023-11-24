package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.Book;

import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public List<Book> getAllBooks() {
        return listAll();
    }

    public Book getBookById(Long id) {
        return findById(id);
    }

    @Transactional
    public Book addBook(Book book) {
        persist(book);
        return book;
    }

    @Transactional
    public Book updateBook(Book updatedBook) {
        Book book = findById(updatedBook.getId());
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
        }
        return book;
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = findById(id);
        if (book != null) {
            delete(book);
        }
    }
}
