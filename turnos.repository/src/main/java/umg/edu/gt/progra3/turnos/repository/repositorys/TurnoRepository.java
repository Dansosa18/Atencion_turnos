package umg.edu.gt.progra3.turnos.repository.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}