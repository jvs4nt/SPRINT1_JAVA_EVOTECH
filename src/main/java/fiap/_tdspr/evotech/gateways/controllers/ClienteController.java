package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.Cliente;
import fiap._tdspr.evotech.usecases.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Cliente>>> getAllClientes() {
        List<EntityModel<Cliente>> clientes = clienteService.findAll().stream()
                .map(cliente -> EntityModel.of(cliente,
                        linkTo(methodOn(ClienteController.class).getClienteById(cliente.getIdCliente())).withSelfRel(),
                        linkTo(methodOn(ClienteController.class).getAllClientes()).withRel("allClientes")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(clientes,
                linkTo(methodOn(ClienteController.class).getAllClientes()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> getClienteById(@PathVariable String id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            EntityModel<Cliente> clienteModel = EntityModel.of(cliente.get(),
                    linkTo(methodOn(ClienteController.class).getClienteById(id)).withSelfRel(),
                    linkTo(methodOn(ClienteController.class).getAllClientes()).withRel("allClientes"));

            return ResponseEntity.ok(clienteModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<Cliente>> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.save(cliente);
        EntityModel<Cliente> clienteModel = EntityModel.of(createdCliente,
                linkTo(methodOn(ClienteController.class).getClienteById(createdCliente.getIdCliente())).withSelfRel(),
                linkTo(methodOn(ClienteController.class).getAllClientes()).withRel("allClientes"));

        return ResponseEntity.status(201).body(clienteModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> updateCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        if (!clienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        Cliente updatedCliente = clienteService.save(cliente);

        EntityModel<Cliente> clienteModel = EntityModel.of(updatedCliente,
                linkTo(methodOn(ClienteController.class).getClienteById(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).getAllClientes()).withRel("allClientes"));

        return ResponseEntity.ok(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
