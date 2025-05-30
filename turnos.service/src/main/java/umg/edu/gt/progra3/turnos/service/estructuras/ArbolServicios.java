package umg.edu.gt.progra3.turnos.service.estructuras;

public class ArbolServicios {
    private NodoServicio raiz;

    public ArbolServicios(String nombreRaiz) {
        this.raiz = new NodoServicio(nombreRaiz);
    }

    public NodoServicio getRaiz() {
        return raiz;
    }

    public void recorrer(NodoServicio nodo, int nivel) {
        System.out.println(" ".repeat(nivel * 2) + "- " + nodo.getNombre());
        for (NodoServicio hijo : nodo.getSubservicios()) {
            recorrer(hijo, nivel + 1);
        }
    }
}
