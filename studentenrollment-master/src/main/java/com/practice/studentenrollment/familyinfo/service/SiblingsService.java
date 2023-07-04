package com.practice.studentenrollment.familyinfo.service;

import com.practice.studentenrollment.familyinfo.model.Siblings;
import com.practice.studentenrollment.familyinfo.repository.SiblingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiblingsService {
@Autowired
private SiblingsRepository siblingsRepository;

    public Siblings addNew(Siblings siblings) {
        this.siblingsRepository.save(siblings);
        return siblings;
    }

    public List<Siblings> getAllSiblings(){
        return this.siblingsRepository.findAll();
}
}
