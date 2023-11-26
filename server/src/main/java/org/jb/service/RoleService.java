package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jb.entity.Menu;
import org.jb.entity.Role;
import org.jb.repository.MenuRepository;
import org.jb.repository.RoleRepository;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class RoleService {
    @Inject
    private RoleRepository roleRepository;

    @Inject
    private MenuRepository menuRepository;

    public List<Role> getAllRole() {
        return roleRepository.getAllRole();
    }


    @Transactional
    public Role addRoleWithMenus(Role role) {
        roleRepository.addRole(role);
        for (Menu menu : role.getMenuList()) {
            menu.setRole(role);
            menuRepository.addMenu(menu);
        }
        return roleRepository.findById(role.getRoleId());
    }


    public Role updateRole(Long roleId, Role role) {
        return roleRepository.updateRole(roleId, role);
    }

    public String deleteRole(Long roleId) {
        return roleRepository.deleteRole(roleId);
    }
}
