
package edd.proyecto1_fase3;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Objects;


public class TablaHash {
    private Mensajero arr [];
    private int M;
    private int count,ind_p;
    
    private final int primos[];
    
    public TablaHash(){
        this.primos = new int[]{37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        this.M = primos[0];
        this.arr = new Mensajero[this.M];
        this.count = 0;
        this.ind_p = 0;
    }
    
    public Mensajero [] getTabla(){
        return this.arr;
    }
    
    public int functionhash(Long Key){
        int hash;
        hash = (int) (Key%this.M);
        return hash;
    }
    
    public int Colision(int i, int c){
        int new_hash;
        new_hash = (int) ((i%7)+1)*c;
        
        while(new_hash>=this.M){
            c++;
            new_hash = (int) ((new_hash%7)+1)*c;
        }
    
        return new_hash;
    }
    
    public void add(Mensajero elem){
        int pos = this.functionhash(elem.getDpi());
        
        if(this.count==Math.round(this.M*0.75)){
            rehash(elem);
        }else{
            int col = 1;
            while(this.arr[pos]!=null){
                pos = this.Colision(pos, col);
                col++;
            }
            this.count++;
            this.arr[pos]=elem;
        }   
    }
    
    public void rehash(Mensajero elem){
        this.ind_p++;
        this.M = this.primos[this.ind_p];
        this.count = 0;
        Mensajero aux [] = new Mensajero[this.M];
        
        int pos;
        for(int i = 0;i<this.primos[this.ind_p-1];i++){
            if(this.arr[i]!=null){
                Mensajero auxE = this.arr[i];
                pos = this.functionhash(auxE.getDpi());
                int col = 1;
                while(aux[pos]!=null){
                    pos = this.Colision(pos, col);
                    col++;
                }
                this.count++;
                aux[pos]=auxE;
            }
        }
        this.arr = aux;
        add(elem);
        
    
    }
    
    public Mensajero buscar(String key){
       Long llv = Long.parseLong(key);
        for (int i = 0; i < this.M; i++) {
            if (this.arr[i] != null) {
                if (Objects.equals(this.arr[i], llv)) {
                    return this.arr[i];
                }
            } 
        }
        return null;
    }  
     
    public Mensajero getMensajero(int i){
        return this.arr[i];
    }
    
    public void añadirPedido(int i,int p){
        this.arr[i].pedidos += p;
    }
    
    public void TopMensajeros(){
        Mensajero aux [] = this.arr.clone();
        
        for (int x = 0; x < aux.length; x++) {
            for (int y = 0; y < aux.length - 1; y++) {
                Mensajero actual = aux[y], siguiente = aux[y + 1];
                if(actual!=null && siguiente!=null){
                    if (actual.pedidos < siguiente.pedidos) {
                        aux[y] = siguiente;
                        aux[y + 1] = actual;
                    }
                }
            }
        }
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("TopMensajeros.dot");
            pw = new PrintWriter(reporte1);

            pw.println("digraph G {");
            pw.println("node[shape=\"box\"]");

            
            int i = 0;
            int j = 0;
            Mensajero temp [] = new Mensajero[10];
            while(j < aux.length){
                if(aux[i]!=null){
                    pw.println("nodo"+j+"[label = \"Entragas de: "+aux[i].nombre+" "+aux[i].apellido+"\\n Cantidad: "+aux[i].pedidos+"\"]");         
                    temp[j]=aux[i];
                    j++;    
                }
                i++;
                if(j==10){break;}
            }
            
            j=0;
            for (int k = 0; k < temp.length; k++) {
                if((j+1)<temp.length){
                    pw.println("nodo"+j+"->nodo"+(j+1));
                    j++;
                }
            }
            
            pw.println("label = \"Top 10 Mensajeros con más entregas\";");
            pw.println("}");

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{       
                    if(null != reporte1){
                        reporte1.close();
                        ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TopMensajeros.png","TopMensajeros.dot");
                        buil.redirectErrorStream(true);
                        buil.start();           
                    }
            }catch(Exception e2){
            e2.printStackTrace();
            }
            }
        
        
    }
    
    public void graph(){
        
        FileWriter reporte = null;
        PrintWriter pw = null;
        try{
            reporte = new FileWriter("TablaHash.dot");
            pw = new PrintWriter(reporte);

            pw.println("digraph G {");
            pw.println("node [shape=\"box\"]");
            pw.println("label = \"Tabla Hash\"");
            pw.println("a0 [label=< \n <TABLE>");
            String datos = "<TR> "
                         + "<TD>indice</TD><TD>DPI</TD><TD>DPI</TD>"
                         + "</TR>";
            for (int i = 0; i < this.M; i++) {
                if(this.arr[i] != null) {
                    datos += "<TR> "
                          + "<TD>"+i+"</TD><TD>"+this.arr[i].dpi+"</TD><TD>"+this.arr[i].nombre+" "+this.arr[i].apellido+"</TD>"
                          + "</TR>";
                }
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
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TablaHash.png","TablaHash.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
            }catch(Exception e2){
            e2.printStackTrace();
            }
        }
        System.out.println("Archivo creado");

    }
    
    public void mostrar(){
        System.out.println("Tabla Hash");
        for (int i = 0; i < this.M; i++) {
            if (this.arr[i] != null) {
                if(this.arr[i] != null) {
                    System.out.println(i+" "+this.arr[i].nombre+" | "+this.arr[i].dpi+ " |");
                }
            } else {
                System.out.println(" {} |");
            }
        }
        System.out.println("");
    }
    
}




