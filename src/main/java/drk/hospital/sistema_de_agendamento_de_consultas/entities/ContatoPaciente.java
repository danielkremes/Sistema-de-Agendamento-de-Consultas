package drk.hospital.sistema_de_agendamento_de_consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contato_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "telefone_paciente", length = 11, nullable = false, unique = true)
    private String telefone;

    @Column(name = "email_paciente", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "whatsapp_paciente", length = 11, nullable = false, unique = true)
    private String whatsAppPaciente;

    @ManyToOne
    @JoinColumn(name = "id_contato_paciente", referencedColumnName = "id")
    private Paciente paciente;
}
