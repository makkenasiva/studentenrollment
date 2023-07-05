package com.practice.studentenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel student) {
        StudentModel addedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
    }
}
