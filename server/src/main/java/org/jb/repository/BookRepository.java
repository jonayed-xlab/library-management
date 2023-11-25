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
    public Book updateBook(Long bookId, Book updatedBook) {
        Book book = findById(bookId);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setBookLimit(updatedBook.getBookLimit());
            book.setCategory(updatedBook.getCategory());
            book.setName(updatedBook.getName());
            book.setSeries(updatedBook.getSeries());
            book.setDelayFine(updatedBook.getDelayFine());
            book.setDescription(updatedBook.getDescription());
            book.setStatus(updatedBook.getStatus());
            book.setIsbnNumber(updatedBook.getIsbnNumber());
            book.setPageNo(updatedBook.getPageNo());
            book.setPhotoKey(updatedBook.getPhotoKey());
            book.setPublisher(updatedBook.getPublisher());
            book.setYear(updatedBook.getYear());
            return book;
        }
        return null;
    }

    @Transactional
    public String deleteBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null) {
            delete(book);
            return "Book deleted successfully";
        }
        return "Book not found!";
    }
}
