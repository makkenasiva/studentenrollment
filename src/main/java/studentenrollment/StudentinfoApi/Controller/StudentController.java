package studentenrollment.StudentinfoApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentenrollment.StudentinfoApi.Model.Role;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;
import studentenrollment.StudentinfoApi.Repository.UserRoleRepository;
import studentenrollment.StudentinfoApi.Service.RoleService;
import studentenrollment.StudentinfoApi.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
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
    public ResponseEntity<Integer> addStudent(@RequestBody StudentModel student) {
        Integer studentId = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentId);
    }
    @PostMapping("/add-roles")
    public ResponseEntity<String> addRoles() {
        try {
            roleService.insertData(1, "parent");
            roleService.insertData(2, "student");
            roleService.insertData(3, "teacher");
            roleService.insertData(4, "admin");
            roleService.insertData(5, "siblings");
//            roleService.insertData(6,"friend");

            return ResponseEntity.ok("Roles data inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert roles data.");
        }
    }
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(roles);
        }
    }
}
