package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.gateways.responses.ClienteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController{
    private final CrudCLi crudCliente;
    @Override
    public ResponseEntity<Optional<ClienteResponseDTO>> getCliente(String id) {
        Optional<ClienteResponseDTO> clienteResponseDto = crudCliente.getOne(id);

        return ResponseEntity.ok(clienteResponseDto);
    }


}
