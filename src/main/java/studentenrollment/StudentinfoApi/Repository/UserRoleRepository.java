package studentenrollment.StudentinfoApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.StudentinfoApi.Model.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
