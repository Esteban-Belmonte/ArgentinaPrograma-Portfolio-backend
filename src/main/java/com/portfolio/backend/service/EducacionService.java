
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    private EducacionRepository eduRepo;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = eduRepo.findAll();
        return listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void deleteEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion edu = eduRepo.findById(id).orElse(null);
        return edu;
    }
}
