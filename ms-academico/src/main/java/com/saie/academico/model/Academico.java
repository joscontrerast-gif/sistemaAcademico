package com.saie.academico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "academicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Academico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String carrera;

    private String asignatura;

    private Double promedio;
}