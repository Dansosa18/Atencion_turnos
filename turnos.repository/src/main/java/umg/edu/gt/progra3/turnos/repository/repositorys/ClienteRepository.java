package umg.edu.gt.progra3.turnos.repository.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.edu.gt.progra3.turnos.repository.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}