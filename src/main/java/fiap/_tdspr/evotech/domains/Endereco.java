package fiap._tdspr.evotech.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idEndereco;

    @NotBlank
    @Size(min = 5, max = 100)
    private String logradouro;

    @NotBlank
    @Size(min = 1, max = 10)
    private String numero;

    @Size(max = 100)
    private String complemento;

    @NotBlank
    @Size(min = 5, max = 100)
    private String bairro;

    @NotBlank
    @Size(min = 5, max = 100)
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    private String estado;

    @NotBlank
    @Size(min = 8, max = 9)
    private String cep;
}
