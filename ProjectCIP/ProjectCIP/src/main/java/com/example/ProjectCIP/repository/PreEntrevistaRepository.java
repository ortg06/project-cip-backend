package com.example.ProjectCIP.repository;

import com.example.ProjectCIP.model.InfoAdicionalEntrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PreEntrevistaRepository extends JpaRepository<InfoAdicionalEntrevista, Long>, JpaSpecificationExecutor<InfoAdicionalEntrevista> {
}
