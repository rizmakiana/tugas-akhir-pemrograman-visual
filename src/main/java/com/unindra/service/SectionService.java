package com.unindra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unindra.entity.Section;
import com.unindra.repository.SectionRepository;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Section findById(Integer id) {
        
        return sectionRepository.findById(id).orElse(null);
    }

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public List<String> findDistinctSection() {

        return sectionRepository.findDistinctSectionNames();

    }

    public void update(Section section) {
        sectionRepository.save(section);
    }

    public void deleteById(Integer id) {
        sectionRepository.deleteById(id);
    }

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public List<Section> findByClassroomName(String classroomName) {
        return sectionRepository.findByClassroomName(classroomName);
    }


    



    

    

}
