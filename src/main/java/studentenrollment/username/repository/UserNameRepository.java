package studentenrollment.username.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.StudentinfoApi.Model.User;

@Repository
public interface UserNameRepository extends JpaRepository<User, Long> {



    User findByUsernameIgnoreCase(String username);
}
