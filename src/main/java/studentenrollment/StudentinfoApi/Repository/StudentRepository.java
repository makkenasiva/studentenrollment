package studentenrollment.StudentinfoApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Model.User;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO User(username,user_password,email,status,student_id) SELECT username,'Abcd123#', email,'Y', id FROM student WHERE id=:i",
            nativeQuery = true)
    void copyStudentDetails(Integer i);

//    @Modifying
//    @Transactional
//    @Query(
//            value = "UPDATE User SET password = 'password' WHERE user_id=:i",
//            nativeQuery = true)
//    void setPassword(Integer i);
    @Query(value = "SELECT u FROM User u WHERE u.id = :id")
    User findUserById(Integer id);
}
