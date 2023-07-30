package studentenrollment.StudentinfoApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.Role;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.StudentinfoApi.Model.UserRole;
import studentenrollment.StudentinfoApi.Repository.RoleRepository;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;
import studentenrollment.StudentinfoApi.Repository.UserRepo;
import studentenrollment.StudentinfoApi.Repository.UserRoleRepository;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private final UserRepo userRepo;


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentService(StudentRepository studentRepository, UserRoleRepository userRoleRepository, UserRepo userRepo, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
    }

    public String addStudent(StudentModel student) {
        studentRepository.save(student);
        studentRepository.copyStudentDetails(student.getId());
        UserRole userRole=new UserRole();
        userRole.setUser_id(userRepo.findUserById(student.getId()));
        userRole.setRole_id(2);
        userRoleRepository.save(userRole);
        return "Student details are saved successfully";
    }
    public void insertData( int role_id,String role_name) {
        String sql = "INSERT INTO role (role_id,role_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, role_id, role_name);
    }


}
