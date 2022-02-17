
package edd.proyecto1_fase1;


public class Espera {
    
 private Nodo first;
    
    public class Nodo{
        public Lista lista;
        public Object cliente;
        public Nodo next = null;
        
        public Nodo(Lista lista, Object cliente){
            this.lista = lista;
            this.cliente = cliente;
        }
    }
    
    public void append(Lista lista, Object cliente){
        Nodo newnuevo = new Nodo(lista,cliente);
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
    
    public void delete(Object id){
    
        Nodo aux = first;
        Nodo preview = null;
        
            while(aux!=null){
                if(aux.cliente == id){
                    if(aux == first){
                        first = first.next;
                    }else  if(aux.next==null){
                        first = null;
                    }else{
                        preview.next = aux.next;
                    }
                }
                preview = aux;
                aux = aux.next;
            }
                    
    
    }
    
    public void show(){
        if(first == null){
            System.err.print("No hay datos en la lista");
        }
        else{
            Nodo aux = first;
            int i = 1;
            while(aux != null){
                System.out.println("Pila No. "+i);
                aux.lista.show();
                aux = aux.next;
                i++;
            }
        }
    }
    
    
}
