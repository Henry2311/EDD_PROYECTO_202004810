
package edd.proyecto1_fase2;


public class NodoOrtogonal {
    String dato;
    int x, y;
    NodoOrtogonal arriba;
    NodoOrtogonal abajo;
    NodoOrtogonal izquierda;
    NodoOrtogonal derecha;

    public NodoOrtogonal(String dato, int x, int y) {
        this.dato = dato;
        this.x = x;
        this.y = y;
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getDato() {
        return dato;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public NodoOrtogonal getArriba() {
        return arriba;
    }

    public void setArriba(NodoOrtogonal arriba) {
        this.arriba = arriba;
    }

    public NodoOrtogonal getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoOrtogonal abajo) {
        this.abajo = abajo;
    }

    public NodoOrtogonal getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoOrtogonal izquierda) {
        this.izquierda = izquierda;
    }

    public NodoOrtogonal getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoOrtogonal derecha) {
        this.derecha = derecha;
    }
}
