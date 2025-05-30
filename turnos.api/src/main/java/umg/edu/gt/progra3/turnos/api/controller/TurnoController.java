package umg.edu.gt.progra3.turnos.api.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
import umg.edu.gt.progra3.turnos.service.servicio.GestorDeTurnos;

@RestController
@RequestMapping("/turno")
@ControllerAdvice
public class TurnoController {

    @Autowired
    private GestorDeTurnos gestor;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<String> crearTurno(@RequestBody Turno turno) {
        try {
            gestor.solicitarTurno(turno);
            rabbitTemplate.convertAndSend("turnos.exchange", "turno.nuevo", turno);
            return ResponseEntity.ok("✅ Turno creado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el turno: " + e.getMessage());
        }
    }

    @GetMapping("/siguiente")
    public ResponseEntity<Turno> atenderTurno() {
        try {
            Turno atendido = gestor.atenderTurno();
            if (atendido != null) {
                return ResponseEntity.ok(atendido);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarTurno(@PathVariable Long id) {
        try {
            boolean cancelado = gestor.cancelarTurno(id);
            if (cancelado) {
                rabbitTemplate.convertAndSend("turnos.exchange", "turno.cancelado", id);
                return ResponseEntity.ok("❌ Turno cancelado.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Turno no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cancelar el turno: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcion(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error en el servicio: " + e.getMessage());
    }
}