package studentenrollment.citydistrictapi.service;

import studentenrollment.citydistrictapi.model.District;
import studentenrollment.citydistrictapi.repository.Districtrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DistrictService {
    private Districtrepository districtrepository;
    @Autowired
    public DistrictService(Districtrepository districtrepository){
        this.districtrepository = districtrepository;
    }
    public List<District> getAllDistricts(){
        return districtrepository.findAll();
    }


    public District getDistrictById(int id) {
        Optional<District> districtOptional = districtrepository.findById(id);

        return districtOptional.orElse(null);
}}

