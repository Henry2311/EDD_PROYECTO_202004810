
package edd.proyecto1_fase3;

public class EDDProyecto1_fase3 {

    static Lista CLIENTES = new Lista();
    static TablaHash MENSAJEROS = new TablaHash();
    static Lista LUGARES = new Lista();
    static String grafo = "";
    
    public static void main(String[] args) {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });*/
        
        Grafo graph = new Grafo(6);
        graph.addVertax("Guatemala");
        graph.addVertax("Peten");
        graph.addVertax("Zacapa");
        graph.addVertax("Escuintla");
        graph.addVertax("Alta Verapaz");
        graph.addVertax("Izabal");

        graph.addEdges(0,1,5);
        graph.addEdges(0,2,6);
        graph.addEdges(1,2,6);
        graph.addEdges(1,3,3);
        graph.addEdges(1,4,5);
        graph.addEdges(2,4,2);
        graph.addEdges(4,3,3);
        graph.addEdges(3,5,4);
        graph.addEdges(4,5,1);
        
        graph.showEdges();
        graph.dijkStra(0);
        
       
    }
    
    
    public static void AgregarCliente(Clientes c){
        CLIENTES.append(c);
    }
     
    public static void AgregarMensajero(Mensajero m){
        MENSAJEROS.add(m);
    }
    
    public static void AgregarLugar(Lugar l){
        LUGARES.append(l);
    }
    
    public static void AgregarRuta(int inicio, vecino v){
        Lista.Nodo aux = LUGARES.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == inicio){
                data.Rutas.append(v);
                grafo+="nodo"+inicio+" -> nodo"+v.id+"[label = \""+v.peso+"\" arrowhead = none];\n";
                break;
            }
            aux = aux.next;
        }
        aux = LUGARES.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == v.id){
                vecino v1 = new vecino(v.peso,inicio);
                data.Rutas.append(v1);
                break;
            }
            aux = aux.next;
        }
    
    }
    
    public static void mostrar_lugar(){
        Lista.Nodo aux = LUGARES.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            System.out.println("id: "+data.id+" Nombre: "+data.departamento);
            Lista.Nodo aux2 = data.Rutas.first;
            while(aux2!=null){
                vecino data2 = (vecino) aux2.data;
                System.out.println("id vecino: "+data2.id);
                aux2=aux2.next;
            }
            aux = aux.next;
        }
    
    
    }
}
