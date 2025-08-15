package drk.hospital.sistema_de_agendamento_de_consultas.services;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.Consulta;
import drk.hospital.sistema_de_agendamento_de_consultas.repository.ConsultaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    // POST
    public Consulta cadastrarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // GET
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    // PUT
    public Consulta atualizarConsulta(Long id, Consulta consulta) {
        Consulta consultaExiste = consultaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Consulta não encontrado")
        );
        consultaExiste.setMedico(consulta.getMedico());
        consultaExiste.setPaciente(consulta.getPaciente());
        consultaExiste.setConsultaDataHora(consulta.getConsultaDataHora());
        return consultaRepository.save(consultaExiste);
    }

    // DELETE
    public void deletarConsulta(Long id) {

        if (!consultaRepository.existsById(id)) {
            throw new EntityNotFoundException("Agenda não encontrada");
        }
        consultaRepository.deleteById(id);
    }

}
