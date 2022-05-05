
package edd.proyecto1_fase3;


public class Clientes {
    
    Long dpi;
    int id_municipio,pedidos;
    String name, password,user,correo,telefono,direccion;

    public Clientes(Long dpi, int id_municipio, String name, String password, String user, String correo, String telefono, String direccion) {
        this.dpi = dpi;
        this.id_municipio = id_municipio;
        this.name = name;
        this.password = password;
        this.user = user;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pedidos = 0;
    }

    public Long getDpi() {
        return dpi;
    }

    public void addPedido(int i){
        this.pedidos += i;
    }
    
    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
