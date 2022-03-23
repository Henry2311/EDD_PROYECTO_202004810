
package edd.proyecto1_fase2;

import java.util.Objects;


public class Arbol_B {

    
    int orden_arbol = 5;
    RamaB raiz;

    public class NodoB {
        Long id;
        Clientes c;
        NodoB siguiente;
        NodoB anterior;
        RamaB derecha;
        RamaB izquierda;

        public NodoB(Long id, Clientes c) {
            this.id = id;
            this.c = c;
            this.anterior = null;
            this.siguiente = null;
            this.derecha = null;
            this.izquierda = null;
        }
    }
    
    public class RamaB {

        boolean hoja;//identificar si es una hoja
        int contador;//identificar la cantidad de elementos que tiene la rama
        NodoB primero;

        public RamaB() {
            this.primero = null;
            this.hoja = true;
            this.contador = 0;
        }

        public void insertar(NodoB nuevo) {
            if (primero == null) {
                //primero en la lista
                primero = nuevo;
                contador++;
            } else {
                //recorrer e insertar
                NodoB aux = primero;
                while (aux != null) {
                    if (Objects.equals(aux.id, nuevo.id)) {//------------->ya existe en el arbol
                        System.out.println("El ID " + nuevo.id + " ya existe");
                        break;
                    } else {
                        if (aux.id > nuevo.id) {
                            if (aux == primero) {//------------->insertar al inicio
                                aux.anterior = nuevo;
                                nuevo.siguiente = aux;
                                //ramas del nodo
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;

                                primero = nuevo;
                                contador++;
                                break;
                            } else {//------------->insertar en medio;
                                nuevo.siguiente = aux;
                                //ramas del nodo
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;

                                nuevo.anterior = aux.anterior;
                                aux.anterior.siguiente = nuevo;
                                aux.anterior = nuevo;
                                contador++;
                                break;
                            }
                        } else if (aux.siguiente == null) {//------------->insertar al final
                            aux.siguiente = nuevo;
                            nuevo.anterior = aux;
                            contador++;
                            break;
                        }
                    }
                    aux = aux.siguiente;
                }

            }
    }

        public NodoB search(Long index) {
            NodoB aux =this.primero;
            while(aux.siguiente != null){
                if(Objects.equals(aux.id, index)){
                    return aux;
                }
                aux = aux.siguiente;
            }
            if(Objects.equals(aux.id, index)){
                return aux;
            }
            aux = this.primero;
            if(this.hoja){
                return null;
            }else{
                while(aux.siguiente != null){
                    NodoB aux2 = aux;
                    if(aux.izquierda != null){
                        aux = aux.izquierda.search(index);
                    }
                    if(aux!=null){
                        return aux;
                    }
                    aux = aux2;
                    if(aux.derecha != null){
                        aux = aux.derecha.search(index);
                    }
                    if(aux!=null){
                        return aux;
                    }
                    aux = aux2;
                    aux = aux.siguiente;
                }
                NodoB aux2 = aux;
                if(aux.izquierda != null){
                    aux = aux.izquierda.search(index);
                }
                if(aux!=null){
                    return aux;
                }
                aux = aux2;
                if(aux.derecha != null){
                    aux = aux.derecha.search(index);
                }
                if(aux!=null){
                    return aux;
                }
            }
            return null;
        }

    }
    
    public Arbol_B() {
        this.raiz = null;
    }

    public void insert(Long id, Clientes C) {
        NodoB nodo = new NodoB(id,C);
        if (raiz == null) {
            raiz = new RamaB();
            raiz.insertar(nodo);
        } else {
            NodoB obj = insertar_en_rama(nodo, raiz);
            if (obj != null) {
                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
                raiz = new RamaB();
                raiz.insertar(obj);
                raiz.hoja = false;
            }
        }
    }

    public NodoB insertar_en_rama(NodoB nodo, RamaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == orden_arbol) {
                //si ya se insertaron todos los elementos posibles se debe dividir la rama
                return dividir(rama);
            } else {
                return null;
            }
        } else {
            NodoB temp = rama.primero;
            do {
                if (Objects.equals(nodo.id, temp.id)) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_rama(nodo, temp.izquierda);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_rama(nodo, temp.derecha);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    public NodoB dividir(RamaB rama) {
        Long val = new Long(-999);
        Clientes c=null;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) {
                temp = new NodoB(aux.id, aux.c);
                temp.izquierda = aux.izquierda;
                if (cont == 2) {
                    temp.derecha = aux.siguiente.izquierda;
                } else {
                    temp.derecha = aux.derecha;
                }
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rizquierda.hoja = false;
                }

                rizquierda.insertar(temp);

            } else if (cont == 3) {
                val = aux.id;
                c = aux.c;
            } else {
                temp = new NodoB(aux.id, aux.c);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val,c);
        Nuevito.derecha = rderecha;
        Nuevito.izquierda = rizquierda;
        return Nuevito;
    }
    
    public NodoB Search(Long id){
        RamaB root = this.raiz;
        NodoB aux = root.search(id);
        return aux;
    }
    
    
}
