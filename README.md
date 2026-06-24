SISTEMA ACADEMICO INTEGRADO ESTUDIANTIL (S.A.I.E.)

SIRVE PARA DIGITALIZAR LA INFORMACION DE CURSOS, ALUMNOS, EVALUACIONES Y ASISTENCIA RESPECTO A UN CURSO, APLICABLE A CUALQUIER INSTITUCION DE EDUCACION.

FLOW DE DATOS:

        USUARIOS ─────────┐
                          │
                          ▼
                    MATRICULA
                          │
                          ▼
                     ACADEMICO (CURSO/PROFESOR)
                          │
          ┌───────────────┼───────────────┐
          ▼               ▼               ▼
     EVALUACION     ASISTENCIA      OTROS MS (EXPANDIBLE)

 SISTEMA ACADÉMICO INTEGRADO ESTUDIANTIL (S.A.I.E)

 Descripción

S.A.I.E es un sistema académico desarrollado con arquitectura de microservicios. Su función principal es administrar estudiantes, matrículas, evaluaciones, cursos y asistencias dentro de una institución educativa.

El sistema fue desarrollado utilizando Java Spring Boot, MySQL, Maven,OpenFeign para la comunicación entre microservicios y Flyway en conjunto a scripts de sql para la creacion y llenado de las bases de datos.

---

# Arquitectura General

## Flujo del Sistema

```text
USUARIOS
   ↓
MATRÍCULA
   ↓
ACADÉMICO
   ↓
EVALUACIÓN / ASISTENCIA
```


# Microservicios

| Microservicio | Función | Puerto |
|---|---|---|
| ms-usuarios | Gestión de usuarios y estudiantes | 8081
| ms-academico | Gestión académica y cursos | 8082
| ms-matricula | Registro de matrículas | 8083
| ms-evaluacion | Evaluaciones y notas | 8084
| ms-asistencia | Control de asistencia | 8085

---

# Base de Datos y Entidades

## ms-usuarios

### Tabla: usuarios

Guarda la información principal de los usuarios del sistema.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| nombre | String |
| correo | String |
| rol | String |

### Función

Este microservicio administra estudiantes y usuarios que luego son utilizados por los demás microservicios.

---

## ms-matricula

### Tabla: matriculas

Registra las matrículas de estudiantes en cursos.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| estudianteId | Long |
| cursoId | Long |
| fechaMatricula | LocalDate |
| estado | String |

### Función

Permite registrar estudiantes en cursos y mantener control del estado de matrícula.

---

## ms-academico

### Tabla: academicos

Contiene la información académica relacionada con cursos y asignaturas.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| nombre | String |
| carrera | String |
| asignatura | String |
| promedio | Double |

### Función

Centraliza información académica utilizada por evaluaciones y asistencia.

---

## ms-evaluacion

### Tabla: evaluaciones

Guarda las evaluaciones realizadas dentro del sistema.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| nombre | String |
| profesorId | Long |
| cursoId | Long |
| fecha | LocalDate |
| ponderacion | Double |

### Tabla: calificaciones

Registra las notas obtenidas por los estudiantes.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| evaluacionId | Long |
| estudianteId | Long |
| nota | Double |
| observacion | String |

### Función

Permite administrar evaluaciones, notas y observaciones académicas.

---

## ms-asistencia

### Tabla: asistencias

Registra la asistencia de estudiantes a clases.

### Campos

| Campo | Tipo |
|---|---|
| id | Long |
| usuarioId | Long |
| academicoId | Long |
| estudiante | String |
| asignatura | String |
| fecha | String |
| presente | Boolean |

### Función

Controla la asistencia e inasistencia de estudiantes en asignaturas.

---

# Relación Entre Microservicios

```text
USUARIO
   │
   └── MATRÍCULA
           │
           └── ACADÉMICO
                   │
                   ├── EVALUACIÓN
                   └── ASISTENCIA
```

---

# Comunicación Entre Microservicios

El sistema utiliza OpenFeign para permitir la comunicación entre microservicios mediante solicitudes HTTP internas.

Gracias a esto, un microservicio puede consultar información de otro sin necesidad de duplicar datos.

---

# Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- OpenFeign
- Lombok
- JWT
- JUNIT5
- API Gateway
- YAML
- Docker
- Swagger
- DataFaker

---

# Estructura del Proyecto

```text
sistemaAcademico-main
│
├── ms-usuarios
├── ms-matricula
├── ms-academico
├── ms-evaluacion
├── ms-asistencia
└── README.md
```

---

# Objetivos

- Digitalizar procesos académicos
- Mejorar la gestión estudiantil
- Centralizar información
- Facilitar el control de asistencia y evaluaciones
- Aplicar arquitectura de microservicios

---

# Mejoras Futuras

- Kubernetes
- Panel web administrativo
- Dashboard académico

---

# Conclusión

S.A.I.E es un sistema académico modular desarrollado con microservicios que permite gestionar información estudiantil de manera organizada, escalable y mantenible.
