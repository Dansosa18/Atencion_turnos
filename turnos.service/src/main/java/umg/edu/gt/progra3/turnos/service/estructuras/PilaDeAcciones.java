package umg.edu.gt.progra3.turnos.service.estructuras;

import java.util.Stack;

public class PilaDeAcciones {
    private Stack<String> acciones = new Stack<>();

    public void registrarAccion(String accion) {
        acciones.push(accion);
    }

    public String deshacerUltima() {
        return acciones.isEmpty() ? null : acciones.pop();
    }

    public String verUltima() {
        return acciones.isEmpty() ? null : acciones.peek();
    }

    public boolean estaVacia() {
        return acciones.isEmpty();
    }
}
