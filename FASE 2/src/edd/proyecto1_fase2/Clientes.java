
package edd.proyecto1_fase2;

public class Clientes {
   
    long dpi;
    String name, password;
    Arbol_AVL avl;
    Arbol_B arbB;
    Lista album;
    public Clientes(long dpi, String name, String password) {
        this.dpi = dpi;
        this.name = name;
        this.password = password;
    }

    public long getDpi() {
        return dpi;
    }

    public void setDpi(long dpi) {
        this.dpi = dpi;
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

    public Arbol_AVL getAvl() {
        return avl;
    }

    public void setAvl(Arbol_AVL avl) {
        this.avl = avl;
    }

    public Arbol_B getArbB() {
        return arbB;
    }

    public void setArbB(Arbol_B arbB) {
        this.arbB = arbB;
    }

    public Lista getAlbum() {
        return album;
    }

    public void setAlbum(Lista album) {
        this.album = album;
    }
    
    
    
}
