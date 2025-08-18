package drk.hospital.sistema_de_agendamento_de_consultas.services;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Paciente;
import drk.hospital.sistema_de_agendamento_de_consultas.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    // POST
    public Paciente criarPaciente(Paciente paciente) {
        // garante que cada contato tenha o paciente setado
        return pacienteRepository.save(paciente);
    }

    // GET
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // PUT
    @Transactional
    public Paciente atualizarPaciente(Long id, Paciente paciente) {
        Paciente pacienteExiste = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        // 1️⃣ Atualiza dados básicos do paciente
        pacienteExiste.setNome(paciente.getNome());
        pacienteExiste.setCpf(paciente.getCpf());
        pacienteExiste.setDataNascimento(paciente.getDataNascimento());

        // 4️⃣ Salva paciente com contatos atualizados
        return pacienteRepository.save(pacienteExiste);
    }


    // DELETE
    public void deletarPaciente(Long id) {

        if (!pacienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Paciente não encontrado");
        }
        pacienteRepository.deleteById(id);
    }

}
