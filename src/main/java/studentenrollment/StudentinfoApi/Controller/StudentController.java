package studentenrollment.StudentinfoApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;
import studentenrollment.StudentinfoApi.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private  StudentRepository studentRepository;
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> addStudent(@RequestBody StudentModel student) {
        User newStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }
    @GetMapping("/roles")
    public void insertRoles(){
        studentRepository.createRoleTable();

        studentService.insertData(1,"student");
        studentService.insertData(2,"admin");
        studentService.insertData(3,"parent");
        studentService.insertData(4,"sibiling");
        studentService.insertData(5,"teacher");

    }

}
