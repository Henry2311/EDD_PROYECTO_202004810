
package edd.proyecto1_fase3;

public class Mensajero {
    Long dpi;
    String nombre,apellido,licencia,genero,telefono,direccion;
    int pedidos;
    
    public Mensajero(Long dpi, String nombre, String apellido, String licencia, String genero, String telefono, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pedidos = 0;
    }

    public int getPedidos() {
        return pedidos;
    }

    public void setPedidos(int pedidos) {
        this.pedidos+= pedidos;
    }

    public Long getDpi() {
        return dpi;
    }

    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
