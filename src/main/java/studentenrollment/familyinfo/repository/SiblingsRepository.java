package studentenrollment.familyinfo.repository;

import studentenrollment.familyinfo.model.Parents;
import studentenrollment.familyinfo.model.Siblings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiblingsRepository extends JpaRepository <Siblings,Integer> {
    Siblings findByStudentId(int studentId);
}
