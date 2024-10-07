package fiap._tdspr.evotech.domains;

import lombok.*;
import jakarta.persistence.*;


import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_clie;
    private String Cpf;
    private LocalDate dt_cadastro;
    private String nm_clie;
    private String genero;
    private String telefone;
    private String email;
    private String senha;

}
