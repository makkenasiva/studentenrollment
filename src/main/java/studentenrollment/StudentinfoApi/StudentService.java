package studentenrollment.StudentinfoApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentModel addStudent(StudentModel student) {
        String fullName = buildFullName(student.getFirstName(), student.getMiddleName(), student.getLastName());
        student.setName(fullName);
        return studentRepository.save(student);
    }

    private String buildFullName(String firstName, String middleName, String lastName) {
        StringBuilder fullNameBuilder = new StringBuilder();
        if (firstName != null) {
            fullNameBuilder.append(firstName);
        }
        if (middleName != null) {
            fullNameBuilder.append(" ").append(middleName);
        }
        if (lastName != null) {
            fullNameBuilder.append(" ").append(lastName);
        }
        return fullNameBuilder.toString();
    }
}
