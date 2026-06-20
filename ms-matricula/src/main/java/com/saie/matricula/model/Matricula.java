package com.saie.matricula.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Data
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long estudianteId;

    private Long cursoId;

    private LocalDate fechaMatricula = LocalDate.now();

    private String estado;
}