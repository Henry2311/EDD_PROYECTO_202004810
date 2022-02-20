
package edd.proyecto1_fase1;


public class Atendidos {
    
    String cliente, ventanilla, n_img, n_imgc, n_pasos,id;

    public Atendidos(String cliente, String ventanilla, String n_img,String n_imgc, String n_pasos,String id) {
        this.cliente = cliente;
        this.ventanilla = ventanilla;
        this.n_img = n_img;
        this.n_pasos = n_pasos;
        this.n_imgc = n_imgc;
        this.id = id;
    }

    public String getN_imgc() {
        return n_imgc;
    }

    public void setN_imgc(String n_imgc) {
        this.n_imgc = n_imgc;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(String ventanilla) {
        this.ventanilla = ventanilla;
    }

    public String getN_img() {
        return n_img;
    }

    public void setN_img(String n_img) {
        this.n_img = n_img;
    }

    public String getN_pasos() {
        return n_pasos;
    }

    public void setN_pasos(String n_pasos) {
        this.n_pasos = n_pasos;
    }
    
    
    
}
