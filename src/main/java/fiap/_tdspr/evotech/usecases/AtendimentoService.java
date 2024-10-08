package fiap._tdspr.evotech.usecases;

import fiap._tdspr.evotech.domains.Atendimento;
import fiap._tdspr.evotech.gateways.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> findById(String id) {
        return atendimentoRepository.findById(id);
    }

    public Atendimento save(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public void deleteById(String id) {
        atendimentoRepository.deleteById(id);
    }
}