
package com.portfolio.backend.service;

import com.portfolio.backend.model.AcercaDe;
import java.util.List;

public interface IAcercaDeService {
    
    public List<AcercaDe> getAcercaDe ();
    
    public void saveAcercaDe (AcercaDe acerca);
    
    public void deleteAcercaDe (Long id);
    
    public AcercaDe findAcercaDe (Long id);
    
}
