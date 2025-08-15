package drk.hospital.sistema_de_agendamento_de_consultas.services;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Agenda;
import drk.hospital.sistema_de_agendamento_de_consultas.repository.AgendaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendaRepository agendaRepository;

    // POST
    public Agenda cadastrarAgendamento(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    // GET
    public List<Agenda> listarAgendamento() {
        return agendaRepository.findAll();
    }

    // PUT
    public Agenda atualizarAgenamento(Long id, Agenda agenda) {
        Agenda agendaExiste = agendaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Agenda não encontrado")
        );
        agendaExiste.setConsultas(agenda.getConsultas());
        return agendaRepository.save(agendaExiste);
    }

    // DELETE
    public void deletarAgenda(Long id) {

        if (!agendaRepository.existsById(id)) {
            throw new EntityNotFoundException("Agenda não encontrada");
        }
        agendaRepository.deleteById(id);
    }

}
