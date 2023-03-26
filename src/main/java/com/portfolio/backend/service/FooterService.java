
package com.portfolio.backend.service;

import com.portfolio.backend.model.Footer;
import com.portfolio.backend.repository.footerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FooterService implements IFooterService {

    @Autowired
    private footerRepository fooRepository;
    
    @Override
    public List<Footer> getFooter() {
        List<Footer> listaFooter = fooRepository.findAll();
        return listaFooter;
    }

    @Override
    public void saveFooter(Footer foo) {
        fooRepository.save(foo);
    }

    @Override
    public void deleteFooter(Long id) {
        fooRepository.deleteById(id);
    }

    @Override
    public Footer findFooter(Long id) {
        Footer foo = fooRepository.findById(id).orElse(null);
        return foo;
    }
    
}
