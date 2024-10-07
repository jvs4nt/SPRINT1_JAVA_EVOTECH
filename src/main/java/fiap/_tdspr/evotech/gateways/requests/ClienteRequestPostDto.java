package fiap._tdspr.evotech.gateways.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteRequestPostDto {
    @NotEmpty
    private String nm_clie;
}
