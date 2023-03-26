
package com.portfolio.backend.service;

import com.portfolio.backend.model.SoftSkill;
import com.portfolio.backend.repository.SoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SoftSkillService implements ISoftSkillService {

    @Autowired
    private SoftSkillRepository softRepository;
    
    @Override
    public List<SoftSkill> getSoftSkills() {
        List<SoftSkill> listaSoftSkills = softRepository.findAll();
        return listaSoftSkills;
    }

    @Override
    public void saveSoftSkill(SoftSkill soft) {
        softRepository.save(soft);
    }

    @Override
    public void deleteSotfSkill(Long id) {
        softRepository.deleteById(id);
    }

    @Override
    public SoftSkill findSoftSkill(Long id) {
        SoftSkill soft = softRepository.findById(id).orElse(null);
        return soft;
    }
    
}
