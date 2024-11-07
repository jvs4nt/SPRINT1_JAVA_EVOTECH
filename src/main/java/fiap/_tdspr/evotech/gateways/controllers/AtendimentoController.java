package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.Atendimento;
import fiap._tdspr.evotech.usecases.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Atendimento>>> getAllAtendimentos() {
        List<EntityModel<Atendimento>> atendimentos = atendimentoService.findAll().stream()
                .map(atendimento -> EntityModel.of(atendimento,
                        linkTo(methodOn(AtendimentoController.class).getAtendimentoById(atendimento.getIdAtendimento())).withSelfRel(),
                        linkTo(methodOn(AtendimentoController.class).getAllAtendimentos()).withRel("allAtendimentos")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(atendimentos,
                linkTo(methodOn(AtendimentoController.class).getAllAtendimentos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Atendimento>> getAtendimentoById(@PathVariable String id) {
        Optional<Atendimento> atendimento = atendimentoService.findById(id);
        if (atendimento.isPresent()) {
            EntityModel<Atendimento> atendimentoModel = EntityModel.of(atendimento.get(),
                    linkTo(methodOn(AtendimentoController.class).getAtendimentoById(id)).withSelfRel(),
                    linkTo(methodOn(AtendimentoController.class).getAllAtendimentos()).withRel("allAtendimentos"));

            return ResponseEntity.ok(atendimentoModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<Atendimento>> createAtendimento(@RequestBody Atendimento atendimento) {
        Atendimento createdAtendimento = atendimentoService.save(atendimento);
        EntityModel<Atendimento> atendimentoModel = EntityModel.of(createdAtendimento,
                linkTo(methodOn(AtendimentoController.class).getAtendimentoById(createdAtendimento.getIdAtendimento())).withSelfRel(),
                linkTo(methodOn(AtendimentoController.class).getAllAtendimentos()).withRel("allAtendimentos"));

        return ResponseEntity.status(201).body(atendimentoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Atendimento>> updateAtendimento(@PathVariable String id, @RequestBody Atendimento atendimento) {
        Optional<Atendimento> existingAtendimento = atendimentoService.findById(id);
        if (existingAtendimento.isPresent()) {
            atendimento.setIdAtendimento(id);
            Atendimento updatedAtendimento = atendimentoService.save(atendimento);
            EntityModel<Atendimento> atendimentoModel = EntityModel.of(updatedAtendimento,
                    linkTo(methodOn(AtendimentoController.class).getAtendimentoById(id)).withSelfRel(),
                    linkTo(methodOn(AtendimentoController.class).getAllAtendimentos()).withRel("allAtendimentos"));

            return ResponseEntity.ok(atendimentoModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable String id) {
        if (atendimentoService.findById(id).isPresent()) {
            atendimentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
