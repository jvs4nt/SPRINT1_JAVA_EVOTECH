package fiap._tdspr.evotech.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedeCredenciada {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idEmpresa;

    @NotBlank
    @Size(max = 20)
    private String cnpj;

    @NotNull
    private LocalDate dtCadastro;

    @NotBlank
    @Size(max = 200)
    private String nmEmpresa;

    @Size(max = 150)
    private String especialidade;

    @Size(max = 15)
    private String telefone;

    @Size(max = 300)
    private String email;

    @Size(max = 8)
    private String cep;

    @Size(max = 200)
    private String logradouro;

    @Size(max = 10)
    private String endNum;

    @Size(max = 100)
    private String endCompl;

    @Size(max = 2)
    private String uf;

    @ManyToOne
    @JoinColumn(name = "tb_endereco_id_end")
    private Endereco endereco;
}
