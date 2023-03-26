package com.portfolio.backend.controller;

import com.portfolio.backend.model.Footer;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IFooterService;
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
Controlador de la seccion "Footer" donde estara un formulario de contacto
 */
//En desarrollo:
//@CrossOrigin(origins = "http://localhost:4200")
//En produccion:
@CrossOrigin(origins = "https://portfolio-front-end-9b739.web.app")
@RestController
public class FooterController {

    @Autowired
    private IFooterService interFooter;

    @GetMapping("/api/footer/traer")
    public List<Footer> getFooter() {
        return interFooter.getFooter();
    }

    @GetMapping("/api/footer/{id}")
    public Footer getFooterById(@PathVariable Long id) {
        return interFooter.findFooter(id);
    }

    @PostMapping("/api/footer/crear")
    public ResponseEntity<Object> createFooter(@RequestBody Footer foo) {

        if (StringUtils.isBlank(foo.getEmail())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(foo.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(foo.getAsunto())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.length(foo.getAsunto())>2000){
            return new ResponseEntity(new Mensaje("El asunto no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interFooter.saveFooter(foo);
        return new ResponseEntity<>(new Result("La seccion 'Footer' fue creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/footer/borrar/{id}")
    public String deleteFooter(@PathVariable Long id) {

        interFooter.deleteFooter(id);
        return "La seccion Footer fue eliminada correctamente";
    }

    @PutMapping("/api/footer/editar/{id}")
    public ResponseEntity<?> editFooter(@PathVariable Long id,
            @RequestParam("email") String email,
            @RequestParam("nombre") String nombre,
            @RequestParam("asunto") String asunto) {

        Footer foo = interFooter.findFooter(id);
        foo.setEmail(email);
        foo.setNombre(nombre);
        foo.setAsunto(asunto);

        if (StringUtils.isBlank(foo.getEmail())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(foo.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(foo.getAsunto())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.length(foo.getAsunto())>2000){
            return new ResponseEntity(new Mensaje("El asunto no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }

        interFooter.saveFooter(foo);
        return new ResponseEntity(new Mensaje("La seccion 'Footer' actualizada"), HttpStatus.OK);

    }

}
