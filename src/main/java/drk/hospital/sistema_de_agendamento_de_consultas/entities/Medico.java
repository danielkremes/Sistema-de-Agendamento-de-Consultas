package drk.hospital.sistema_de_agendamento_de_consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "nome_medico")
    private String nome;
    @Column(name = "crm_medico")
    private String crm;
    @Column(name = "especialidade_medico")
    private String especialidadeMedico;

    @OneToMany(mappedBy = "medico")
    private List<ContatoMedico> contatoMedico;
}
