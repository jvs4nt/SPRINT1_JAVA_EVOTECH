package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.gateways.responses.ClienteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public interface ClienteController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<ClienteResponseDTO>> getCliente(@PathVariable @Valid String id);
}
