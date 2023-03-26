package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String periodo;
    @NotBlank
    @Column(length = 1500)
    private String funcion;
    @NotBlank
    private String tituloPuesto;
    private String logoEmpresa;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long id, String nombreEmpresa, String periodo, String funcion, String tituloPuesto, String logoEmpresa) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.periodo = periodo;
        this.funcion = funcion;
        this.tituloPuesto = tituloPuesto;
        this.logoEmpresa = logoEmpresa;
    }

}
