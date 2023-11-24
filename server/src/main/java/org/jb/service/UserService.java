package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.repository.UserRepository;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;
}
