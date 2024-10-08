package fiap._tdspr.evotech.gateways.repositories;

import fiap._tdspr.evotech.domains.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, String> {
}