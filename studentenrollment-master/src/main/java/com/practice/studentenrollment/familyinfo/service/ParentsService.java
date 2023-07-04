package com.practice.studentenrollment.familyinfo.service;

import com.practice.studentenrollment.familyinfo.model.Parents;
import com.practice.studentenrollment.familyinfo.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsService {
    @Autowired
    private ParentsRepository parentsRepository;

    public Parents addNew(Parents library) {
        this.parentsRepository.save(library);
        return library;
    }

    public List<Parents> getAllDetails(){
        return this.parentsRepository.findAll();

    }


}