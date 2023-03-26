
package com.portfolio.backend.service;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    
    @Autowired
    private SkillRepository sklRepository;

    @Override
    public List<Skill> getSkills() {
        
        List<Skill> listaSkills = sklRepository.findAll();
        return listaSkills;
    }

    @Override
    public void saveSkill(Skill skl) {
        
        sklRepository.save(skl);
    }

    @Override
    public void deleteSkill(Long id) {
        
        sklRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        
        Skill skl = sklRepository.findById(id).orElse(null);
        return skl;
    }
    
}
