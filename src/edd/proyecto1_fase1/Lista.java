
package edd.proyecto1_fase1;

import java.io.FileWriter;
import java.io.PrintWriter;


public class Lista {
   
    private Nodo first;
    
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
    
    public void show(){
        if(first == null){
            System.err.print("No hay datos en la lista");
        }
        else{
            Nodo aux = first;
        
            while(aux != null){
                System.out.println(aux.data);
                aux = aux.next;
               
            }
        }
    }
    
    public void graph(){
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
        
        reporte1 = new FileWriter("carnet.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Nodo aux = first;
        int i = 1;
        while(aux != null){
            if(aux!=null){
                pw.println("nodo"+i+"[label = "+aux.data+"]");
            }            
            i++;    
            aux = aux.next;
        }
        i=1;
        aux = first;
        while(aux != null){
            if(aux.next!=null){
                pw.println("rank=same{nodo"+i+"->nodo"+(i+1)+"}");
            }            
            i++;    
            aux = aux.next;
        }
        
        pw.println("}");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","carnet.png","carnet.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
        
        
    }
    
    
    
}

