package studentenrollment.SearchApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import studentenrollment.StudentinfoApi.Model.StudentModel;

import java.util.List;

@Repository
public interface StudentSearchRepository extends JpaRepository<StudentModel, Integer> {

    List<StudentModel> findByUsernameContainingIgnoreCase(String input);

    @Query("SELECT s FROM StudentModel s WHERE LOWER(s.first_name) LIKE LOWER(CONCAT('%', :input, '%')) OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :input, '%'))")
    List<StudentModel> findByFirst_nameContainingIgnoreCaseOrLastNameContainingIgnoreCase(@Param("input") String input);

    @Query("SELECT s FROM StudentModel s WHERE LOWER(CONCAT(s.first_name, ' ', COALESCE(s.middle_name, ''), ' ', s.lastName)) LIKE LOWER(CONCAT('%', :input, '%'))")
    List<StudentModel> findByFullNameContainingIgnoreCase(@Param("input") String input);

}
