
package edd.proyecto1_fase3;


public class Lista {
    Nodo first,last;
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
        last = null;
        size = 0;
    }
    
    public void append(Object data){
        Nodo newnuevo = new Nodo(data);
        if(first == null){
            first = newnuevo;
            last = first;
        }
        else{
            Nodo temp = first;
            while(temp.next != null){
                temp=temp.next;
            }
            temp.next = newnuevo;
            last = temp.next;
        }
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public Clientes search(String id){
        Nodo aux = first;
        
        while(aux!=null){
            Clientes c = (Clientes) aux.data;
            if(c.getUser().equals(id)){
                return c;
            }
            
            aux = aux.next;
        }
        
        return null;
    }
    
    public void delete(String id){
    
        if(first!=null){
            if(first==last && first.data.equals(id)){
                first = last = null;
            }else if(first.data.equals(id)){
                first = first.next;
            }else{
                Nodo anterior, aux;
                anterior = first;
                aux = first.next;
                while(aux!=null && !first.data.equals(id)){
                    anterior = anterior.next;
                    aux = aux.next;
                }
                if(aux !=null){
                    anterior.next = aux.next;
                    if(aux == last){
                        last = anterior;
                    }
                }
            }
        }
    }

}
