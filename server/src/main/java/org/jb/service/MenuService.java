package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.entity.Menu;
import org.jb.repository.MenuRepository;

import java.util.List;

@ApplicationScoped
public class MenuService {
    @Inject
    MenuRepository menuRepository;

    public List<Menu> getAllMenu() {
        return menuRepository.getAllMenus();
    }

    public Menu addMenu(Menu book) {
        return menuRepository.addMenu(book);
    }

    public Menu updateMenu(Long bookId, Menu book) {
        return menuRepository.updateMenu(bookId, book);
    }

    public String deleteMenu(Long bookId) {
        return menuRepository.deleteMenu(bookId);
    }

}
