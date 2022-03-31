
package edd.proyecto1_fase2;

public class ListaCabeceraColumna{
    NodoCabeceraColumna primero;
    NodoCabeceraColumna ultimo;

    public ListaCabeceraColumna() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(NodoCabeceraColumna nodoNuevo){
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

    private void insertarInicio(NodoCabeceraColumna nodoNuevo){
        primero.setAnterior(nodoNuevo);
        nodoNuevo.setSiguiente(primero);
        primero = primero.getAnterior();
    }

    private void insertarMedio(NodoCabeceraColumna nodoNuevo){
        NodoCabeceraColumna tmp1 = null;
        NodoCabeceraColumna tmp2 = null;
        tmp1 = primero;
        while(tmp1.getX() < nodoNuevo.getX()){
            tmp1 = tmp1.getSiguiente();
        }

        tmp2 = tmp1.getAnterior();
        tmp2.setSiguiente(nodoNuevo);
        nodoNuevo.setSiguiente(tmp1);
        nodoNuevo.setAnterior(tmp2);
        tmp1.setAnterior(nodoNuevo);
    }

    private void insertarFinal(NodoCabeceraColumna nodoNuevo){

        ultimo.setSiguiente(nodoNuevo);
        nodoNuevo.setAnterior(ultimo);
        ultimo = nodoNuevo;
    }

    public void recorrer(){
        if(!vacia()) {
            NodoCabeceraColumna tmp = primero;
            while (tmp != null) {
                System.out.println(" Cabecera x: " + tmp.getX());
                tmp = tmp.getSiguiente();
            }
        }
    }

    NodoCabeceraColumna busqueda (int x){
        if(!vacia()){
            NodoCabeceraColumna tmp;
            tmp = primero;
            while(tmp != null){
                if(tmp.getX() == x){
                    return tmp;
                }
                tmp = tmp.getSiguiente();
            }
        }
        return null;
    }

}
