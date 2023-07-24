package studentenrollment.citydistrictapi.repository;

import studentenrollment.citydistrictapi.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Districtrepository extends JpaRepository<District,Integer> {
        boolean existsByDistrictname(String Districtname);





    boolean existsBycityidAndId(Integer cityId, Integer districtId);
}

