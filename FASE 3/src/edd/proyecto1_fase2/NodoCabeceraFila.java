
package edd.proyecto1_fase2;

public class NodoCabeceraFila {
    int y;
    NodoCabeceraFila siguiente;
    NodoCabeceraFila anterior;
    ListaHorizontal fila;

    public NodoCabeceraFila(int y) {
        this.y = y;
        this.siguiente = null;
        this.anterior = null;
        this.fila = new ListaHorizontal();
    }

    public NodoCabeceraFila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCabeceraFila siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCabeceraFila getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCabeceraFila antertior) {
        this.anterior = antertior;
    }

    public ListaHorizontal getFila() {
        return fila;
    }

    public void setFila(ListaHorizontal fila) {
        this.fila = fila;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}