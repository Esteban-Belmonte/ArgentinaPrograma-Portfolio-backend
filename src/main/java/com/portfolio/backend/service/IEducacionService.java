
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List<Educacion> getEducacion ();
    
    public void saveEducacion (Educacion edu);
    
    public void deleteEducacion (Long id);
    
    public Educacion findEducacion (Long id);
}
