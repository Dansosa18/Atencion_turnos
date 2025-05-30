package umg.edu.gt.progra3.turnos.service.estructuras;

import umg.edu.gt.progra3.turnos.repository.model.Turno;

import java.util.LinkedList;
import java.util.Queue;

public class ColaDeTurnos {
    private Queue<Turno> cola = new LinkedList<>();

    public void agregarTurno(Turno turno) {
        cola.offer(turno);
    }

    public Turno atenderSiguiente() {
        return cola.poll();
    }

    public Turno verSiguiente() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int tamaño() {
        return cola.size();
    }
    public Queue<Turno> obtenerCola() {
        return cola;
    }

    public void setCola(Queue<Turno> cola) {
        this.cola = cola;
    }
}
