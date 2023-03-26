
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.model.SoftSkill;
import com.portfolio.backend.service.ISoftSkillService;
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
Controlador de la seccion 'Soft Skills' donde se nombrara alguna habilidad blanda.
 */
//En desarrollo:
//@CrossOrigin(origins = "http://localhost:4200")
//En produccion:
@CrossOrigin(origins = "https://portfolio-front-end-9b739.web.app")
@RestController
public class SoftSkillController {
    
    @Autowired
    private ISoftSkillService interSoft;

    @GetMapping("/api/soft/traer")
    public List<SoftSkill> getSoftSkills() {

        return interSoft.getSoftSkills();
    }

    @GetMapping("/api/soft/{id}")
    public SoftSkill getSoftSkill(@PathVariable Long id) {
        return interSoft.findSoftSkill(id);
    }

    @PostMapping("/api/soft/crear")
    public ResponseEntity<Object> createSoftSkill(@RequestBody SoftSkill soft) {

        if (StringUtils.isBlank(soft.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(soft.getDescripcionSkill())) {
            return new ResponseEntity(new Mensaje("La descripcion de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.length(soft.getDescripcionSkill()) > 200) {
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 200 caracteres"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(soft.getUrlImagen())) {
            return new ResponseEntity(new Mensaje("La url de la imagen de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        interSoft.saveSoftSkill(soft);
        return new ResponseEntity<>(new Result("La seccion 'Soft skill' fue creada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/api/soft/borrar/{id}")
    public String deleteSoftSkill(@PathVariable Long id) {

        interSoft.deleteSotfSkill(id);
        return "La skill fue elimanada correctamente";
    }

    @PutMapping("/api/soft/editar/{id}")
    public ResponseEntity<?> editSoftSkill(@PathVariable Long id,
            @RequestParam("nombre") String nombreSkill,
            @RequestParam("descripcion") String descripcionSkill,
            @RequestParam("urlImagen") String urlImagen) {

        SoftSkill soft = interSoft.findSoftSkill(id);

        soft.setNombreSkill(nombreSkill);
        soft.setDescripcionSkill(descripcionSkill);
        soft.setUrlImagen(urlImagen);

        if (StringUtils.isBlank(soft.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(soft.getDescripcionSkill())) {
            return new ResponseEntity(new Mensaje("La descripcion de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.length(soft.getDescripcionSkill()) > 200) {
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 200 caracteres"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(soft.getUrlImagen())) {
            return new ResponseEntity(new Mensaje("La url de la imagen de la 'skill' es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        interSoft.saveSoftSkill(soft);
        
        return new ResponseEntity(new Mensaje("La seccion 'Soft skill' fue actualizada correctamente"), HttpStatus.OK);
    }

}

    

