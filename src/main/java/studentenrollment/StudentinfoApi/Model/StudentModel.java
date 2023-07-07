package studentenrollment.StudentinfoApi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_model")
@SecondaryTable(name = "user", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class StudentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "preferred_name")
  private String preferredName;

  @Column(name = "date_of_birth")
  private String dateOfBirth;

  @Column(name = "gender")
  private String gender;

//  @Column(name = "email", table = "user")
  private String email;  // Update the logical column name to match the physical column name

  @Column(name = "address")
  private String address;

  @Column(name = "grade")
  private Integer grade;

  @Column(name = "username", table = "user")
  private String username;

  @Column(name = "mobile_number", table = "user")
  private Long mobileNumber;

  @Column(name = "institution_id")
  private Integer institutionId;


}
