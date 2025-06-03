package umg.edu.gt.progra3.turnos.service.servicio;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
import umg.edu.gt.progra3.turnos.repository.model.TurnoLog;
import umg.edu.gt.progra3.turnos.repository.repositorys.TurnoLogRepository;

import java.time.LocalDateTime;

@Service
public class LogService {
    @Autowired
    private TurnoLogRepository turnoLogRepository;

    @PostConstruct
    public void logInicioAplicacion() {
        TurnoLog log = new TurnoLog();
        log.setAccion("INICIO_SISTEMA");
        log.setFechaRegistro(LocalDateTime.now());
        log.setDetalles("Sistema de Turnos iniciado exitosamente");
        turnoLogRepository.save(log);

        System.out.println("\n📝 LOG DE INICIO REGISTRADO EN MONGODB");
        mostrarLogConsola(log);
    }


    public void registrarLog(String accion, Turno turno, String detalles) {
        try {
            TurnoLog log = new TurnoLog();
            log.setAccion(accion);
            log.setTurnoId(turno != null ? turno.getId() : null);
            log.setClienteNombre(turno != null && turno.getCliente() != null ? 
                turno.getCliente().getNombre() : null);
            log.setEstado(turno != null ? turno.getEstado() : null);
            log.setFechaRegistro(LocalDateTime.now());
            log.setDetalles(detalles);
            turnoLogRepository.save(log);

            System.out.println("\n📝 LOG REGISTRADO EN MONGODB");

            mostrarLogConsola(log);
        } catch (Exception e) {
            System.err.println("Error al registrar log en MongoDB: " + e.getMessage());
        }
    }

    private void mostrarLogConsola(TurnoLog log) {
        System.out.println("━━━━━━━━━━ REGISTRO DE LOG ━━━━━━━━━━");
        System.out.println("🔹 Acción: " + log.getAccion());
        if (log.getTurnoId() != null) {
            System.out.println("🔹 Turno ID: " + log.getTurnoId());
        }
        if (log.getClienteNombre() != null) {
            System.out.println("🔹 Cliente: " + log.getClienteNombre());
        }
        if (log.getEstado() != null) {
            System.out.println("🔹 Estado: " + log.getEstado());
        }
        System.out.println("🔹 Fecha: " + log.getFechaRegistro());
        System.out.println("🔹 Detalles: " + log.getDetalles());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}