package fiap._tdspr.evotech.usecases.clientes.interfaces;

import fiap._tdspr.evotech.gateways.requests.ClienteRequestPostDto;
import fiap._tdspr.evotech.gateways.responses.ClienteResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudCliente {
    ClienteResponseDTO save(ClienteRequestPostDto clienteRequestPostDto);
}
