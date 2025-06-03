package umg.edu.gt.progra3.turnos.service.estructuras;

import java.util.Stack;

public class PilaDeAcciones {
    private Stack<Runnable> acciones;
    private Stack<String> historialAcciones;

    public PilaDeAcciones() {
        this.acciones = new Stack<>();
        this.historialAcciones = new Stack<>();
    }

    public void apilar(Runnable accion) {
        acciones.push(accion);
    }

    public String deshacerUltima() {
        if (!acciones.isEmpty()) {
            Runnable accion = acciones.pop();
            accion.run();
            return !historialAcciones.isEmpty() ? historialAcciones.pop() : "Acción deshecha";
        }
        return "No hay acciones para deshacer";
    }

    public void registrarAccion(String descripcion) {
        historialAcciones.push(descripcion);
    }

    public String verUltima() {
        return !historialAcciones.isEmpty() ? historialAcciones.peek() : null;
    }
}