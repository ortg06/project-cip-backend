package com.example.ProjectCIP.repository;

import com.example.ProjectCIP.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaAdultoRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {

    List<Persona> findByEstado_CodigoEstado(Long codigoEstado);
    List<Persona> findByEstado_CodigoEstadoAndEsPaciente(Long codigoEstado, String esPaciente);
}
