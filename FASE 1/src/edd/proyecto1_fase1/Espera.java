
package edd.proyecto1_fase1;


public class Espera {
    
Nodo first,last;
    
    public class Nodo{
        public Lista lista;
        public Cliente cliente;
        public Nodo next = null;
        
        public Nodo(Lista lista, Cliente cliente){
            this.lista = lista;
            this.cliente = cliente;
        }
    }
    
    public void append(Lista lista, Cliente cliente){
        Nodo newnuevo = new Nodo(lista,cliente);
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
    }
    
    public void delete(String id){
    
        if(first!=null){
            if(first==last && first.cliente.id.equals(id)){
                first = last = null;
            }else if(first.cliente.id.equals(id)){
                first = first.next;
            }else{
                Nodo anterior, aux;
                anterior = first;
                aux = first.next;
                while(aux!=null && !aux.cliente.id.equals(id)){
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
