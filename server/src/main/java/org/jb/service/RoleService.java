package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jb.entity.Role;
import org.jb.repository.RoleRepository;

import java.util.List;

@ApplicationScoped
public class RoleService {
    @Inject
    private RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return roleRepository.getAllRole();
    }

    public Role addRole(Role role) {
        return roleRepository.addRole(role);
    }

    public Role updateRole(Long roleId, Role role) {
        return roleRepository.updateRole(roleId, role);
    }

    public String deleteRole(Long roleId) {
        return roleRepository.deleteRole(roleId);
    }
}
