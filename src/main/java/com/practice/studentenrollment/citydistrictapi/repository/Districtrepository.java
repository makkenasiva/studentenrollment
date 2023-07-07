package com.practice.studentenrollment.citydistrictapi.repository;

import com.practice.studentenrollment.citydistrictapi.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Districtrepository extends JpaRepository<District,Integer> {
        boolean existsByDistrictname(String Districtname);


    }

