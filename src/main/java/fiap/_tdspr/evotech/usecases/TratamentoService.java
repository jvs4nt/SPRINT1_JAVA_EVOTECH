package fiap._tdspr.evotech.usecases;

import fiap._tdspr.evotech.domains.Tratamento;
import fiap._tdspr.evotech.gateways.repositories.TratamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamentoService {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    public List<Tratamento> findAll() {
        return tratamentoRepository.findAll();
    }

    public Optional<Tratamento> findById(String id) {
        return tratamentoRepository.findById(id);
    }

    public Tratamento save(Tratamento tratamento) {
        return tratamentoRepository.save(tratamento);
    }

    public void deleteById(String id) {
        tratamentoRepository.deleteById(id);
    }
}