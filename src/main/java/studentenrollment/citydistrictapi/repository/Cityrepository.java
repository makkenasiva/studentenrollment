package studentenrollment.citydistrictapi.repository;

import studentenrollment.citydistrictapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cityrepository extends JpaRepository<City,Integer> {
    boolean existsByCityname(String Cityname);


}
