CREATE TABLE asistencias (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             estudiante_id BIGINT,
                             curso_id BIGINT,
                             fecha DATE,
                             presente BOOLEAN
);