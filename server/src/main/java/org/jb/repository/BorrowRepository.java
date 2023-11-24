package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jb.entity.Borrow;

@ApplicationScoped
public class BorrowRepository implements PanacheRepository<Borrow> {
}
