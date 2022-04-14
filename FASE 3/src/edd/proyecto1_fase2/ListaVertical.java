
package edd.proyecto1_fase2;

public class ListaVertical {
    NodoOrtogonal primero;
    NodoOrtogonal ultimo;

    public ListaVertical() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(NodoOrtogonal nodoNuevo){
        if(vacia()){
            primero = ultimo = nodoNuevo;
        }else{
            if(nodoNuevo.getY() < primero.getY()){
                //inserta inicio
                insertarInicio(nodoNuevo);
            }else if (nodoNuevo.getY() > ultimo.getY()){
                //inserta al final
                insertarFinal(nodoNuevo);
            }else{
                //inserta en medio
                insertarMedio(nodoNuevo);
            }
        }
    }

    private boolean vacia(){
        return primero == null;
    }

    private void insertarInicio(NodoOrtogonal nodoNuevo){
        primero.setArriba(nodoNuevo);
        nodoNuevo.setAbajo(primero);
        primero = primero.getArriba();
    }

    private void insertarMedio(NodoOrtogonal nodoNuevo){
        NodoOrtogonal tmp1 = null;
        NodoOrtogonal tmp2 = null;
        tmp1 = primero;
        while(tmp1.getY() < nodoNuevo.getY()){
            tmp1 = tmp1.getAbajo();
        }

        tmp2 = tmp1.getArriba();
        tmp2.setAbajo(nodoNuevo);
        nodoNuevo.setAbajo(tmp1);
        nodoNuevo.setArriba(tmp2);
        tmp1.setArriba(nodoNuevo);
    }

    private void insertarFinal(NodoOrtogonal nodoNuevo){

        ultimo.setAbajo(nodoNuevo);
        nodoNuevo.setArriba(ultimo);
        ultimo = nodoNuevo;
    }

    public void recorrer(){
        if(!vacia()) {
            NodoOrtogonal tmp = primero;
            while (tmp != null) {
                System.out.println("dato: " + tmp.getDato() + " posicion (x,y): " + tmp.getX()  +  "," + tmp.getY());
                tmp = tmp.getAbajo();
            }
        }
    }

}
