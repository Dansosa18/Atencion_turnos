package umg.edu.gt.progra3.turnos.service.simulacion;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umg.edu.gt.progra3.turnos.repository.model.Cliente;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
import umg.edu.gt.progra3.turnos.service.servicio.GestorDeTurnos;

import java.time.LocalDateTime;
@Component
public class Simulador {

    @Autowired
    private GestorDeTurnos gestor;

    @PostConstruct
    public void simular() {
        System.out.println("🚀 Iniciando simulación...");

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");

        Turno turno = new Turno();
        turno.setCliente(cliente);
        turno.setEstado("pendiente");
        turno.setFechaCreacion(LocalDateTime.now());

        gestor.solicitarTurno(turno);
        gestor.atenderTurno();

        System.out.println("✅ Simulación completada.");
    }
}

