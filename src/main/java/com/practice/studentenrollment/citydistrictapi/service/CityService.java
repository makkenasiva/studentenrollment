package com.practice.studentenrollment.citydistrictapi.service;

import com.practice.studentenrollment.citydistrictapi.model.City;
import com.practice.studentenrollment.citydistrictapi.repository.Cityrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private Cityrepository cityrepository;
    public CityService(Cityrepository cityrepository){
        this.cityrepository = cityrepository;
    }
    public List<City> getAllCities(){
        return cityrepository.findAll();
    }
    /*public Optional<City> getCityById(int id){
        return cityrepository.findById(id);
    }*/

    public City getCityById(int id) {
        Optional<City> cityOptional = cityrepository.findById(id);

        return cityOptional.orElse(null);
}}
