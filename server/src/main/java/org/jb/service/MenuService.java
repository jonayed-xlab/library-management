package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.repository.MenuRepository;

@ApplicationScoped
public class MenuService {
    @Inject
    MenuRepository menuRepository;

}
