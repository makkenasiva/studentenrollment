package studentenrollment.StudentinfoApi.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO User(username,user_password,email,status,student_id,institution_id) SELECT username,'Abcd123#', email,'Y', id,institution_id FROM student WHERE id=:i",
            nativeQuery = true)
    void copyStudentDetails(Integer i);


    @Query(value = "SELECT u FROM User u WHERE u.id = :id")
    User findUserById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "CREATE TABLE role (role_id INT, role_name VARCHAR(255))", nativeQuery = true)
    void createRoleTable();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_role SELECT role_id  FROM role WHERE id=:i", nativeQuery = true)
    void copyUserRoleDetails(Integer i);



}
