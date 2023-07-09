package studentenrollment.Academicinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.Academicinfo.model.AcademicInfo;
import studentenrollment.Academicinfo.repository.AcademicInfoRepository;

import java.util.List;

@Service
public class AcademicInfoService {
    @Autowired
    private AcademicInfoRepository academicInfoRepository;

    public AcademicInfo addNew(AcademicInfo academicInfo) {
        this.academicInfoRepository.save(academicInfo);
        return academicInfo;
    }

    public List<AcademicInfo> getAllDetails(){
        return this.academicInfoRepository.findAll();
    }
}
