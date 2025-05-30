package umg.edu.gt.progra3.turnos.service.estructuras;

import java.util.ArrayList;
import java.util.List;

public class NodoServicio {
    private String nombre;
    private List<NodoServicio> subservicios = new ArrayList<>();

    public NodoServicio(String nombre) {
        this.nombre = nombre;
    }

    public void agregarSubservicio(NodoServicio nodo) {
        subservicios.add(nodo);
    }

    public List<NodoServicio> getSubservicios() {
        return subservicios;
    }

    public String getNombre() {
        return nombre;
    }
}
