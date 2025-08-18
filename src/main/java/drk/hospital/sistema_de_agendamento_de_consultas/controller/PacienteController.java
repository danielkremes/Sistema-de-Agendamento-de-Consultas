package drk.hospital.sistema_de_agendamento_de_consultas.controller;

import drk.hospital.sistema_de_agendamento_de_consultas.entities.ContatoPaciente;
import drk.hospital.sistema_de_agendamento_de_consultas.entities.Paciente;
import drk.hospital.sistema_de_agendamento_de_consultas.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = pacienteService.criarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.atualizarPaciente(id, paciente));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
