package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "SERVICIO")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Servicio implements Serializable {

    private static final long serialVersionUID = -1905753657873601327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_SERVICIO")
    private Long codServicio;

    @Column(name = "DESCRIPCION")
    private String descripcion;

}
