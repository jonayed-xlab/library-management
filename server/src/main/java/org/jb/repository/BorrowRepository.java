package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.Borrow;
import org.jb.entity.Borrow;

import java.util.List;

@ApplicationScoped
public class BorrowRepository implements PanacheRepository<Borrow> {
    public List<Borrow> getAllBorrows() {
        return listAll();
    }

    public Borrow getBorrowById(Long borrowId) {
        return findById(borrowId);
    }

    @Transactional
    public Borrow addBorrow(Borrow borrow) {
        persist(borrow);
        return borrow;
    }

    @Transactional
    public Borrow updateBorrow(Long borrowId, Borrow updatedBorrow) {
        Borrow borrow = findById(borrowId);
        if (borrow != null) {
            borrow.setCheckinDateTime(updatedBorrow.getCheckinDateTime());
            borrow.setCheckoutDateTime(updatedBorrow.getCheckoutDateTime());
            borrow.setFromDateTime(updatedBorrow.getFromDateTime());
            borrow.setToDateTime(updatedBorrow.getToDateTime());
            borrow.setTotalDay(updatedBorrow.getTotalDay());
            borrow.setReturnTotalDay(updatedBorrow.getReturnTotalDay());
            borrow.setDelayFine(updatedBorrow.getDelayFine());
            borrow.setDescription(updatedBorrow.getDescription());
            borrow.setStatus(updatedBorrow.getStatus());
            return borrow;
        }
        return null;
    }

    @Transactional
    public String deleteBorrow(Long borrowId) {
        Borrow borrow = findById(borrowId);
        if (borrow != null) {
            delete(borrow);
            return "Borrow deleted successfully";
        }
        return "Borrow not found!";
    }
}
