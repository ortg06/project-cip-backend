package com.example.ProjectCIP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

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

}
