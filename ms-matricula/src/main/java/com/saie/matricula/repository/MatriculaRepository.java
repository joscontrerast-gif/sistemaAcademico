package com.saie.matricula.repository;

import com.saie.matricula.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository
        extends JpaRepository<Matricula, Long> {
}