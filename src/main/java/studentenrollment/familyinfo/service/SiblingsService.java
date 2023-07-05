package studentenrollment.familyinfo.service;

import studentenrollment.familyinfo.model.Siblings;
import studentenrollment.familyinfo.repository.SiblingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiblingsService {
@Autowired
private SiblingsRepository siblingsRepository;

    public Siblings addNew(Siblings siblings) {
        this.siblingsRepository.save(siblings);
        return siblings;
    }

    public List<Siblings> getAllSiblings(){
        return this.siblingsRepository.findAll();
}
}
