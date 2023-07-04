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


public class Parents {

    @Id
    private int studentId;

    public String fatherName;
    public String motherName;
    public int contactNumber;

}
