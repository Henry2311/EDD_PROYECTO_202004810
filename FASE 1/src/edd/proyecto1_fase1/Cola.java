
package edd.proyecto1_fase1;

public class Cola {
    
    Nodo first;
   
    public class Nodo{
        public Object data;
        public Nodo next = null;
        
        public Nodo(Object data){
            this.data = data;
        }
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
    }
    
    public void remove(){
        if(first == null){
            System.out.println("No existen elementos");
        }else{
            first = first.next;
        }
    }
   
    
}
