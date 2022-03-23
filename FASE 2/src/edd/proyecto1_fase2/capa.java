
package edd.proyecto1_fase2;


public class capa {
    
    int id,x,y;
    Matriz pixeles;

    public capa(int id, Matriz pixeles,int x, int dimensiony) {
        this.id = id;
        this.pixeles = pixeles;
        this.x = x;
        this.y = dimensiony;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matriz getPixeles() {
        return pixeles;
    }

    public void setPixeles(Matriz pixeles) {
        this.pixeles = pixeles;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
