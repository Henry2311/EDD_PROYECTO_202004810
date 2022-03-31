
package edd.proyecto1_fase2;


public class ListaHorizontal {
    NodoOrtogonal primero;
    NodoOrtogonal ultimo;

    public ListaHorizontal() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(NodoOrtogonal nodoNuevo){
        if(vacia()){
            primero = ultimo = nodoNuevo;
        }else{
            if(nodoNuevo.getX() < primero.getX()){
                //inserta inicio
                insertarInicio(nodoNuevo);
            }else if (nodoNuevo.getX() > ultimo.getX()){
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
        primero.setIzquierda(nodoNuevo);
        nodoNuevo.setDerecha(primero);
        primero = primero.getIzquierda();
    }

    private void insertarMedio(NodoOrtogonal nodoNuevo){
        NodoOrtogonal tmp1 = null;
        NodoOrtogonal tmp2 = null;
        tmp1 = primero;
        while(tmp1.getX() < nodoNuevo.getX()){
            tmp1 = tmp1.getDerecha();
        }

        tmp2 = tmp1.getIzquierda();
        tmp2.setDerecha(nodoNuevo);
        nodoNuevo.setDerecha(tmp1);
        nodoNuevo.setIzquierda(tmp2);
        tmp1.setIzquierda(nodoNuevo);
    }

    private void insertarFinal(NodoOrtogonal nodoNuevo){

        ultimo.setDerecha(nodoNuevo);
        nodoNuevo.setIzquierda(ultimo);
        ultimo = nodoNuevo;
    }

    public void recorrer(){
        if(!vacia()) {
            NodoOrtogonal tmp = primero;
            while (tmp != null) {
                System.out.println("dato: " + tmp.getDato() + " posicion (x,y): " + tmp.getX()  +  "," + tmp.getY());
                tmp = tmp.getDerecha();
            }
        }
    }

}
