package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.repository.RoleRepository;

@ApplicationScoped
public class RoleService {
    @Inject
    private RoleRepository roleRepository;
}
