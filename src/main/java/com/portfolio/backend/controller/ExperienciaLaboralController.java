
package com.portfolio.backend.controller;

import com.portfolio.backend.model.ExperienciaLaboral;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IExperienciaLaboralService;
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
Controlador de la seccion "experiencia laboral" donde se detallara el nombre de la empresa, su descripcion,
periodo dentro de la misma y la funciona que se desempeño dentro de ella
*/
//en desarrollo:
//@CrossOrigin(origins = "http://localhost:4200")
//En produccion:
@CrossOrigin(origins = "https://portfolio-front-end-9b739.web.app")
@RestController
public class ExperienciaLaboralController {
    
    
    @Autowired
    private IExperienciaLaboralService interExp;
    
    
    @GetMapping("/api/experiencia/traer")
    public List<ExperienciaLaboral> getExperiencia() {
        
        return interExp.getExperiencia();
    }
    
    @GetMapping("/api/experiencia/{id}")
    public ExperienciaLaboral getAcercaById(@PathVariable Long id) {
       return interExp.findExperiencia(id);
    }
    
    @PostMapping("/api/experiencia/crear")
    public ResponseEntity<Object> createExperiencia(@RequestBody ExperienciaLaboral exp) {
        if(StringUtils.isBlank(exp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getPeriodo())){
            return new ResponseEntity(new Mensaje("El periodo dentro de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getFuncion())){
            return new ResponseEntity(new Mensaje("La funcion dentro de la empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getTituloPuesto())){
            return new ResponseEntity(new Mensaje("El nombre del titulo dentro de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(exp.getFuncion())>1500){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 1500 caracteres"), HttpStatus.BAD_REQUEST);
        }
        
        interExp.saveExperiencia(exp);
        return new ResponseEntity<>(new Result("La seccion 'experiencia laboral' se creo correctamente"), HttpStatus.OK);
    }   
    
    @DeleteMapping("/api/experiencia/borrar/{id}")
    public String deleteExperiencia (@PathVariable Long id) {
        
        interExp.deleteExperiencia(id);
        return "La seccion 'experiencia laboral' se elimino correctamente";
    }
    
    @PutMapping("/api/experiencia/editar/{id}")
    public ResponseEntity<?> editExperiencia (@PathVariable Long id,
                                               @RequestParam ("nombre de la empresa") String nombreEmpresa,
                                               @RequestParam ("periodo dentro de la empresa") String periodo,
                                               @RequestParam ("Funcion dentro de la empresa") String funcion,
                                               @RequestParam ("titulo del puesto")String tituloPuesto,
                                               @RequestParam ("logo de la empresa") String logoEmpresa) {
        
        ExperienciaLaboral exp = interExp.findExperiencia(id);
        
        exp.setNombreEmpresa(nombreEmpresa);
        exp.setPeriodo(periodo);
        exp.setFuncion(funcion);
        exp.setTituloPuesto(tituloPuesto);
        exp.setLogoEmpresa(logoEmpresa);
        
        if(StringUtils.isBlank(exp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getPeriodo())){
            return new ResponseEntity(new Mensaje("El periodo dentro de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getFuncion())){
            return new ResponseEntity(new Mensaje("La funcion dentro dela empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(exp.getTituloPuesto())){
            return new ResponseEntity(new Mensaje("El nombre del titulo dentro de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(exp.getFuncion())>1500){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 1500 caracteres"), HttpStatus.BAD_REQUEST);
        }
        
        interExp.saveExperiencia(exp);
        return new ResponseEntity(new Mensaje("la seccion 'experiencia laboral' fue actualizada correctamente"),HttpStatus.OK);
    }
}
