package studentenrollment.familyinfo.service;

import studentenrollment.familyinfo.model.Parents;
import studentenrollment.familyinfo.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ParentsService {
    private ParentsRepository parentsRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository) {
        this.parentsRepository = parentsRepository;
    }

    public Parents saveParents(Parents parents) {
        return parentsRepository.save(parents);
    }

    public boolean checkIfStudentExists(int studentId) {
        return parentsRepository.existsById(studentId);
    }
}