package fiap._tdspr.evotech.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idTratamento;

    @NotBlank
    @Size(min = 3, max = 100)
    private String descricao;
}
