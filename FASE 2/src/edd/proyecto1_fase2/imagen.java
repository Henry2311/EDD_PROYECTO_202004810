
package edd.proyecto1_fase2;

public class imagen {
    
    int id;
    String ruta;
    Arbol_ABB arb;

    public imagen(int id, String ruta, Arbol_ABB arb) {
        this.id = id;
        this.ruta = ruta;
        this.arb = arb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Arbol_ABB getArb() {
        return arb;
    }

    public void setArb(Arbol_ABB arb) {
        this.arb = arb;
    }
    
    
}
