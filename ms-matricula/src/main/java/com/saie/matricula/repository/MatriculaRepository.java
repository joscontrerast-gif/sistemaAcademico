package com.saie.matricula.repository;

import com.saie.matricula.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByEstudianteId(Long estudianteId);

    List<Matricula> findByCursoId(Long cursoId);
}