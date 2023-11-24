package org.jb.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jb.entity.User;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public List<User> getAllUser() {
        return listAll();
    }

    public User getUserByStudentId(Long id) {
        return findById(id);
    }

    @Transactional
    public User addUser(User user) {
        persist(user);
        return user;
    }

    @Transactional
    public User updateUser(User updatedUser) {
        User user = findById(updatedUser.getId());
        if (user != null) {
            persist(updatedUser);
            return updatedUser;
        }
        return null;
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = findById(id);
        if (user != null) {
            delete(user);
        }
    }
}
