package studentenrollment.Academicinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.Academicinfo.model.AcademicInfo;

@Repository
public interface AcademicInfoRepository extends JpaRepository<AcademicInfo, Integer> {
}
