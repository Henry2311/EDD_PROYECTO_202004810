
package edd.proyecto1_fase3;

public class viajes {
    
    Lista ruta;
    int tiempo;

    public viajes(Lista ruta, int tiempo) {
        this.ruta = ruta;
        this.tiempo = tiempo;
    }

    public Lista getRuta() {
        return ruta;
    }

    public void setRuta(Lista ruta) {
        this.ruta = ruta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
