package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.Menu;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {
    public List<Menu> getAllMenus() {
        return listAll();
    }

    public Menu getMenuById(Long menuId) {
        return findById(menuId);
    }

    @Transactional
    public Menu addMenu(Menu menu) {
        persist(menu);
        return menu;
    }

    @Transactional
    public Menu updateMenu(Long menuId, Menu updatedMenu) {
        Menu menu = findById(menuId);
        if (menu != null) {
            menu.setName(updatedMenu.getName());
            menu.setDescription(updatedMenu.getDescription());

            return menu;
        }
        return null;
    }

    @Transactional
    public String deleteMenu(Long menuId) {
        Menu menu = findById(menuId);
        if (menu != null) {
            delete(menu);
            return "Menu deleted successfully";
        }
        return "Menu not found!";
    }

}
