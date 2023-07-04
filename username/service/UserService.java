package com.practice.studentenrollment.username.service;

import com.practice.studentenrollment.username.model.User;
import com.practice.studentenrollment.username.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public boolean doesUserExist(User user) {
        return userRepository.existsByUsername(user.getUsername());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
