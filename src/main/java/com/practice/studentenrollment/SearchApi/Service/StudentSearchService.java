package com.practice.studentenrollment.SearchApi.Service;

import com.practice.studentenrollment.SearchApi.Model.StudentSearch;
import com.practice.studentenrollment.SearchApi.Repository.StudentSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSearchService {
    @Autowired
    private StudentSearchRepository studentSearchRepository;

    public StudentSearch addStudents(StudentSearch studentSearch) {
        // Add logic to save the student record
        return studentSearchRepository.save(studentSearch);
    }

    public List<StudentSearch> studentSearchList() {
        // Add logic to retrieve all student records
        return studentSearchRepository.findAll();
    }

    public Optional<StudentSearch> getStudentByid(Integer id) {
        // Add logic to retrieve a student record by ID
        return studentSearchRepository.findById(id);
    }

    public List<StudentSearch> getStudentsByFirstNameIgnoreCase(String firstName) {
        // Add logic to retrieve student records by first name (case-insensitive)
        return studentSearchRepository.findByFirstNameIgnoreCase(firstName);
    }

    public List<StudentSearch> getStudent(String lastName) {
        // Add logic to retrieve student records by last name (case-insensitive)
        return studentSearchRepository.findByLastNameIgnoreCase(lastName);
    }

    public List<StudentSearch> studentByUserName(String userName) {
        // Add logic to retrieve student records by username (case-insensitive)
        return studentSearchRepository.findByUserNameIgnoreCase(userName);
    }

    public List<StudentSearch> studentByname(String name) {
        // Add logic to retrieve student records by name (case-insensitive)
        return studentSearchRepository.findByNameIgnoreCase(name);
    }
}
