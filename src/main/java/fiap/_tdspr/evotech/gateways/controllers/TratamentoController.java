package fiap._tdspr.evotech.gateways.controllers;

import fiap._tdspr.evotech.domains.Tratamento;
import fiap._tdspr.evotech.usecases.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tratamentos")
public class TratamentoController {

    @Autowired
    private TratamentoService tratamentoService;

    @GetMapping
    public ResponseEntity<List<Tratamento>> getAllTratamentos() {
        List<Tratamento> tratamentos = tratamentoService.findAll();
        return ResponseEntity.ok(tratamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamento> getTratamentoById(@PathVariable String id) {
        Optional<Tratamento> tratamento = tratamentoService.findById(id);
        return tratamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tratamento> createTratamento(@RequestBody Tratamento tratamento) {
        Tratamento createdTratamento = tratamentoService.save(tratamento);
        return ResponseEntity.status(201).body(createdTratamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamento> updateTratamento(@PathVariable String id, @RequestBody Tratamento tratamento) {
        Optional<Tratamento> existingTratamento = tratamentoService.findById(id);
        if (existingTratamento.isPresent()) {
            tratamento.setIdTratamento(id);
            Tratamento updatedTratamento = tratamentoService.save(tratamento);
            return ResponseEntity.ok(updatedTratamento);
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
