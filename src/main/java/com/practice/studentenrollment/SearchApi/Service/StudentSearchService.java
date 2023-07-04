package com.practice.studentenrollment.SearchApi.Service;

import com.practice.studentenrollment.SearchApi.Model.StudentSearch;
import com.practice.studentenrollment.SearchApi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSearchService {
    @Autowired
    private StudentRepository studentSearchRepository;

    public StudentSearch addStudents(StudentSearch studentSearch) {
        this.studentSearchRepository.save(studentSearch);
        return studentSearch;
    }

    public List<StudentSearch> studentSearchList() {
        return this.studentSearchRepository.findAll();
    }

    public Optional<StudentSearch> getStudentByid(Integer studentid) {
        return this.studentSearchRepository.findById(studentid);
    }

    public List<StudentSearch> getStudentsByFirstName(String firstName) {
        List<StudentSearch> students = studentSearchRepository.findByFirstNameIgnoreCase(firstName);
        if (students.isEmpty()) {
            System.out.println("Invalid input: Name not found. Please try again.");
        }
        return students;
    }

    public List<StudentSearch> getStudent(String lastName) {
        List<StudentSearch> students = studentSearchRepository.findByLastNameIgnoreCase(lastName);
        if (students.isEmpty()) {
            System.out.println("Invalid input: Name not found. Please try again.");
        }
        return students;
    }

    public List<StudentSearch> studentByUserName(String userName) {
        List<StudentSearch> students = studentSearchRepository.findByUserNameIgnoreCase(userName);
        if (students.isEmpty()) {
            System.out.println("Invalid input: Name not found. Please try again.");
        }
        return students;
    }

    public List<StudentSearch> studentByname(String name) {
        List<StudentSearch> students = studentSearchRepository.findByNameIgnoreCase(name);
        if (students.isEmpty()) {
            System.out.println("Invalid input: Name not found. Please try again.");
        }
        return students;
    }
}