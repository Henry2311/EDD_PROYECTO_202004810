
package edd.proyecto1_fase3;

import java.io.FileWriter;
import java.io.PrintWriter;


public class Lista {
    Nodo first,last;
    private int size;
    
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
   
    public int getId_lugar(String nombre){
        int id = 0;
        Nodo aux = this.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.nombre.equals(nombre)){
                id = data.id;
                break;
            }
            aux = aux.next;
        }
        return id;
    }
    
    public void recorrido(String nombre){
        FileWriter reporte = null;
        PrintWriter pw = null;
        try{
            reporte = new FileWriter(nombre+"Recorrido.dot");
            pw = new PrintWriter(reporte);

            pw.println("digraph G {");
            pw.println("node [shape=\"circle\"]");
            pw.println("rankdir = \"LR\"");
            pw.println("label = \"Ruta optima\"");
            
            String datos = "";
            
            Nodo aux = this.first;
            int i = 0;
            while(aux!=null){
                String data = (String) aux.data;
                datos+="nodo"+i+"[label = \""+data+"\"];\n";
                i++;
                aux = aux.next;
            }
            
            aux = this.first;
            i = 0;
            while(aux.next!=null){
                datos+="nodo"+i+" -> nodo"+(i+1)+";\n";
                i++;
                aux = aux.next;
            }
            
            pw.println(datos);
            pw.println("}");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte){
                    reporte.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",nombre+"Recorrido.png",nombre+"Recorrido.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
            }catch(Exception e2){
            e2.printStackTrace();
            }
        }
    
    }
    
    
    public void graficar(){
    
        FileWriter reporte = null;
        PrintWriter pw = null;
        try{
            reporte = new FileWriter("TablaAdyacencia.dot");
            pw = new PrintWriter(reporte);

            pw.println("digraph G {");
            pw.println("node [shape=\"box\"]");
            pw.println("label = \"Matriz de Adyacencia\"");
            
            String datos = "";
            
            Nodo aux = this.first;
            while(aux!=null){
                Lugar data = (Lugar) aux.data;
                datos+="nodo"+data.id+"[label = \""+data.nombre+"\"];\n";
                aux = aux.next;
            }
            aux = this.first;
            while(aux.next!=null){
                Lugar data = (Lugar) aux.data;
                Lugar datanext = (Lugar) aux.next.data;
                datos+="nodo"+data.id+" -> nodo"+datanext.id+";\n";
                aux = aux.next;
            }
            
            aux = this.first;
            while(aux!=null){
                Lugar data = (Lugar) aux.data;
                Nodo aux2 = data.Rutas.first;
                while(aux2 != null){
                    vecino data2 = (vecino) aux2.data;
                    datos+="nodo"+data.id+data2.id+"[label = \""+this.getNombre(data2.id)+"\"];\n";
                    aux2 = aux2.next;
                }
                aux = aux.next;
            }
            
            aux = this.first;
            while(aux!=null){
                Lugar data = (Lugar) aux.data;
                Nodo aux2 = data.Rutas.first;
                
                vecino data2 = (vecino) aux2.data;
                datos+="rank = same{nodo"+data.id+" -> nodo"+data.id+data2.id+"};\n";
               
                while(aux2.next != null){
                    data2 = (vecino) aux2.data;
                    vecino data3 = (vecino) aux2.next.data;
                    datos+="rank = same{nodo"+data.id+data2.id+" -> nodo"+data.id+data3.id+"};\n";
                    aux2 = aux2.next;
                }
                aux = aux.next;
            }
            
            pw.println(datos);
            pw.println("}");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte){
                    reporte.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TablaAdyacencia.png","TablaAdyacencia.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
            }catch(Exception e2){
            e2.printStackTrace();
            }
        }
        System.out.println("Archivo creado");
    
    }
    
    public void grafo_nodirigido(){
        FileWriter reporte = null;
        PrintWriter pw = null;
        try{
            reporte = new FileWriter("GrafoNoDirigido.dot");
            pw = new PrintWriter(reporte);

            pw.println("digraph G {");
            pw.println("node [shape=\"circle\" width=1 fontsize=12]");
            pw.println("layout = neato");
            pw.println("edge [len=2.3 fontsize = 18]");
            pw.println("label = \"Grafo no dirigido\"");
            
            String datos = "";
            
            Nodo aux = this.first;
            while(aux!=null){
                Lugar data = (Lugar) aux.data;
                datos+="nodo"+data.id+"[label = \""+data.nombre+"\"];\n";
                aux = aux.next;
            }
            
            datos+="\n"+EDDProyecto1_fase3.grafo;
            
            pw.println(datos);
            pw.println("}");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte){
                    reporte.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","GrafoNoDirigido.png","GrafoNoDirigido.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
            }catch(Exception e2){
            e2.printStackTrace();
            }
        }
        System.out.println("Archivo creado");
    }
    
    public String getMunicipio(int id){
        String nombre="";
        
        Nodo aux = this.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == id){
                nombre = data.departamento;
                break;
            }
            aux = aux.next;
        }
        return nombre;
    }
    
    public String getNombre(int id){
        String nombre="";
        
        Nodo aux = this.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == id){
                nombre = data.nombre;
                break;
            }
            aux = aux.next;
        }
        return nombre;
    }
    
    public void sort(){
        Lista.Nodo aux = this.first; 
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = this.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    vecino x = (vecino) actual.data;
                    vecino y = (vecino) siguiente.data;
                    if (x.getPeso()<y.getPeso()) {
                        sw=true;
                        temp= actual.data;
                        actual.data = siguiente.data;
                        siguiente.data = temp;
                        actual = actual.next;
                        siguiente = siguiente.next;
                    }else{
                        actual = actual.next;
                        siguiente = siguiente.next;
                    }
                }
            }while(sw);
        }
    }
    
    
}
