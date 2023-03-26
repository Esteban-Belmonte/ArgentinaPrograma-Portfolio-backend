
package com.portfolio.backend.service;

import com.portfolio.backend.model.Footer;
import java.util.List;


public interface IFooterService {
    
     public List<Footer> getFooter();
    
    public void saveFooter(Footer foo);
    
    public void deleteFooter(Long id);
    
    public Footer findFooter(Long id);
    
}
