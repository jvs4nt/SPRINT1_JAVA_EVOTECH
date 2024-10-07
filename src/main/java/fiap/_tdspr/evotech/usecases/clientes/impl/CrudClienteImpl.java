package fiap._tdspr.evotech.usecases.clientes.impl;

import fiap._tdspr.evotech.domains.Cliente;
import fiap._tdspr.evotech.gateways.repositories.ClienteRepository;
import fiap._tdspr.evotech.gateways.requests.ClienteRequestPostDto;
import fiap._tdspr.evotech.gateways.responses.ClienteResponseDTO;
import fiap._tdspr.evotech.usecases.clientes.interfaces.CrudCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CrudClienteImpl implements CrudCliente {
    private final ClienteRepository clienteRepository;
    @Override
    public ClienteResponseDTO save(ClienteRequestPostDto clienteRequestPostDto) {
        Cliente clienteCriado = Cliente.builder()
                .nm_clie(clienteRequestPostDto.getNm_clie())
                .build();

        Cliente clienteSalvo = clienteRepository.save(clienteCriado);

        ClienteResponseDTO clienteResponseDto = ClienteResponseDTO.builder()
                .nm_clie(clienteSalvo.getNm_clie())
                .build();

        return clienteResponseDto;
    }

}
