package studentenrollment.StudentinfoApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.StudentinfoApi.Model.UserRole;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;
import studentenrollment.StudentinfoApi.Repository.UserRepo;
import studentenrollment.StudentinfoApi.Repository.UserRoleRepository;
import studentenrollment.StudentinfoApi.Service.RoleService;
import studentenrollment.StudentinfoApi.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private  StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentModel student) {
        return studentService.addStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);

    }
    @PostMapping("/add-roles")
    public ResponseEntity<String> addRoles() {
        try {
            roleService.insertData(1, "parent");
            roleService.insertData(2, "student");
            roleService.insertData(3, "teacher");
            roleService.insertData(4, "admin");
            roleService.insertData(5, "siblings");

            return ResponseEntity.ok("Roles data inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert roles data.");
        }
    }
}
