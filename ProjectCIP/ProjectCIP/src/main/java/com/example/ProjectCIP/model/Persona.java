package com.example.ProjectCIP.model;

import com.example.ProjectCIP.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The persistent class for the PERSONA database table.
 *
 */
@Entity
@Table(name = "PERSONA")
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
    @Column(name = "CODIGO_PERSONA")
    private Long codigoPersona;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "NACIONALIDAD")
    private String nacionalidad;

    @Column(name = "ESTADO_CIVIL")
    private Long estadoCivil;

    @Column(name = "LUGAR_NACIMIENTO")
    private String lugarNacimiento;

    @Column(name = "DUC")
    private Long dui;

    @Column(name = "TELEFONO1")
    private Long telefono1;

    @Column(name = "TELEFONO2")
    private Long telefono2;

    @Column(name = "LUGAR_RESIDENCIA")
    private String lugarResidencia;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "CANTIDAD_HIJO")
    private Integer cantidadHijo;

    @Column(name = "TIENE_HIJO")
    private String tieneHijo;

    @Column(name = "ESTUDIA")
    private String estudia;

    @Column(name = "LUGAR_ESTUDIO")
    private String lugarEstudio;

    @Column(name = "ESPECIALIDAD_ESTUDIO")
    private String especialidadEstudio;

    @Column(name = "GRADO_ACADEMICO")
    private Integer gradoAcademico;

    @Column(name = "TRABAJA")
    private String trabaja;

    @Column(name = "LUGAR_TRABAJO")
    private String lugarTrabajo;

    @Column(name = "ENFERMEDAD_ESPECIFICA")
    private String enfermedadEspecifica;

    @Column(name = "MODALIDAD_SERVICIO")
    private String modalidadServicio;

    @Column(name = "MOTIVO_CONSULTA")
    private String motivoConsulta;

    @Column(name = "DESDE_PROBLEMA")
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    private LocalDate  desdeProblema;

    @Column(name = "PRIMERA_VEZ_CONSULTA")
    private String primeraVezConsulta;

    @Column(name = "CONSULTA_ANTERIOR")
    private String consultaAnterior;

    @Column(name = "TELEFONO_EMERGENCIA")
    private String telefonoEmergencia;

    @Column(name = "CELULAR")
    private Long celular;

    @Column(name = "NOMBRE_EMERGENCIA")
    private String nombreEmergencia;

    @Column(name = "PARENTESCO_EMERGENCIA")
    private String parentescoEmergencia;

    @Column(name = "COMENTARIOS_ADICIONAL")
    private String comentariosAdicional;

    @Column(name = "ES_PACIENTE")
    private String esPaciente;

    @Column(name = "FECHA_NACIMIENTO")
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    private LocalDate  fechaNacimiento;

    @Column(name = "CARGO_DESEMPEÑA")
    private String cargoDesempeña;

    @Column(name = "DIAGNOSTICO_FAMILIAR")
    private String diagnosticoFamiliar;

    @Column(name = "DIAGNOSTICO_PROPIO")
    private String diagnosticoPropio;

    @Column(name = "MEDICAMENTOS")
    private String medicamentos;

    @Column(name = "TIEMPO_TRATAMIENTO")
    private String tiempoTratamiento;

    @Column(name = "PADECE_ENFERMEDAD")
    private String padeceEnfermedad;

    @Column(name = "EXISTE_ANTECEDENTE_PSI")
    private String existeAntecedentePsi;

    @Column(name = "TRATAMIENTO_PSICO_ACTUAL")
    private String tratamientoPsicoActual;

    @Column(name = "ASISTIO_CONSULTA_PSI")
    private String asistioConsultaPsi;

    @ManyToOne
    @JoinColumn(name = "SERVICIO_SOLICITA")
    private Servicio servicio;

    @Column(name = "ANIO_CONSULTA_ANTERIOR")
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    private LocalDate anioConsultaAnterior;

    @ManyToOne
    @JoinColumn(name = "ESTADO")
    private Estado estado;




}