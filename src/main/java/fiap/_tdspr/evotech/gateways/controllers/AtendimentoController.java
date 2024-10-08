package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.Atendimento;
import fiap._tdspr.evotech.usecases.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<Atendimento>> getAllAtendimentos() {
        List<Atendimento> atendimentos = atendimentoService.findAll();
        return ResponseEntity.ok(atendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimentoById(@PathVariable String id) {
        Optional<Atendimento> atendimento = atendimentoService.findById(id);
        return atendimento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atendimento> createAtendimento(@RequestBody Atendimento atendimento) {
        Atendimento createdAtendimento = atendimentoService.save(atendimento);
        return ResponseEntity.status(201).body(createdAtendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable String id, @RequestBody Atendimento atendimento) {
        Optional<Atendimento> existingAtendimento = atendimentoService.findById(id);
        if (existingAtendimento.isPresent()) {
            atendimento.setIdAtendimento(id);
            Atendimento updatedAtendimento = atendimentoService.save(atendimento);
            return ResponseEntity.ok(updatedAtendimento);
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