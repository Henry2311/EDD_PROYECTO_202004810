
package edd.proyecto1_fase1;


public class print {
    
    String tipo;
    Cliente c;
    int pasos;
    
    public print(String tipo, Cliente c,int pasos) {
        this.tipo = tipo;
        this.c = c;
        this.pasos = pasos;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
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
