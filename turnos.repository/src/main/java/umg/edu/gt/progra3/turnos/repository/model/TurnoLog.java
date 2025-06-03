package umg.edu.gt.progra3.turnos.repository.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
@Document(collection = "turnos_logs")
public class TurnoLog {
    @Id
    private String id;
    private String accion;
    private Long turnoId;
    private String clienteNombre;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String detalles;
}