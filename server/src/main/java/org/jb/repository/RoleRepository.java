package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.Menu;
import org.jb.entity.Role;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class RoleRepository implements PanacheRepository<Role> {

    public List<Role> getAllRole() {
        List<Role> roles = listAll();
        return roles;
    }

    @Transactional
    public Role addRole(Role role) {
        persist(role);
        return role;
    }

    @Transactional
    public Role updateRole(Long roleId, Role updatedRole) {
        Role role = findById(roleId);
        if (role != null) {
            role.setRoleName(updatedRole.getRoleName());
            role.setDescription(updatedRole.getDescription());
            return role;
        }
        return null;
    }

    @Transactional
    public String deleteRole(Long roleId) {
        Role role = findById(roleId);
        if (role != null) {
            delete(role);
            return "Role delete successfully";
        }
        return "Role not found";
    }
}
