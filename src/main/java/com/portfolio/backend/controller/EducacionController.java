package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IEducacionService;
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
Controlador para la seccion "educacion" donde se detallara la institucion y periodo de estudio, asi como
su certificado.
*/
//En desarrollo:
//@CrossOrigin(origins = "http://localhost:4200")
//En produccion:
@CrossOrigin(origins = "https://portfolio-front-end-9b739.web.app")
@RestController
public class EducacionController {

    @Autowired
    private IEducacionService interEducacion;

    @GetMapping("/api/educacion/traer")
    public List<Educacion> getEducacion() {
        return interEducacion.getEducacion();
    }

    @GetMapping("/api/educacion/{id}")
    public Educacion getEducacionById(@PathVariable Long id) {
        return interEducacion.findEducacion(id);
    }

    @PostMapping("/api/educacion/crear")
    public ResponseEntity<Object> createEducacion(@RequestBody Educacion edu) {
        if(StringUtils.isBlank(edu.getNombreInstituto())){
            return new ResponseEntity(new Mensaje("El nombre de la institucion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(edu.getDescripcionInstitucion())){
            return new ResponseEntity(new Mensaje("La descripcion no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(edu.getFechaInicio())){
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(edu.getDescripcionInstitucion())>1000){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interEducacion.saveEducacion(edu);
        return new ResponseEntity<>(new Result("La institucion fue creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id) {

        interEducacion.deleteEducacion(id);
        return "La institucion fue eliminada correctamente";
    }

    @PutMapping("/api/educacion/editar/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable Long id,
            @RequestParam("Instituto") String nombreInstituto,
            @RequestParam("Fecha") String fechaInicio,
            @RequestParam("Descripcion") String descripcionInstitucion,
            @RequestParam("logo")String logo,
            @RequestParam("Certificado") String urlCertificado) {
        Educacion edu = interEducacion.findEducacion(id);
        edu.setNombreInstituto(nombreInstituto);
        edu.setFechaInicio(fechaInicio);
        edu.setDescripcionInstitucion(descripcionInstitucion);
        edu.setLogo(logo);
        edu.setUrlCertificado(urlCertificado);
         if(StringUtils.isBlank(edu.getNombreInstituto())){
            return new ResponseEntity(new Mensaje("El nombre de la institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(edu.getDescripcionInstitucion())){
            return new ResponseEntity(new Mensaje("La descrpcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(edu.getFechaInicio())){
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(edu.getDescripcionInstitucion())>1000){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 1000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interEducacion.saveEducacion(edu);
        return new ResponseEntity(new Mensaje("La seccion 'educacion' fue ctualizada correctamente"),HttpStatus.OK);

    }

}
