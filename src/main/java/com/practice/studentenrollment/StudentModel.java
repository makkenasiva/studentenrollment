package com.practice.studentenrollment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="student")
public class StudentModel {
    @Id
    private Integer id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String parent_name;
    private Date  date_of_birth;
    private String gender;
    private String email;
    private String address;
    private Integer grade;
    private String username;
    private Long mobile_number;


}
