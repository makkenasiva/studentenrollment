package studentenrollment.Academicinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.Academicinfo.model.Academy;
import studentenrollment.Academicinfo.repository.AcademicRepository;
import studentenrollment.StateAPI.StateRepository;
import studentenrollment.citydistrictapi.model.City;
import studentenrollment.citydistrictapi.model.District;
import studentenrollment.citydistrictapi.repository.Cityrepository;
import studentenrollment.citydistrictapi.repository.Districtrepository;

@Service
public class AcademyService {
    private final AcademicRepository academyRepository;
    private final Cityrepository cityRepository;
    private final Districtrepository districtRepository;
    private final StateRepository stateRepository;

    @Autowired
    public AcademyService(AcademicRepository academyRepository,
                          Cityrepository cityRepository,
                          Districtrepository districtRepository,
                          StateRepository stateRepository) {
        this.academyRepository = academyRepository;
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
        this.stateRepository = stateRepository;
    }

    public Academy addNewSchool(Academy academyInfo) {
        String entryOrTransfer = academyInfo.getEntryOrTransfer();
        if (entryOrTransfer != null && (entryOrTransfer.equalsIgnoreCase("entry") || entryOrTransfer.equalsIgnoreCase("transfer"))) {
            Integer stateId = academyInfo.getStateId();
            Integer cityId = academyInfo.getCityId();
            Integer districtId = academyInfo.getDistrictId();

            // Check if the stateId exists in the states table
            if (!stateRepository.existsById(stateId)) {
                throw new IllegalArgumentException("Invalid stateId: " + stateId);
            }


            if (!cityRepository.existsByStateidAndId(stateId, cityId)) {
                throw new IllegalArgumentException("Invalid city for the given state");
            }


            // Check if the districtId exists in the district table and belongs to the specified cityId
            if (!districtRepository.existsBycityidAndId(cityId, districtId)) {
                throw new IllegalArgumentException("Invalid districtId for the given cityId");
            }

            return academyRepository.save(academyInfo);
        } else {
            throw new IllegalArgumentException("Invalid value for entryOrTransfer");
        }
    }
}
