package umg.edu.gt.progra3.turnos.service.servicio;

import org.springframework.stereotype.Service;
import umg.edu.gt.progra3.turnos.repository.model.Historial;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
import umg.edu.gt.progra3.turnos.service.estructuras.ColaDeTurnos;
import umg.edu.gt.progra3.turnos.service.estructuras.ListaHistorial;
import umg.edu.gt.progra3.turnos.service.estructuras.PilaDeAcciones;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class GestorDeTurnos {
    private ColaDeTurnos colaDeTurnos = new ColaDeTurnos();
    private ListaHistorial historial = new ListaHistorial();
    private PilaDeAcciones pilaDeAcciones = new PilaDeAcciones();

    public void solicitarTurno(Turno turno) {
        colaDeTurnos.agregarTurno(turno);
        pilaDeAcciones.registrarAccion("Solicitado turno: " + turno.getId());
    }

    public Turno atenderTurno() {
        Turno turno = colaDeTurnos.atenderSiguiente();
        if (turno != null) {
            Historial h = new Historial();
            h.setCliente(turno.getCliente());
            h.setTurno(turno);
            h.setFechaAtencion(LocalDateTime.now());
            historial.agregarHistorial(h);
            pilaDeAcciones.registrarAccion("Atendido turno: " + turno.getId());
        }
        return turno;
    }

    public String deshacer() {
        return pilaDeAcciones.deshacerUltima();
    }
    public boolean cancelarTurno(Long id) {
        Queue<Turno> colaOriginal = colaDeTurnos.obtenerCola();
        Queue<Turno> colaTemporal = new LinkedList<>();

        boolean eliminado = false;

        while (!colaOriginal.isEmpty()) {
            Turno actual = colaOriginal.poll();
            if (actual.getId().equals(id)) {
                eliminado = true;
                System.out.println("❌ Turno con ID " + id + " cancelado.");
                pilaDeAcciones.registrarAccion("Cancelado turno: " + id);
            } else {
                colaTemporal.offer(actual);
            }
        }

        colaDeTurnos.setCola(colaTemporal);

        return eliminado;
    }
}
