package drk.hospital.sistema_de_agendamento_de_consultas.services;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Medico;
import drk.hospital.sistema_de_agendamento_de_consultas.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    // POST
    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // GET
    public List<Medico> listarPacientes() {
        return medicoRepository.findAll();
    }

    // PUT
    public Medico atualizarPaciente(Long id, Medico medico) {
        Medico medicoExiste = medicoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado")
        );

        medicoExiste.setNome(medico.getNome());
        medicoExiste.setCrm(medico.getCrm());
        medicoExiste.setEspecialidadeMedico(medico.getEspecialidadeMedico());
        medicoExiste.setContatoMedico(medico.getContatoMedico());
        return medicoRepository.save(medicoExiste);
    }

    // DELETE
    public void deletarPaciente(Long id) {

        if (!medicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Medico não encontrado");
        }
        medicoRepository.deleteById(id);
    }

}
