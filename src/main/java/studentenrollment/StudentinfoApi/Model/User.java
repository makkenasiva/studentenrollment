package studentenrollment.StudentinfoApi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "email")  // Update the logical column name to match the physical column name
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "student_id")
    private Integer studentId;

}
