package studentenrollment.StudentinfoApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public User addStudent(StudentModel student) {
        studentRepository.save(student);
        studentRepository.copyStudentDetails(student.getId());
        return studentRepository.findUserById(student.getId());
    }


    public void insertData( int role_id,String role_name) {
        String sql = "INSERT INTO role (role_id, role_name) VALUES (?,?)";
        jdbcTemplate.update( sql, role_id, role_name);

    }


}
