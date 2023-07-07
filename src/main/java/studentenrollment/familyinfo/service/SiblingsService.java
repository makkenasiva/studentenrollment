package studentenrollment.familyinfo.service;

import studentenrollment.familyinfo.model.Siblings;
import studentenrollment.familyinfo.repository.SiblingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiblingsService {
    private SiblingsRepository siblingsRepository;

    @Autowired
    public SiblingsService(SiblingsRepository siblingsRepository) {
        this.siblingsRepository = siblingsRepository;
    }

    public Siblings saveSiblings(Siblings siblings) {
        return siblingsRepository.save(siblings);
    }

    public boolean checkIfStudentExists(int studentId) {
        return siblingsRepository.existsById(studentId);
    }


}
