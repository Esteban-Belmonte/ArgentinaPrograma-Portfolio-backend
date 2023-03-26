
package com.portfolio.backend.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreInstituto;
    @NotBlank
    private String fechaInicio;
   @NotBlank
   @Column(length = 1000) 
    private String descripcionInstitucion;
    private String logo;
    private String urlCertificado;

    public Educacion() {
    }

    public Educacion(Long id, String nombreInstituto, String fechaInicio, String descripcionInstitucion, String logo, String urlCertificado) {
        this.id = id;
        this.nombreInstituto = nombreInstituto;
        this.fechaInicio = fechaInicio;
        this.descripcionInstitucion = descripcionInstitucion;
        this.logo = logo;
        this.urlCertificado = urlCertificado;
    }

    
    
    
}
