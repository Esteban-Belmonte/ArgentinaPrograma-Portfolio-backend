
package com.portfolio.backend.service;

import com.portfolio.backend.model.SoftSkill;
import java.util.List;


public interface ISoftSkillService {
    
    public List<SoftSkill> getSoftSkills();
    
    public void saveSoftSkill (SoftSkill soft);
    
    public void deleteSotfSkill (Long id);
    
    public SoftSkill findSoftSkill (Long id);
    
}
