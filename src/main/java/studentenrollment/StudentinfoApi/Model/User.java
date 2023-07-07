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
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

//    @Column(name = "email")  // Update the logical column name to match the physical column name
    private String email;

    private String status;


}
