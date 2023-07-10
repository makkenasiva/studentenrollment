package studentenrollment.familyinfo.repository;

import studentenrollment.familyinfo.model.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentsRepository extends JpaRepository<Parents,Integer> {
    Parents findByStudentId(int studentId);

}
