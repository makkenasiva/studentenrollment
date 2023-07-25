package studentenrollment.StudentinfoApi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    private Integer user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer role_id;

}
