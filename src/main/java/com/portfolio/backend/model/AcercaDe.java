
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
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(length = 2000)
    private String descripcionPersonal;;

    public AcercaDe() {
    }

    public AcercaDe(Long id, String descripcionPersonal) {
        this.id = id;
        this.descripcionPersonal = descripcionPersonal;
    }

   
    
    
    
}
