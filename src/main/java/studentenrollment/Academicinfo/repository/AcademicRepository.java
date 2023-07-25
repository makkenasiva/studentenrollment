package studentenrollment.Academicinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.Academicinfo.model.Academy;
import studentenrollment.StateAPI.State;
import studentenrollment.citydistrictapi.model.City;
import studentenrollment.citydistrictapi.model.District;

@Repository
public interface AcademicRepository extends JpaRepository<Academy, Integer> {

    State findStateById(Integer stateId);

    City findCityByStateId(Integer stateId);

    District findDistrictByCityId(Integer cityId);
}




















//package studentenrollment.Academicinfo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import studentenrollment.Academicinfo.model.Academy;
//
//import studentenrollment.StateAPI.State;
//import studentenrollment.citydistrictapi.model.City;
//import studentenrollment.citydistrictapi.model.District;
//
//@Repository
//public interface AcademicRepository extends JpaRepository<Academy, Integer> {
//
////    @Query("SELECT s FROM States s WHERE s.id = :stateId")
//    State findStateById(Integer stateId);
//
////    @Query("SELECT c FROM City c WHERE c.stateId = :stateId")
//    City findCityByStateId(Integer stateId);
//
////    @Query("SELECT d FROM District d WHERE d.cityId = :cityId")
//    District findDistrictByCityId(Integer cityId);
//}
//

















//package studentenrollment.Academicinfo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import studentenrollment.Academicinfo.model.Academy;
//
//import java.util.List;
//
//@Repository
//public interface AcademyRepository extends JpaRepository<Academy, Integer> {
//    List<Academy> findByStateId(Integer stateId);
//    boolean existsByIdAndCityId(Integer academyId, Integer cityId);
//    boolean existsByIdAndCityIdAndStateId(Integer academyId, Integer cityId, Integer stateId);
//    boolean existsByIdAndDistrictId(Integer academyId, Integer districtId);
//    boolean existsByIdAndDistrictIdAndCityId(Integer academyId, Integer districtId, Integer cityId);
//
//    boolean existsByIdAndStateId(Integer academyId, Integer stateId);
//}
