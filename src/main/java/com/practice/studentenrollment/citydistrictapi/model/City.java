package com.practice.studentenrollment.citydistrictapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
    @Id
    private int id;
    public String cityname;
    public int stateid;

    public static City cityNotFound() {
        City notFound = new City();
        notFound.setCityname("City not found");
        return notFound;
    }
}
