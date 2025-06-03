package umg.edu.gt.progra3.turnos.service.estructuras;

import umg.edu.gt.progra3.turnos.repository.model.Turno;
import java.util.LinkedList;
import java.util.Queue;

public class ColaDeTurnos {
    private Queue<Turno> cola;

    public ColaDeTurnos() {
        this.cola = new LinkedList<>();
    }

    public void encolar(Turno turno) {
        cola.offer(turno);
    }

    public Queue<Turno> obtenerCola() {
        return cola;
    }

    public void setCola(Queue<Turno> cola) {
        this.cola = cola;
    }

    public Turno atenderSiguiente() {
        return cola.poll();
    }

    public Turno verSiguiente() {
        return cola.peek();
    }
}