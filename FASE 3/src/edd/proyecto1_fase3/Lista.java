
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
    
    
    public void Tabla_Clientes(){
        
        FileWriter reporte = null;
        PrintWriter pw = null;
        try{
            reporte = new FileWriter("TablaClientes.dot");
            pw = new PrintWriter(reporte);

            String datos = "";
            
            pw.println("digraph G {");
            pw.println("node [shape=\"box\"]");
            pw.println("label = \"Tabla Clientes\"");
            pw.println("a0 [label=< \n <TABLE>");
            datos += "<TR> "
                         + "<TD>DPI</TD><TD>NOMBRE</TD><TD>USER</TD><TD>DIRECCION</TD>"
                         + "</TR>";
            
            Nodo aux = this.first;
            while(aux!=null){
                Clientes data = (Clientes) aux.data;
                datos += "<TR> "
                          + "<TD>"+data.getDpi()+"</TD><TD>"+data.getName()+"</TD><TD>"+data.getUser()+"</TD><TD>"+data.getDireccion()+"</TD>"
                          + "</TR>";
                aux = aux.next;
            }
           
            datos+="</TABLE>>];";
            
            pw.println(datos);
            pw.println("}");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte){
                    reporte.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TablaClientes.png","TablaClientes.dot");
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
                if(aux.data!=null){
                    Lugar data = (Lugar) aux.data;
                    Nodo aux2 = data.Rutas.first;
                    if(aux2!=null){
                        vecino data2 = (vecino) aux2.data;
                        datos+="rank = same{nodo"+data.id+" -> nodo"+data.id+data2.id+"};\n";

                        while(aux2.next != null){
                            data2 = (vecino) aux2.data;
                            vecino data3 = (vecino) aux2.next.data;
                            datos+="rank = same{nodo"+data.id+data2.id+" -> nodo"+data.id+data3.id+"};\n";
                            aux2 = aux2.next;
                        }
                    }
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
    
    public void TopViajes(){
        Nodo aux = this.first;
        
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = this.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    viajes x = (viajes) actual.data;
                    viajes y = (viajes) siguiente.data;
                    if (x.getTiempo()<y.getTiempo()) {
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
            
            FileWriter reporte1 = null;
            PrintWriter pw = null;
            try{
                reporte1 = new FileWriter("TopViajes.dot");
                pw = new PrintWriter(reporte1);

                pw.println("digraph G {");
                pw.println("node[shape=\"box\"]");

                Nodo aux2 = this.first;
                int i = 0;
                while(aux2 != null){
                    viajes a = (viajes) aux2.data;
                    pw.println("nodo"+i+"[label = \"Pedido de: "+a.nombre+"\\n Desde: "+a.ruta.first.data.toString()+"\\n Hasta: "+a.ruta.last.data.toString()+"\\n Tiempo: "+a.tiempo+" min\"]");         
                    i++;
                    if(i==10){break;}
                    aux2 = aux2.next;
                }
                i=0;
                aux2 = this.first;
                while(aux2 != null){
                    if(aux2.next!=null){
                        pw.println("nodo"+i+"->nodo"+(i+1));
                        if(i==8){break;}
                        i++;
                    }       
                    aux2 = aux2.next;
                }
                pw.println("label = \"Top 10 Viajes con más distancia\";");
                pw.println("}");

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{       
                    if(null != reporte1){
                        reporte1.close();
                        ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TopViajes.png","TopViajes.dot");
                        buil.redirectErrorStream(true);
                        buil.start();           
                    }
            }catch(Exception e2){
            e2.printStackTrace();
            }
            }
            
            
            
        }
    }
    
    public void TopClientes(){
        Nodo aux = this.first;
        
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = this.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    Clientes x = (Clientes) actual.data;
                    Clientes y = (Clientes) siguiente.data;
                    if (x.pedidos<y.pedidos) {
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
            
            FileWriter reporte1 = null;
            PrintWriter pw = null;
            try{
                reporte1 = new FileWriter("TopClientes.dot");
                pw = new PrintWriter(reporte1);

                pw.println("digraph G {");
                pw.println("node[shape=\"box\"]");

                Nodo aux2 = this.first;
                int i = 0;
                while(aux2 != null){
                    Clientes a = (Clientes) aux2.data;
                    pw.println("nodo"+i+"[label = \"Nombre: "+a.getName()+"\\n Cantidad de Pedidos: "+a.pedidos+"\"]");         
                    i++;
                    if(i==10){break;}
                    aux2 = aux2.next;
                }
                i=0;
                aux2 = this.first;
                while(aux2 != null){
                    if(aux2.next!=null){
                        pw.println("nodo"+i+"->nodo"+(i+1));
                        if(i==8){break;}
                        i++;
                    }       
                    aux2 = aux2.next;
                }
                pw.println("label = \"Top 10 Clientes con mas pedidos\";");
                pw.println("}");

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{       
                    if(null != reporte1){
                        reporte1.close();
                        ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TopClientes.png","TopClientes.dot");
                        buil.redirectErrorStream(true);
                        buil.start();           
                    }
            }catch(Exception e2){
            e2.printStackTrace();
            }
            }
            
            
            
        }
    }
    
}
