package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the PAISES database table.
 *
 */
@Entity
@Table(name = "PAIS")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Pais implements Serializable {

    private static final long serialVersionUID = -1905753657873601327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PAIS")
    private Long codigoPais;

    @Column(name = "NOMBRE_PAIS")
    private String nombrePais;

    @Column(name = "NOMBRE_PAIS_ABR")
    private String nombrePaisAbr;

    @OneToMany(mappedBy = "pais")
    @OrderBy("nombreDepartamento ASC")
    private List<Departamento> departamentos;

}
