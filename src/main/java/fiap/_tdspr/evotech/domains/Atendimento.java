package fiap._tdspr.evotech.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idAtendimento;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idTratamento")
    private Tratamento tratamento;

    @NotNull
    private LocalDate data;

    @NotBlank
    @Size(max = 500)
    private String observacoes;
}
