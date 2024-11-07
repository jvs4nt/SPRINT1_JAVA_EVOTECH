package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.Tratamento;
import fiap._tdspr.evotech.usecases.TratamentoService;
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
@RequestMapping("/tratamentos")
public class TratamentoController {

    @Autowired
    private TratamentoService tratamentoService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Tratamento>>> getAllTratamentos() {
        List<EntityModel<Tratamento>> tratamentos = tratamentoService.findAll().stream()
                .map(tratamento -> EntityModel.of(tratamento,
                        linkTo(methodOn(TratamentoController.class).getTratamentoById(tratamento.getIdTratamento())).withSelfRel(),
                        linkTo(methodOn(TratamentoController.class).getAllTratamentos()).withRel("allTratamentos")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(tratamentos,
                linkTo(methodOn(TratamentoController.class).getAllTratamentos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Tratamento>> getTratamentoById(@PathVariable String id) {
        Optional<Tratamento> tratamento = tratamentoService.findById(id);
        if (tratamento.isPresent()) {
            EntityModel<Tratamento> tratamentoModel = EntityModel.of(tratamento.get(),
                    linkTo(methodOn(TratamentoController.class).getTratamentoById(id)).withSelfRel(),
                    linkTo(methodOn(TratamentoController.class).getAllTratamentos()).withRel("allTratamentos"));
            return ResponseEntity.ok(tratamentoModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<Tratamento>> createTratamento(@RequestBody Tratamento tratamento) {
        Tratamento createdTratamento = tratamentoService.save(tratamento);
        EntityModel<Tratamento> tratamentoModel = EntityModel.of(createdTratamento,
                linkTo(methodOn(TratamentoController.class).getTratamentoById(createdTratamento.getIdTratamento())).withSelfRel(),
                linkTo(methodOn(TratamentoController.class).getAllTratamentos()).withRel("allTratamentos"));
        return ResponseEntity.status(201).body(tratamentoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Tratamento>> updateTratamento(@PathVariable String id, @RequestBody Tratamento tratamento) {
        Optional<Tratamento> existingTratamento = tratamentoService.findById(id);
        if (existingTratamento.isPresent()) {
            tratamento.setIdTratamento(id);
            Tratamento updatedTratamento = tratamentoService.save(tratamento);
            EntityModel<Tratamento> tratamentoModel = EntityModel.of(updatedTratamento,
                    linkTo(methodOn(TratamentoController.class).getTratamentoById(id)).withSelfRel(),
                    linkTo(methodOn(TratamentoController.class).getAllTratamentos()).withRel("allTratamentos"));
            return ResponseEntity.ok(tratamentoModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTratamento(@PathVariable String id) {
        if (tratamentoService.findById(id).isPresent()) {
            tratamentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
