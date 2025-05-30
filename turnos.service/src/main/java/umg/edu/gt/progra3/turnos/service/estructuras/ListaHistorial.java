package umg.edu.gt.progra3.turnos.service.estructuras;

import umg.edu.gt.progra3.turnos.repository.model.Historial;

import java.util.ArrayList;
import java.util.List;

public class ListaHistorial {
    private List<Historial> historial = new ArrayList<>();

    public void agregarHistorial(Historial h) {
        historial.add(h);
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void imprimir() {
        for (Historial h : historial) {
            System.out.println("Atención a cliente: " + h.getCliente().getNombre() +
                    " en " + h.getFechaAtencion());
        }
    }
}
