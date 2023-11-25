package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.entity.Borrow;
import org.jb.repository.BorrowRepository;

import java.util.List;

@ApplicationScoped
public class BorrowService {

    @Inject
    private BorrowRepository borrowRepository;

    public List<Borrow> getAllBorrows() {
        return borrowRepository.getAllBorrows();
    }

    public Borrow addBorrow(Borrow book) {
        return borrowRepository.addBorrow(book);
    }

    public Borrow updateBorrow(Long bookId, Borrow book) {
        return borrowRepository.updateBorrow(bookId, book);
    }

    public String deleteBorrow(Long bookId) {
        return borrowRepository.deleteBorrow(bookId);
    }
}
