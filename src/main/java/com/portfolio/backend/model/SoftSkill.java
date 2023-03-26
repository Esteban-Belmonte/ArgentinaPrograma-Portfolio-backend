
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SoftSkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String descripcionSkill;
    @NotBlank
    private String urlImagen;

    public SoftSkill() {
    }

    public SoftSkill(Long id, String nombreSkill, String descripcionSkill, String urlImagen) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.descripcionSkill = descripcionSkill;
        this.urlImagen = urlImagen;
    }
    
    
    
}
