
package edd.proyecto1_fase1;


public class ventanilla {
    
    Nodo first;
    
    public class Nodo{
        public Pila pila;
        public int id;
        public Nodo next = null;
        public Cliente clt = null;
        
        public Nodo(Pila pila, int id){
            this.pila = pila;
            this.id = id;
        }
    }
    
    public void append(Pila pila, int id){
        Nodo newnuevo = new Nodo(pila,id);
        if(first == null){
            first = newnuevo;
        }
        else{
            Nodo temp = first;
            while(temp.next != null){
                temp=temp.next;
            }
            temp.next = newnuevo;
        }
    }
    
    
}
