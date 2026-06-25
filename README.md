# SISTEMA ACADÉMICO INTEGRADO ESTUDIANTIL (S.A.I.E.)

## Descripción General

S.A.I.E. (Sistema Académico Integrado Estudiantil) es una plataforma desarrollada bajo una arquitectura de microservicios que permite gestionar información académica de manera centralizada, modular y escalable.

El sistema digitaliza procesos relacionados con estudiantes, matrículas, cursos, evaluaciones y asistencia, siendo aplicable a instituciones educativas de distintos niveles.

La solución fue desarrollada utilizando Java Spring Boot, MySQL, Maven, OpenFeign, Flyway, Eureka Discovery Server, API Gateway y Docker.

---

# Arquitectura General

## Flujo de Datos

```text
        USUARIOS ─────────┐
                          │
                          ▼
                    MATRICULA
                          │
                          ▼
                     ACADEMICO (CURSO)
                          │
          ┌───────────────┼───────────────┐
          ▼               ▼               ▼
     EVALUACION     ASISTENCIA      OTROS MS (EXPANDIBLE)
```

## Arquitectura de Despliegue

```text
                           CLIENTE
                              │
                              ▼
                        API GATEWAY
                              │
                              ▼
                        EUREKA SERVER
                              │
    ┌──────────────┬──────────────┬──────────────┬──────────────┬──────────────┐
    ▼              ▼              ▼              ▼              ▼
MS-USUARIOS   MS-ACADEMICO   MS-MATRICULA   MS-EVALUACION   MS-ASISTENCIA
       │              │              │              │              │
       └──────────────┴──────────────┴──────────────┴──────────────┘
                                      │
                                      ▼
                                    MYSQL
```

---

# Descripción de los Microservicios

| Microservicio | Función | Puerto |
|--------------|----------|---------|
| ms-usuarios | Gestión de usuarios y estudiantes | 8081 |
| ms-academico | Gestión académica y cursos | 8082 |
| ms-matricula | Gestión de matrículas | 8083 |
| ms-evaluacion | Gestión de evaluaciones y calificaciones | 8084 |
| ms-asistencia | Gestión de asistencia | 8085 |
| api-gateway | Punto único de acceso al sistema | 8080 |
| eureka-server | Registro y descubrimiento de servicios | 8761 |

---

# Bases de Datos

Cada microservicio utiliza una base de datos independiente siguiendo los principios de arquitectura de microservicios.

| Microservicio | Base de Datos |
|--------------|--------------|
| ms-usuarios | usuarios_db |
| ms-academico | academico_db |
| ms-matricula | matricula_db |
| ms-evaluacion | evaluacion_db |
| ms-asistencia | asistencia_db |

---

# Base de Datos y Entidades

## ms-usuarios

### Tabla: usuarios

Guarda la información principal de los usuarios del sistema.

| Campo | Tipo |
|---------|---------|
| id | Long |
| nombre | String |
| correo | String |
| rol | String |

### Función

Administra estudiantes y usuarios que luego son utilizados por los demás microservicios.

---

## ms-matricula

### Tabla: matriculas

Registra las matrículas de estudiantes en cursos.

| Campo | Tipo |
|---------|---------|
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

| Campo | Tipo |
|---------|---------|
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

| Campo | Tipo |
|---------|---------|
| id | Long |
| nombre | String |
| profesorId | Long |
| cursoId | Long |
| fecha | LocalDate |
| ponderacion | Double |

### Tabla: calificaciones

Registra las notas obtenidas por los estudiantes.

| Campo | Tipo |
|---------|---------|
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

| Campo | Tipo |
|---------|---------|
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
   └── MATRICULA
           │
           └── ACADEMICO
                   │
                   ├── EVALUACION
                   └── ASISTENCIA
```

---

# Comunicación Entre Microservicios

El sistema utiliza OpenFeign para permitir la comunicación entre microservicios mediante solicitudes HTTP internas.

Gracias a esto:

- Se evita la duplicación de datos.
- Se mantiene independencia entre servicios.
- Se facilita la escalabilidad.
- Se simplifica la integración entre módulos.

El descubrimiento de servicios es gestionado mediante Eureka Discovery Server.

---

# Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- Spring Cloud Gateway
- Eureka Server
- Eureka Client
- MySQL 8
- Flyway
- Maven
- Lombok
- JWT
- JUnit 5
- Swagger/OpenAPI
- DataFaker
- Docker
- Docker Compose
- YAML

---

# Estructura del Proyecto

```text
sistemaAcademico
│
├── eureka-server
├── api-gateway
├── ms-usuarios
├── ms-academico
├── ms-matricula
├── ms-evaluacion
├── ms-asistencia
├── docker-compose.yml
└── README.md
```

---

# Dockerización

El sistema se encuentra completamente dockerizado.

Cada microservicio posee su propio Dockerfile y todos los servicios pueden ser desplegados mediante Docker Compose.

Servicios desplegados:

- MySQL
- Eureka Server
- API Gateway
- ms-usuarios
- ms-academico
- ms-matricula
- ms-evaluacion
- ms-asistencia

---

# Requisitos Previos

Antes de ejecutar el proyecto es necesario tener instalado:

- Docker Desktop
- Git

No es necesario instalar MySQL localmente ni ejecutar manualmente los microservicios.

---

# Ejecución del Proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/joscontrerast-gif/sistemaAcademico.git
```

```bash
cd sistemaAcademico
```


---
## 2. Construir y levantar los contenedores

```bash
docker compose up -d --build
```

---

## 3. Verificar contenedores

```bash
docker ps
```

Deben aparecer:

```text
mysql-saie
eureka-server
api-gateway
ms-usuarios
ms-academico
ms-matricula
ms-evaluacion
ms-asistencia
```

---

# Eureka Discovery Server

Acceso:

```text
http://localhost:8761
```

Servicios registrados esperados:

```text
API-GATEWAY
MS-USUARIOS
MS-ACADEMICO
MS-MATRICULA
MS-EVALUACION
MS-ASISTENCIA
```

---

# API Gateway

URL Base:

```text
http://localhost:8080
```

Todas las solicitudes externas al sistema deben realizarse mediante API Gateway.

---

# Pruebas

Las pruebas unitarias fueron desarrolladas utilizando JUnit 5.

Ejecutar pruebas:

```bash
./mvnw test
```

Generar artefactos:

```bash
./mvnw clean package
```

---

# Objetivos del Proyecto

- Digitalizar procesos académicos.
- Gestionar estudiantes y matrículas.
- Centralizar información institucional.
- Controlar asistencia y evaluaciones.
- Aplicar arquitectura de microservicios.
- Implementar descubrimiento de servicios.
- Desplegar la solución mediante contenedores Docker.

---

# Mejoras Futuras

- Implementación de Kubernetes.
- Balanceo de carga avanzado.
- Dashboard administrativo.
- Observabilidad con Prometheus y Grafana.
- Autenticación centralizada OAuth2.
- Integración con sistemas institucionales externos.

---

# Conclusión

S.A.I.E. es una solución académica basada en microservicios que permite gestionar información estudiantil de forma organizada, modular y escalable.

La arquitectura implementada incorpora API Gateway, Eureka Discovery Server, bases de datos independientes por servicio, comunicación mediante OpenFeign y despliegue completo mediante Docker Compose, proporcionando un entorno moderno, mantenible y preparado para futuras ampliaciones.
