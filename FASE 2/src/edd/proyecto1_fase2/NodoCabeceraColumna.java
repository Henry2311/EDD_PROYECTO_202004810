
package edd.proyecto1_fase2;


public class NodoCabeceraColumna {
    int x;
    NodoCabeceraColumna siguiente;
    NodoCabeceraColumna anterior;
    ListaVertical columna;

    public NodoCabeceraColumna(int x) {
        this.x = x;
        this.siguiente = null;
        this.anterior = null;
        this.columna = new ListaVertical();
    }

    public NodoCabeceraColumna getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCabeceraColumna siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCabeceraColumna getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCabeceraColumna anterior) {
        this.anterior = anterior;
    }

    public ListaVertical getColumna() {
        return columna;
    }

    public void setColumna(ListaVertical columna) {
        this.columna = columna;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
