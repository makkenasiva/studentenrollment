package studentenrollment.StudentinfoApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public User addStudent(StudentModel student) {
        studentRepository.save(student);
        studentRepository.copyStudentDetails(student.getId());
        studentRepository.setPassword(student.getId());
        return studentRepository.findUserById(student.getId());
    }
}
