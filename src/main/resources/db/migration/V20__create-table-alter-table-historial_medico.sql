ALTER TABLE historial_medico
DROP COLUMN medico_responsable,
ADD COLUMN id_medico BIGINT NULL,
ADD CONSTRAINT fk_historial_medico
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico);
