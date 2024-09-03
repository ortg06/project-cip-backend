package com.example.ProjectCIP.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "INFO_ADICIONAL_ENTREVISTA")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class InfoAdicionalEntrevista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_adicional_seq")
    @SequenceGenerator(name = "info_adicional_seq", sequenceName = "INFO_ADICIONAL_SEQ", allocationSize = 1)
    @Column(name = "CODIGO_INFO_ADICIONAL")
    private Long codInfoAdicional;

    @Column(name = "FORMA_CONOCER")
    private String formaConocer;

    @Column(name = "SERVICIO_PARA")
    private String servicioPara;

    @Column(name = "ACOMPANAMIENTO_PSICOLOGICO")
    private String acompanamientoPsicologico;

    @Column(name = "MOTIVO_ACOMPANAMIENTO")
    private String motivoAcompanamiento;

    @Column(name = "DESDE_ACOMPANAMIENTO")
    @Temporal(TemporalType.DATE)
    private Date desdeAcompanamiento;

    @Column(name = "PORQUE_SOLICITA")
    private String porqueSolicita;

    @Column(name = "PREFERENCIA_PSICOLOGO")
    private String preferenciaPsicologo;

    @Column(name = "ENFOQUE_TERAPEUTICO")
    private String enfoqueTerapeutico;

    @Column(name = "PREFERENCIA")
    private String preferencia;

    @Column(name = "REFERIDO_POR")
    private String referidoPor;
}