package com.practice.studentenrollment.SearchApi.Repository;

import com.practice.studentenrollment.SearchApi.Model.StudentSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentSearch, Integer> {
    List<StudentSearch> findByFirstNameIgnoreCase(String firstName);
    List<StudentSearch> findByLastNameIgnoreCase(String lastName);
    List<StudentSearch> findByUserNameIgnoreCase(String userName);
    List<StudentSearch> findByNameIgnoreCase(String name);
}
