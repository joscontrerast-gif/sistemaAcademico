package com.saie.evaluacion.repository;

import com.saie.evaluacion.model.Evaluacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository
        extends JpaRepository<Evaluacion, Long> {
}