package studentenrollment.SearchApi.Repository;

import studentenrollment.SearchApi.Model.StudentSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSearchRepository extends JpaRepository<StudentSearch, Integer> {
    List<StudentSearch> findByFirstNameIgnoreCase(String firstName);
    List<StudentSearch> findByLastNameIgnoreCase(String lastName);
    List<StudentSearch> findByUserNameIgnoreCase(String userName);

}
