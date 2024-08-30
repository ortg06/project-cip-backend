package com.example.ProjectCIP.repository;

import com.example.ProjectCIP.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaAdultoRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {
}
