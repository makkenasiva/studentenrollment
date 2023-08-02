package studentenrollment.familyinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;
import studentenrollment.familyinfo.model.Siblings;
import studentenrollment.familyinfo.repository.SiblingsRepository;

@Service
public class SiblingsServiceImpl implements SiblingsService {
    private final SiblingsRepository siblingsRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SiblingsServiceImpl(SiblingsRepository siblingsRepository,StudentRepository studentRepository) {
        this.siblingsRepository = siblingsRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Siblings storeSiblingDetails(int studentId, String firstName, String middleName, String lastName, Long contactNumber) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalArgumentException("Invalid student ID: " + studentId);
        }


        Siblings existingSibling = siblingsRepository.findByStudentId(studentId);
        if (existingSibling == null) {
            existingSibling = new Siblings();
            existingSibling.setStudentId(studentId);
        }

        existingSibling.setFirstName(firstName);
        existingSibling.setMiddleName(middleName);
        existingSibling.setLastName(lastName);
        existingSibling.setContactNumber(contactNumber);

        return siblingsRepository.save(existingSibling);
    }
}

