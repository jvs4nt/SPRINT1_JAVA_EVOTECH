package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.RedeCredenciada;
import fiap._tdspr.evotech.usecases.RedeCredenciadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/rede-credenciada")
public class RedeCredenciadaController {

    @Autowired
    private RedeCredenciadaService redeCredenciadaService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<RedeCredenciada>>> getAllRedesCredenciadas() {
        List<EntityModel<RedeCredenciada>> redesCredenciadas = redeCredenciadaService.findAll().stream()
                .map(rede -> EntityModel.of(rede,
                        linkTo(methodOn(RedeCredenciadaController.class).getRedeCredenciadaById(rede.getIdEmpresa())).withSelfRel(),
                        linkTo(methodOn(RedeCredenciadaController.class).getAllRedesCredenciadas()).withRel("allRedesCredenciadas")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(redesCredenciadas,
                linkTo(methodOn(RedeCredenciadaController.class).getAllRedesCredenciadas()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<RedeCredenciada>> getRedeCredenciadaById(@PathVariable String id) {
        Optional<RedeCredenciada> redeCredenciada = redeCredenciadaService.findById(id);
        if (redeCredenciada.isPresent()) {
            EntityModel<RedeCredenciada> redeCredenciadaModel = EntityModel.of(redeCredenciada.get(),
                    linkTo(methodOn(RedeCredenciadaController.class).getRedeCredenciadaById(id)).withSelfRel(),
                    linkTo(methodOn(RedeCredenciadaController.class).getAllRedesCredenciadas()).withRel("allRedesCredenciadas"));

            return ResponseEntity.ok(redeCredenciadaModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<RedeCredenciada>> createRedeCredenciada(@RequestBody RedeCredenciada redeCredenciada) {
        RedeCredenciada createdRedeCredenciada = redeCredenciadaService.save(redeCredenciada);
        EntityModel<RedeCredenciada> redeCredenciadaModel = EntityModel.of(createdRedeCredenciada,
                linkTo(methodOn(RedeCredenciadaController.class).getRedeCredenciadaById(createdRedeCredenciada.getIdEmpresa())).withSelfRel(),
                linkTo(methodOn(RedeCredenciadaController.class).getAllRedesCredenciadas()).withRel("allRedesCredenciadas"));

        return ResponseEntity.status(201).body(redeCredenciadaModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<RedeCredenciada>> updateRedeCredenciada(@PathVariable String id, @RequestBody RedeCredenciada redeCredenciada) {
        Optional<RedeCredenciada> existingRedeCredenciada = redeCredenciadaService.findById(id);
        if (existingRedeCredenciada.isPresent()) {
            redeCredenciada.setIdEmpresa(id);
            RedeCredenciada updatedRedeCredenciada = redeCredenciadaService.save(redeCredenciada);
            EntityModel<RedeCredenciada> redeCredenciadaModel = EntityModel.of(updatedRedeCredenciada,
                    linkTo(methodOn(RedeCredenciadaController.class).getRedeCredenciadaById(id)).withSelfRel(),
                    linkTo(methodOn(RedeCredenciadaController.class).getAllRedesCredenciadas()).withRel("allRedesCredenciadas"));

            return ResponseEntity.ok(redeCredenciadaModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRedeCredenciada(@PathVariable String id) {
        if (redeCredenciadaService.findById(id).isPresent()) {
            redeCredenciadaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
