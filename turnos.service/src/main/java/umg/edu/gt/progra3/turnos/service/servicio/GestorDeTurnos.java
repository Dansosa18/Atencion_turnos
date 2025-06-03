package umg.edu.gt.progra3.turnos.service.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.gt.progra3.turnos.repository.model.Cliente;
import umg.edu.gt.progra3.turnos.repository.model.Historial;
import umg.edu.gt.progra3.turnos.repository.model.Servicio;
import umg.edu.gt.progra3.turnos.repository.model.Turno;
import umg.edu.gt.progra3.turnos.repository.repositorys.ClienteRepository;
import umg.edu.gt.progra3.turnos.repository.repositorys.ServicioRepository;
import umg.edu.gt.progra3.turnos.repository.repositorys.TurnoRepository;
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

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    private LogService logService;

    public void solicitarTurno(Turno turno) {

        Cliente cliente = clienteRepository.save(turno.getCliente());
        turno.setCliente(cliente);


        Servicio servicio = servicioRepository.save(turno.getServicio());
        turno.setServicio(servicio);

        turno.setEstado("pendiente");
        turno.setFechaCreacion(LocalDateTime.now());

        Turno turnoGuardado = turnoRepository.save(turno);

        colaDeTurnos.encolar(turnoGuardado);
        pilaDeAcciones.apilar(() -> cancelarTurno(turnoGuardado.getId()));
        logService.registrarLog("Solicitado turno", turnoGuardado, "Solicitado turno con ID: " + turnoGuardado.getId());
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

            // Imprimir en consola la información detallada
            System.out.println("\n━━━━━━━━━━ ATENCIÓN DE TURNO ━━━━━━━━━━");
            System.out.println("\n🔔 ATENDIENDO TURNO:");
            System.out.println("   📋 ID: " + turno.getId());
            System.out.println("   👤 Cliente: " + turno.getCliente().getNombre());
            System.out.println("   🕒 Fecha Creación: " + turno.getFechaCreacion());
            System.out.println("   🕐 Fecha Atención: " + h.getFechaAtencion());
            System.out.println("   📌 Estado: ATENDIDO");
            if (turno.getServicio() != null) {
                System.out.println("   🛠️ Servicio: " + turno.getServicio().getNombre());
            }
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        } else {
            System.out.println("\n⚠️ No hay turnos pendientes para atender\n");
        }
        logService.registrarLog("Atendido turno", turno, "Atendido turno con ID: " + turno.getId());
        return turno;
    }

    public String deshacer() {
        return pilaDeAcciones.deshacerUltima();
    }
    public boolean cancelarTurno(Long id) {
        System.out.println("\n━━━━━━━━━━ CANCELACIÓN DE TURNO ━━━━━━━━━━");

        Queue<Turno> colaOriginal = colaDeTurnos.obtenerCola();
        Queue<Turno> colaTemporal = new LinkedList<>();
        boolean eliminado = false;
        Turno turnoCancelado = null;

        while (!colaOriginal.isEmpty()) {
            Turno actual = colaOriginal.poll();
            if (actual.getId().equals(id)) {
                eliminado = true;
                turnoCancelado = actual;
                pilaDeAcciones.registrarAccion("Cancelado turno: " + id);
            } else {
                colaTemporal.offer(actual);
            }
        }

        if (eliminado && turnoCancelado != null) {
            System.out.println("\n🚫 TURNO CANCELADO:");
            System.out.println("   📋 ID: " + turnoCancelado.getId());
            System.out.println("   👤 Cliente: " + turnoCancelado.getCliente().getNombre());
            System.out.println("   🕒 Fecha Creación: " + turnoCancelado.getFechaCreacion());
            if (turnoCancelado.getServicio() != null) {
                System.out.println("   🛠️ Servicio: " + turnoCancelado.getServicio().getNombre());
            }
            System.out.println("   ⏱️ Estado: CANCELADO");
        } else {
            System.out.println("\n⚠️ No se encontró el turno con ID: " + id);
        }

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        colaDeTurnos.setCola(colaTemporal);
        logService.registrarLog("Cancelado turno", turnoCancelado, "Cancelado turno con ID: " + id);
        return eliminado;
    }


    public Turno verSiguienteTurno() {
        Turno siguiente = colaDeTurnos.verSiguiente();

        // Línea decorativa
        System.out.println("\n━━━━━━━━━━ ESTADO DEL SISTEMA DE TURNOS ━━━━━━━━━━");

        // Información del siguiente turno
        if (siguiente != null) {
            System.out.println("\n🎫 PRÓXIMO TURNO A ATENDER:");
            System.out.println("   📋 ID: " + siguiente.getId());
            System.out.println("   👤 Cliente: " + siguiente.getCliente().getNombre());
            System.out.println("   🕒 Fecha: " + siguiente.getFechaCreacion());
            System.out.println("   📌 Estado: " + siguiente.getEstado());
            if (siguiente.getServicio() != null) {
                System.out.println("   🛠️ Servicio: " + siguiente.getServicio().getNombre());
            }
        } else {
            System.out.println("\n⚠️ No hay turnos en espera");
        }

        // Mostrar historial de atenciones
        System.out.println("\n📚 HISTORIAL DE ATENCIONES RECIENTES:");
        historial.imprimir();

        // Información de acciones
        System.out.println("\n🔄 ÚLTIMA ACCIÓN REGISTRADA:");
        String ultimaAccion = pilaDeAcciones.verUltima();
        System.out.println("   " + (ultimaAccion != null ? ultimaAccion : "No hay acciones registradas"));

        // Línea decorativa final
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        return siguiente;
    }




}
