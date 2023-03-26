package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String ocupacion;
    @NotBlank
    private String urlImagenPerfil;
    @NotBlank
    private String urlImagenBanner;
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String ocupacion, String urlImagenPerfil, String urlImagenBanner) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.urlImagenPerfil = urlImagenPerfil;
        this.urlImagenBanner = urlImagenBanner;
    }

    

}
