package com.practice.studentenrollment.familyinfo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity


public class Siblings {
    @Id
    private int studentId;

    public String firstName;
    public String middleName;
    public String lastName;
    public int contactNumber;

}
