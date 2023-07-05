package studentenrollment.username.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentenrollment.username.model.UserName;

@Repository
public interface UserNameRepository extends JpaRepository<UserName, Long> {



    UserName findByUsernameIgnoreCase(String username);
}
