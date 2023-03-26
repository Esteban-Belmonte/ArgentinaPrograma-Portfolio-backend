
package com.portfolio.backend.service;

import com.portfolio.backend.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> getSkills();
    
    public void saveSkill (Skill skl);
    
    public void deleteSkill (Long id);
    
    public Skill findSkill (Long id);
    
}
