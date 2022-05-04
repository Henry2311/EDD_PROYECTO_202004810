
package edd.proyecto1_fase3;


public class vecino {

    int peso,id;
    boolean visitado;
    vecino anterior;
    Lista ady;
    
    public vecino(int peso, int id) {
        this.peso = peso;
        this.id = id;
        this.visitado = false;
        this.anterior = null;
    }
    
    public vecino(int peso, int id,Lista ady) {
        this.peso = peso;
        this.id = id;
        this.visitado = false;
        this.anterior = null;
        this.ady = ady;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
