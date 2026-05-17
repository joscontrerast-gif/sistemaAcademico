CREATE TABLE matriculas (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            estudiante_id BIGINT NOT NULL,
                            curso_id BIGINT NOT NULL,
                            fecha_matricula DATE,
                            estado VARCHAR(50)
);