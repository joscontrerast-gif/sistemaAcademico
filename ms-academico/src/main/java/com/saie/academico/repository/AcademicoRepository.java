package com.saie.academico.repository;

import com.saie.academico.model.Academico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicoRepository extends JpaRepository<Academico, Long> {
}