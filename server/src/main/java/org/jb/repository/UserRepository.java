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

    public User getUserByStudentId(Long userId) {
        return findById(userId);
    }

    @Transactional
    public User addUser(User user) {
        persist(user);
        return user;
    }

    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        User user = findById(userId);
        if (user != null) {
            user.setActive(updatedUser.getActive());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setFullName(updatedUser.getFullName());
            user.setUserName(updatedUser.getUserName());
            user.setDateOfBirth(updatedUser.getDateOfBirth());
            user.setEmail(updatedUser.getEmail());
            user.setDepartment(updatedUser.getDepartment());
            user.setEnrollYear(updatedUser.getEnrollYear());
            user.setRoleId(updatedUser.getRoleId());
            user.setPhotoId(updatedUser.getPhotoId());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setPresentAddress(updatedUser.getPresentAddress());
            user.setPermanentAddress(updatedUser.getPermanentAddress());
            user.setStudentId(updatedUser.getStudentId());
            user.setPassword(updatedUser.getPassword());

            return user;
        }
        return null;
    }

    @Transactional
    public String deleteUser(Long id) {
        User user = findById(id);
        if (user != null) {
            delete(user);
            return "User delete successfully";
        }
        return "User not found";
    }
}
