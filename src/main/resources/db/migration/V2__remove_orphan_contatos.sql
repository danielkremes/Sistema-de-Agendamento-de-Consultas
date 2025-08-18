-- Remove contatos sem paciente associado
--DELETE FROM tb_contato_paciente
--WHERE paciente_id IS NULL;

-- Opcional: se quiser impedir que isso aconteça novamente, torne paciente_id NOT NULL
-- ALTER TABLE tb_contato_paciente
-- MODIFY paciente_id BIGINT NOT NULL;
