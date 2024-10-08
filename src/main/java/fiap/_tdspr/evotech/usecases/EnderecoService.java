package fiap._tdspr.evotech.usecases;

import fiap._tdspr.evotech.domains.Endereco;
import fiap._tdspr.evotech.gateways.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(String id) {
        return enderecoRepository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(String id) {
        enderecoRepository.deleteById(id);
    }
}