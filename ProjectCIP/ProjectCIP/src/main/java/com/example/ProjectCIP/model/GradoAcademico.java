package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * The persistent class for the GRADO_ACADEMICO database table.
 *
 */
@Entity
@Table(name = "GRADO_ACADEMICO")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class GradoAcademico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_GRADO", length = 20)
    private Long codigoGrado;

    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;

}