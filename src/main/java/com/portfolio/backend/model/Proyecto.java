package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    @Column(length = 1500)
    private String descripcionProyecto;
    @NotBlank
    private String urlProyecto;
    @NotBlank
    private String urlGit;
    @NotBlank
    private String urlImagen;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProyecto, String descripcionProyecto, String urlProyecto, String urlGit, String urlImagen) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
        this.urlGit = urlGit;
        this.urlImagen = urlImagen;
    }

    

}
