package fiap._tdspr.evotech.gateways.repositories;

import fiap._tdspr.evotech.domains.RedeCredenciada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeCredenciadaRepository extends JpaRepository<RedeCredenciada, String> {
}