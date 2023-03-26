
package com.portfolio.backend.service;

import com.portfolio.backend.model.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> getExperiencia();
    
    public void saveExperiencia (ExperienciaLaboral exp);
    
    public void deleteExperiencia (Long id);
    
    public ExperienciaLaboral findExperiencia (Long id);
    
}
