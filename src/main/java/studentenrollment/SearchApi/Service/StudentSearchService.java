package studentenrollment.SearchApi.Service;

import studentenrollment.SearchApi.Model.StudentSearch;
import studentenrollment.SearchApi.Repository.StudentSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSearchService {
    @Autowired
    private StudentSearchRepository studentSearchRepository;

    public StudentSearch addStudents(StudentSearch studentSearch) {
        return studentSearchRepository.save(studentSearch);
    }

    public List<StudentSearch> studentSearchList() {
        return studentSearchRepository.findAll();
    }

    public Optional<StudentSearch> getStudentById(Integer id) {
        return studentSearchRepository.findById(id);
    }

    public List<StudentSearch> getStudentsByFirstNameIgnoreCase(String firstName) {
        return studentSearchRepository.findByFirstNameIgnoreCase(firstName);
    }

    public List<StudentSearch> getStudentsByLastNameIgnoreCase(String lastName) {
        return studentSearchRepository.findByLastNameIgnoreCase(lastName);
    }

    public List<StudentSearch> getStudentsByUsernameIgnoreCase(String userName) {
        return studentSearchRepository.findByUserNameIgnoreCase(userName);
    }

}
