package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "MUNICIPIO")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Municipio implements Serializable {

    private static final long serialVersionUID = -1905753657873601327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MUNICIPIO")
    private Long codMunicipio;

    @Column(name = "NOMBRE_MUNICIPIO")
    private String nombreMunicipio;

    @Column(name = "NOMBRE_MUNICIPIO_ABR")
    private String nombreMunicipioAbr;

    @ManyToOne
    @JoinColumn(name = "COD_DEPARTAMENTO")
    private Departamento departamento;
}
