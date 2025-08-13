package drk.hospital.sistema_de_agendamento_de_consultas.repository;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}