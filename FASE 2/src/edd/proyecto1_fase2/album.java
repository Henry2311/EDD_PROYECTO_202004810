
package edd.proyecto1_fase2;

public class album {

    String nombre;
    Lista imagenes;

    public album(String nombre, Lista imagenes) {
        this.nombre = nombre;
        this.imagenes = imagenes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista getImagenes() {
        return imagenes;
    }

    public void setImagenes(Lista imagenes) {
        this.imagenes = imagenes;
    }
    

    
}
