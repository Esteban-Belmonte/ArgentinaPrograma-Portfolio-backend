
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    private ProyectoRepository proRepository;

    @Override
    public List<Proyecto> getProyecto() {
         
        List<Proyecto> listaProyectos = proRepository.findAll();
        return listaProyectos;
    }

    @Override
    public void saveProyecto(Proyecto pro) {
        
        proRepository.save(pro);
    }

    @Override
    public void deleteProyecto(Long id) {
        
        proRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        
        Proyecto pro = proRepository.findById(id).orElse(null);
        return pro;
        
    }
    
}
