package drk.hospital.sistema_de_agendamento_de_consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "nome_paciente")
    private String nome;
    @Column(name = "cpf_paciente")
    private String cpf;
    @Column(name = "data_nascimento_paciente")
    private LocalDateTime dataNascimento;

    @Column(name = "contato_paciente")

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<ContatoPaciente> contatoPaciente;
}
