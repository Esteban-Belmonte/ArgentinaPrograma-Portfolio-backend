
package com.portfolio.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Footer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String nombre;
    @NotBlank
    @Column(length = 2000)
    private String asunto;

    public Footer() {
    }

    
    
    public Footer(Long id, String email, String nombre, String asunto) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.asunto = asunto;
    }
   
    
    
}
