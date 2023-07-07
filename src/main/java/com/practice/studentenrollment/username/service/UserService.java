package com.practice.studentenrollment.username.service;

import com.practice.studentenrollment.username.model.UserName;
import com.practice.studentenrollment.username.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUsernameExists(String username) {
        UserName existingUser = userRepository.findByUsernameIgnoreCase(username);
        return existingUser !=null;
}

    public UserName storeUserName(String username) {
        UserName user = new UserName(username);
        return userRepository.save(user);
    }
}