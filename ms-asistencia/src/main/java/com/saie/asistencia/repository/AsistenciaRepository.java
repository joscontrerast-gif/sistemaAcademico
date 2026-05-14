package com.saie.asistencia.repository;

import com.saie.asistencia.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
}