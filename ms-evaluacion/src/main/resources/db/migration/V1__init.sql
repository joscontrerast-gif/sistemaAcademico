CREATE TABLE evaluaciones (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nombre VARCHAR(100),
                              profesor_id BIGINT,
                              curso_id BIGINT,
                              fecha DATE,
                              ponderacion DOUBLE
);