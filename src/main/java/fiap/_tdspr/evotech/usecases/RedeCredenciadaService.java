package fiap._tdspr.evotech.usecases;

import fiap._tdspr.evotech.domains.RedeCredenciada;
import fiap._tdspr.evotech.gateways.repositories.RedeCredenciadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedeCredenciadaService {

    @Autowired
    private RedeCredenciadaRepository redeCredenciadaRepository;

    public List<RedeCredenciada> findAll() {
        return redeCredenciadaRepository.findAll();
    }

    public Optional<RedeCredenciada> findById(String id) {
        return redeCredenciadaRepository.findById(id);
    }

    public RedeCredenciada save(RedeCredenciada redeCredenciada) {
        return redeCredenciadaRepository.save(redeCredenciada);
    }

    public void deleteById(String id) {
        redeCredenciadaRepository.deleteById(id);
    }
}
