package com.example.ProjectCIP.repository;

import com.example.ProjectCIP.model.GradoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoAcademicoRepository extends JpaRepository<GradoAcademico, Long>, JpaSpecificationExecutor<GradoAcademico> {
}
