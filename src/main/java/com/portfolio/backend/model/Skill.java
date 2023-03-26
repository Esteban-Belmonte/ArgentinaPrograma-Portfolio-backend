package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String descripcionSkill;
    @NotBlank
    private String urlImagen;

    public Skill() {
    }

    public Skill(Long id, String nombreSkill, String descripcionSkill, String urlImagen) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.descripcionSkill = descripcionSkill;
        this.urlImagen = urlImagen;
    }

    


}
