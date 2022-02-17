
package edd.proyecto1_fase1;


public class print {
    
    String tipo;
    Cliente c;

    public print(String tipo, Cliente c) {
        this.tipo = tipo;
        this.c = c;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }
    
    
}
