package drk.hospital.sistema_de_agendamento_de_consultas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contato_medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "telefone_medico", length = 11, nullable = false, unique = true)
    private String telefone;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "whatsapp_medico", length = 11, nullable = false, unique = true)
    private String whatsAppMedico;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
