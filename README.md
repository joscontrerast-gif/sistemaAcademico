SISTEMA ACADÉMICO INTEGRADO ESTUDIANTIL (S.A.I.E.)
Descripción General

S.A.I.E. (Sistema Académico Integrado Estudiantil) es una plataforma desarrollada bajo una arquitectura de microservicios que permite gestionar información académica de manera centralizada y escalable.

El sistema digitaliza procesos relacionados con estudiantes, matrículas, cursos, evaluaciones y asistencia, siendo aplicable a instituciones educativas de distintos niveles.

La solución fue desarrollada utilizando Java Spring Boot, MySQL, Maven, OpenFeign, Flyway, Eureka Discovery Server, API Gateway y Docker.

Arquitectura General
Flujo de Datos
USUARIOS ─────────┐
                  │
                  ▼
             MATRICULA
                  │
                  ▼
            ACADEMICO (CURSO)
                  │
      ┌───────────┼───────────┐
      ▼           ▼           ▼
 EVALUACION  ASISTENCIA   FUTUROS MS
Arquitectura de Microservicios
                    CLIENTE
                       │
                       ▼
                API GATEWAY
                       │
                       ▼
                EUREKA SERVER
                       │
 ┌───────────┬───────────┬───────────┬───────────┬───────────┐
 ▼           ▼           ▼           ▼           ▼
USUARIOS  ACADEMICO  MATRICULA  EVALUACION  ASISTENCIA
                       │
                       ▼
                     MYSQL
Tecnologías Utilizadas
Java 17
Spring Boot
Spring Data JPA
Spring Cloud OpenFeign
Spring Cloud Gateway
Netflix Eureka Server
Netflix Eureka Client
MySQL 8
Flyway
Maven
Docker
Docker Compose
JWT
Lombok
JUnit 5
Swagger/OpenAPI
DataFaker
YAML Configuration
Microservicios
Microservicio	Función	Puerto
ms-usuarios	Gestión de usuarios y estudiantes	8081
ms-academico	Gestión académica y cursos	8082
ms-matricula	Gestión de matrículas	8083
ms-evaluacion	Gestión de evaluaciones y calificaciones	8084
ms-asistencia	Gestión de asistencia	8085
api-gateway	Punto único de acceso	8080
eureka-server	Registro y descubrimiento de servicios	8761
Bases de Datos

Cada microservicio utiliza su propia base de datos siguiendo el principio de independencia de datos.

Microservio	Base de Datos
ms-usuarios	usuarios_db
ms-academico	academico_db
ms-matricula	matricula_db
ms-evaluacion	evaluacion_db
ms-asistencia	asistencia_db
Comunicación Entre Microservicios

La comunicación entre servicios se realiza mediante OpenFeign.

Esto permite:

Consultar información entre microservicios.
Evitar duplicidad de datos.
Mantener bajo acoplamiento.
Facilitar la escalabilidad del sistema.

El descubrimiento de servicios es gestionado por Eureka Server.

Estructura del Proyecto
sistemaAcademico
│
├── api-gateway
├── eureka-server
├── ms-usuarios
├── ms-academico
├── ms-matricula
├── ms-evaluacion
├── ms-asistencia
├── docker-compose.yml
└── README.md
Dockerización

El proyecto se encuentra completamente dockerizado.

Cada microservicio posee su propio Dockerfile y es desplegado mediante Docker Compose.

Servicios desplegados:

MySQL
Eureka Server
API Gateway
ms-usuarios
ms-academico
ms-matricula
ms-evaluacion
ms-asistencia
Requisitos Previos

Antes de ejecutar el proyecto se requiere:

Docker Desktop
Git

No es necesario instalar MySQL ni ejecutar manualmente los microservicios.

Ejecución del Proyecto con Docker Compose
1. Clonar repositorio
git clone https://github.com/joscontrerast-gif/sistemaAcademico.git
cd sistemaAcademico
2. Construir y levantar los servicios
docker compose up -d --build
3. Verificar contenedores
docker ps

Deben aparecer los siguientes contenedores:

mysql-saie
eureka-server
api-gateway
ms-usuarios
ms-academico
ms-matricula
ms-evaluacion
ms-asistencia
Eureka Server

Acceder mediante:

http://localhost:8761

Servicios esperados:

API-GATEWAY
MS-USUARIOS
MS-ACADEMICO
MS-MATRICULA
MS-EVALUACION
MS-ASISTENCIA
API Gateway

URL Base:

http://localhost:8080

Todas las solicitudes externas deben realizarse a través del API Gateway.

Pruebas

Las pruebas unitarias fueron desarrolladas utilizando JUnit 5.

Para ejecutar pruebas:

mvn test

Para generar artefactos:

mvn clean package
Objetivos del Proyecto
Digitalizar procesos académicos.
Gestionar estudiantes y matrículas.
Centralizar información académica.
Controlar evaluaciones y asistencia.
Aplicar arquitectura de microservicios.
Implementar descubrimiento de servicios.
Utilizar contenedores Docker para despliegue.
Mejoras Futuras
Implementación de Kubernetes.
Balanceo de carga avanzado.
Dashboard administrativo web.
Integración con sistemas institucionales.
Monitoreo mediante Prometheus y Grafana.
Autenticación centralizada con OAuth2.
Conclusión

S.A.I.E. es una solución académica basada en microservicios que permite gestionar información estudiantil de forma modular, escalable y mantenible.

La arquitectura implementada incorpora API Gateway, Eureka Discovery Server, bases de datos independientes por servicio, comunicación mediante OpenFeign y despliegue completo mediante Docker Compose, proporcionando un entorno moderno y preparado para futuras ampliaciones.
