
package edd.proyecto1_fase2;

public class Lista {
    Nodo first;
    int size;
    
    public class Nodo{
        public Object data;
        public Nodo next = null;
        
        
        public Nodo(Object data){
            this.data = data;
        }
    }
    
    public Lista(){
        first = null;
        size = 0;
    }
    
    public void append(Object data){
        Nodo newnuevo = new Nodo(data);
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
        size++;
    }
    
    public int size(){
        return size;
    }
}
