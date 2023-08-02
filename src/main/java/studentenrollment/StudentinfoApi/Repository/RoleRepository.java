package studentenrollment.StudentinfoApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.StudentinfoApi.Model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {



}
