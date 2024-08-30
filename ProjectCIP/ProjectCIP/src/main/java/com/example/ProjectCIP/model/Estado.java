package com.example.ProjectCIP.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "ESTADO")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_ESTADO")
    private Long codigoEstado;

    @Column(name = "DESCRIPCION", length = 30)
    private String descripcion;
}
