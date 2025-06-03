package umg.edu.gt.progra3.turnos.repository.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import umg.edu.gt.progra3.turnos.repository.model.TurnoLog;
@Repository
public interface TurnoLogRepository extends MongoRepository<TurnoLog, String> {
}