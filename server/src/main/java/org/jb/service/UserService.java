package org.jb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jb.dto.LoginDto;
import org.jb.entity.User;
import org.jb.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Transactional
    public User findByUsernameAndPassword(String userName, String password) {
        return userRepository.findByUsernameAndPassword(userName, password);
    }

    public User findByUserId(Long userId){
        return userRepository.findById(userId);
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public User updateUser(Long userId, User user) {
        return userRepository.updateUser(userId, user);
    }

    public String deleteUser(Long id) {
        String userResponse = userRepository.deleteUser(id);
        return userResponse;
    }
}
