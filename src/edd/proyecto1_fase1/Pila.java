
package edd.proyecto1_fase1;


import java.io.FileWriter;
import java.io.PrintWriter;

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
    
    public void show(){
       
        if(first == null){
            System.out.println("No existen elementos");
        }else{
            Nodo aux = first;
            while(aux!=null){
                System.out.println("Pais: "+aux.data+" , Capital: "+aux.data);
                aux = aux.next;
            }
        }
    }
    
    public void pop(){
        
        if(first == null){
            System.out.println("No existen elementos");
        }else{
            first = first.next;
        }
    }
    
    public Pila invert(){
        
        Nodo aux = first;
        Pila inv = new Pila();
        
        while (aux != null){
            inv.push(aux.data);
            aux = aux.next;
        }
        
        return inv;
    }
    
    public void graph(){
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
        
        reporte1 = new FileWriter("pila.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Nodo aux = first;
        int i = 1;
        while(aux != null){
            if(aux!=null){
                pw.println("nodo"+i+"[label = \""+aux.data+"\"]");
            }            
            i++;    
            aux = aux.next;
        }
        i=1;
        aux = first;
        while(aux != null){
            if(aux.next!=null){
                pw.println("nodo"+i+"->nodo"+(i+1));
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
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","pila.png","pila.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
        
        
    }
    
    
}

