
package edd.proyecto1_fase3;

public class EDDProyecto1_fase3 {

    static Lista CLIENTES = new Lista();
    static TablaHash MENSAJEROS = new TablaHash();
    static Lista LUGARES = new Lista();
    static String grafo = "";
    static Lista RUTA = new Lista();
    static Lista VIAJES = new Lista();
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
    public static void AgregarViaje(viajes v){
        VIAJES.append(v);
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
                RUTA.append((inicio-1)+","+(v.id-1)+","+v.peso);
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
