
package edd.proyecto1_fase2;


public class ListaCabeceraFila {
    NodoCabeceraFila primero;
    NodoCabeceraFila ultimo;

    public ListaCabeceraFila() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(NodoCabeceraFila nodoNuevo){
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

    private void insertarInicio(NodoCabeceraFila nodoNuevo){
        primero.setAnterior(nodoNuevo);
        nodoNuevo.setSiguiente(primero);
        primero = primero.getAnterior();
    }

    private void insertarMedio(NodoCabeceraFila nodoNuevo){
        NodoCabeceraFila tmp1 = null;
        NodoCabeceraFila tmp2 = null;
        tmp1 = primero;
        while(tmp1.getY() < nodoNuevo.getY()){
            tmp1 = tmp1.getSiguiente();
        }

        tmp2 = tmp1.getAnterior();
        tmp2.setSiguiente(nodoNuevo);
        nodoNuevo.setSiguiente(tmp1);
        nodoNuevo.setAnterior(tmp2);
        tmp1.setAnterior(nodoNuevo);
    }

    private void insertarFinal(NodoCabeceraFila nodoNuevo){

        ultimo.setSiguiente(nodoNuevo);
        nodoNuevo.setAnterior(ultimo);
        ultimo = nodoNuevo;
    }

    public void recorrer(){
        if(!vacia()) {
            NodoCabeceraFila tmp = primero;
            while (tmp != null) {
                System.out.println(" Cabecera Y: " + tmp.getY());
                tmp = tmp.getSiguiente();
            }
        }
    }

    NodoCabeceraFila busqueda (int y){
    if(!vacia()){
        NodoCabeceraFila tmp;
        tmp = primero;
        while(tmp != null){
            if(tmp.getY() == y){
                return tmp;
            }
            tmp = tmp.getSiguiente();
        }
    }
    return null;
}


}
