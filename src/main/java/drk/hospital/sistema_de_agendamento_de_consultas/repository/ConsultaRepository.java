package drk.hospital.sistema_de_agendamento_de_consultas.repository;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}