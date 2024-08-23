package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DEPARTAMENTO")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Departamento implements Serializable {


    private static final long serialVersionUID = -1905753657873601327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DEPARTAMENTO")
    private Long codigoDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO")
    private String nombreDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO_ABR")
    private String nombreDepartamentoAbr;

    //relacion con paises
    @ManyToOne
    @JoinColumn(name = "COD_PAIS")
    private Pais pais;

    /*
    @OneToMany(mappedBy = "departamento")
    @OrderBy("nombreMunicipio ASC")
    private List<Municipio> municipios;*/
}
