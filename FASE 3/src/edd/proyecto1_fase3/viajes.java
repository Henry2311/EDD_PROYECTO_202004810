
package edd.proyecto1_fase3;

public class viajes {
    
    Lista ruta;
    double tiempo;
    String nombre;
    
    public viajes(Lista ruta, double tiempo, String nombre) {
        this.ruta = ruta;
        this.tiempo = tiempo;
        this.nombre = nombre;
    }

    public Lista getRuta() {
        return ruta;
    }

    public void setRuta(Lista ruta) {
        this.ruta = ruta;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
