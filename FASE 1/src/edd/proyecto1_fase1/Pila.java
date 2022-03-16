
package edd.proyecto1_fase1;

public class Pila {
    Nodo first;
    
    public class Nodo{
        public Object data;
        public Nodo next = null;
        
        public Nodo(Object data){
            this.data = data;
        }
    }
    
    public void push(Object data){
        
        Nodo newnodo = new Nodo(data);
        newnodo.next = first;
        first = newnodo;
    }
    
    public void peek(){
       
        if(first == null){
            System.out.println("No existen elementos");
        }else{
            Nodo temp = first;
            System.out.println("Pais: "+temp.data+" , Capital: "+temp.data);
        }
    }
    
    
    public void pop(){
        
        if(first == null){
            System.out.println("No existen elementos");
        }else{
            first = first.next;
        }
    }
       
    
    
}

