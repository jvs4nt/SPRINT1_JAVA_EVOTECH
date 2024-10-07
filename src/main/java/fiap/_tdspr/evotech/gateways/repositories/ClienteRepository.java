package fiap._tdspr.evotech.gateways.repositories;

import fiap._tdspr.evotech.domains.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClienteRepository extends JpaRepository<Cliente,String> {
    Optional<Cliente> findById (@NotEmpty @Valid String id);
}
