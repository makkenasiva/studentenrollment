package studentenrollment.StudentinfoApi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) DEFAULT 'Unknown'")
    private String name;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    // Constructors, getters, and setters
}
