package studentenrollment.StudentinfoApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.StudentinfoApi.Model.Role;
import studentenrollment.StudentinfoApi.Model.UserRole;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAll();



}
