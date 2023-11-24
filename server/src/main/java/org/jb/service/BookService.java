package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.repository.BookRepository;

@ApplicationScoped
public class BookService {

    @Inject
    private BookRepository bookRepository;
}
