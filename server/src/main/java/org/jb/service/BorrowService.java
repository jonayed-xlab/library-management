package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.repository.BorrowRepository;

@ApplicationScoped
public class BorrowService {

    @Inject
    private BorrowRepository borrowRepository;
}
