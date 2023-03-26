
package com.portfolio.backend.controller;

import com.portfolio.backend.model.AcercaDe;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IAcercaDeService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
Controlador para la seccion "acerca de" que contendra la descripcion personal
*/

@RestController
//En desarrollo:
//@CrossOrigin(origins = "http://localhost:4200")
//En produccion:
@CrossOrigin(origins = "https://portfolio-front-end-9b739.web.app")
public class AcercaDeController {
    
    @Autowired
    private IAcercaDeService interAcercaDe;
    
    @GetMapping("/api/acercade/traer")
    public List <AcercaDe> getAcerca() {
        
        return interAcercaDe.getAcercaDe();
    }
    
    @GetMapping("/api/acercade/{id}")
    public AcercaDe getAcercaById(@PathVariable Long id) {
       return interAcercaDe.findAcercaDe(id);
    }
    
    @PostMapping("/api/acercade/crear")
    public ResponseEntity<Object> createAcerca(@RequestBody AcercaDe acerca){
          if(StringUtils.isBlank(acerca.getDescripcionPersonal())){
            return new ResponseEntity(new Mensaje("La descripcion personal no puede estar vacia"), HttpStatus.BAD_REQUEST);
        } if (StringUtils.length(acerca.getDescripcionPersonal())>2000){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interAcercaDe.saveAcercaDe(acerca);
        return new ResponseEntity<>( new Result("La seccion 'acerca de' fue creada correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/api/acercade/borrar/{id}")
    public String deleteAcerca (@PathVariable Long id){
        
        interAcercaDe.deleteAcercaDe(id);
        return "La seccion 'acerca de' fue elimanada correctamente";
    }
    
    @PutMapping("/api/acercade/editar/{id}")
    public ResponseEntity<?> editAcerca (@PathVariable Long id,
                                @RequestParam ("descripcion personal")String descripcionPersonal) {
        
        AcercaDe acerca = interAcercaDe.findAcercaDe(id);
        acerca.setDescripcionPersonal(descripcionPersonal);
        
        if(StringUtils.isBlank(acerca.getDescripcionPersonal())){
            return new ResponseEntity(new Mensaje("La descripcion personal no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(acerca.getDescripcionPersonal())>2000){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interAcercaDe.saveAcercaDe(acerca);
        return new ResponseEntity(new Mensaje("la seccion 'acerca de' fue actualizada correctamente"),HttpStatus.OK);
        
    }
    
    
}
