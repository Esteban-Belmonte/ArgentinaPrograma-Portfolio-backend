
package com.portfolio.backend.service;

import com.portfolio.backend.model.AcercaDe;
import com.portfolio.backend.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDeService {
    
    @Autowired
    private AcercaDeRepository acercaRepository;

    @Override
    public List<AcercaDe> getAcercaDe() {
        
        List<AcercaDe> listaAcerca = acercaRepository.findAll();
        return listaAcerca;
    }

    @Override
    public void saveAcercaDe(AcercaDe acerca) {
        
        acercaRepository.save(acerca);
    }

    @Override
    public void deleteAcercaDe(Long id) {
        
        acercaRepository.deleteById(id);
    }

    @Override
    public AcercaDe findAcercaDe(Long id) {
        
        AcercaDe acerca = acercaRepository.findById(id).orElse(null);
        return acerca;
    }
    
}
