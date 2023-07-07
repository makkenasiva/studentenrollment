package com.practice.studentenrollment.username.repository;

import com.practice.studentenrollment.username.model.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserName, Long> {
    UserName findByUsernameIgnoreCase(String username);
}
