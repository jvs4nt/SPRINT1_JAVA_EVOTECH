package fiap._tdspr.evotech.gateways.repositories;

import fiap._tdspr.evotech.domains.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {
}
