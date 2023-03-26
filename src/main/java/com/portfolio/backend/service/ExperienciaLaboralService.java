
package com.portfolio.backend.service;

import com.portfolio.backend.model.ExperienciaLaboral;
import com.portfolio.backend.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {
    
    @Autowired
    private ExperienciaLaboralRepository expRepository;

    @Override
    public List<ExperienciaLaboral> getExperiencia() {
        
        List<ExperienciaLaboral> listaExperiencia = expRepository.findAll();
        return listaExperiencia;
    }

    @Override
    public void saveExperiencia(ExperienciaLaboral exp) {
        
        expRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id) {
        
        expRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperiencia(Long id) {
        
        ExperienciaLaboral exp = expRepository.findById(id).orElse(null);
        return exp;
    }
    
}
