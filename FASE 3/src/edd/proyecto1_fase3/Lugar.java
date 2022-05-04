
package edd.proyecto1_fase3;


public class Lugar {
    int id;
    String departamento, nombre,sucursal;
    Lista Rutas ;
    boolean visitado;

    public Lugar(int id, String departamento, String nombre, String sucursal) {
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.Rutas = new Lista();
        this.visitado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Lista getRutas() {
        return Rutas;
    }

    public void setRutas(Lista Rutas) {
        this.Rutas = Rutas;
    }
    
    
    
    
    
}
