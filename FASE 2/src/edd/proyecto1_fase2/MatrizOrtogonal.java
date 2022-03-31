
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class MatrizOrtogonal {
    ListaCabeceraFila filas;
    ListaCabeceraColumna columnas;

    public MatrizOrtogonal() {
        this.filas = new ListaCabeceraFila();
        this.columnas = new ListaCabeceraColumna();
    }

    public void insertar(int x, int y, String dato){
        NodoOrtogonal nodoNuevo;
        nodoNuevo = new NodoOrtogonal(dato, x, y);
        if(columnas.busqueda(x) == null){
            //existe la cabecera columnas
            columnas.insertar(new NodoCabeceraColumna(x));
        }
        if(filas.busqueda(y) == null){
            filas.insertar(new NodoCabeceraFila(y));
        }
        NodoCabeceraColumna tmpC;
        NodoCabeceraFila tmpF;
        tmpC = columnas.busqueda(x);
        tmpF = filas.busqueda(y);
        tmpC.columna.insertar(nodoNuevo);
        tmpF.fila.insertar(nodoNuevo);
    }

    public void llenar(int x, int y){
        for (int j = 0; j < y; j ++){
            for(int i = 0; i < x; i ++){
                insertar(i,j,"+");
            }
        }
    }
    
    public void mostrar(){
        NodoCabeceraColumna aux = this.columnas.primero;
        while(aux!=null){
            NodoOrtogonal aux2 = aux.columna.primero;
            while(aux2!=null){
                System.out.println("Dato: "+aux2.dato+" x: "+aux2.x+" y: "+aux2.y);
                aux2=aux2.abajo;
            }
            aux = aux.siguiente;
        }
    
    }
    
    public void Graphviz(int dimx,int dimy,String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
        capa = new FileWriter(name+".dot");
        pw = new PrintWriter(capa);
        
        pw.println("digraph G {");
        pw.println("node [shape=box]");
        
        pw.println(" Mt[ label = \"\", group = 0 ];");
        pw.println("e0[ shape = point, width = 0 ];\n" +
                   "e1[ shape = point, width = 0 ];");
        
        String fila="", columna = "";
        String enlaceF="Mt -> F1[dir = \"both\"];\n", enlaceC = "rank = same{ Mt -> C1[dir = \"both\"]};\n";
        for (int i = 1; i < dimx+1; i++) {
            columna+="C"+i+"[ label = \"\", group = "+i+"];\n";
            if((i+1)<dimx+1){
                enlaceC+="rank = same{ C"+i+" -> C"+(i+1)+"[dir = \"both\"]};\n";
            }
        }
        for (int i = 1; i < dimy+1; i++) {
            fila+="F"+i+"[ label = \"\", group = 0];\n";
            if((i+1)<dimy+1){
                enlaceF+="F"+i+" -> F"+(i+1)+"[dir = \"both\"];\n";
            }
        }
        pw.println(fila);
        pw.println(enlaceF);
        pw.println(columna);
        pw.println(enlaceC);
        
        String nodos="",enlaceFC="";
        NodoCabeceraColumna aux = this.columnas.primero;
        while(aux!=null){
            NodoOrtogonal aux2 = aux.columna.primero;
            while(aux2!=null){
                nodos+="NF"+aux2.x+"C"+aux2.y+"[ label = \"\", style = filled, fillcolor = \""+aux2.dato+"\",group = "+aux2.y+"];\n";
                aux2 = aux2.abajo;
            }
            aux = aux.siguiente;  
        }
        
        NodoCabeceraColumna r = this.columnas.primero;
        for (int i = 0; i < dimy+1; i++) {
            if (r!=null) {
                if (r.x == i) {
                    NodoOrtogonal c = r.columna.primero;
                    for (int j = 0; j < dimx+1; j++) {                        
                        if (c != null) {
                            if (c.y == j) {
                                    if((c.izquierda==null && c.arriba==null) ){
                                        enlaceFC+="rank = same{ F"+c.x+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"]};\n";
                                        enlaceFC+="C"+c.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"];\n";
                                    }else if(c.izquierda==null  && c.arriba!=null){
                                        enlaceFC+="rank = same{ NF"+c.arriba.x+"C"+c.arriba.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"]};\n";
                                        enlaceFC+="C"+c.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"];\n";
                                    }else if(c.izquierda!=null && c.arriba==null){
                                        enlaceFC+="rank = same{ F"+c.x+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"]};\n";
                                        enlaceFC+="NF"+c.izquierda.x+"C"+c.izquierda.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"];\n";
                                    }else{
                                        enlaceFC+="rank = same{ NF"+c.arriba.x+"C"+c.arriba.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"]};\n";
                                        enlaceFC+="NF"+c.izquierda.x+"C"+c.izquierda.y+" -> "+"NF"+c.x+"C"+c.y+"[dir = \"both\"];\n";
                                    }
                                c = c.abajo;
                            }
                        }
                    }
                    r = r.siguiente;            
                }                
            }            
        }
        
        pw.println(nodos);
        pw.println(enlaceFC);
        
        pw.println("}");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+".png",name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    public void imagen_png(int dimx,int dimy,String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
            capa = new FileWriter(name+"HD.dot");
            pw = new PrintWriter(capa);

            pw.println("digraph G {");
            pw.println("a0 [label=< \n <TABLE cellspacing=\"0\" cellpadding=\"10\">");

            String contenido="";
            NodoCabeceraColumna r = this.columnas.primero;
            for (int i = 0; i < dimy+1; i++) {
                if (r!=null) {
                    if (r.x == i) {
                        NodoOrtogonal c = r.columna.primero;
                        contenido+="<TR>";
                        for (int j = 0; j < dimx+1; j++) {                        
                            if (c != null) {
                                if (c.y == j) {
                                    contenido+="<TD bgcolor=\""+c.dato.toString()+"\"></TD>\n";
                                    c = c.abajo;
                                } else contenido+="<TD bgcolor=\"#ffffff\"></TD>\n"; 
                            } else contenido+="<TD bgcolor=\"#ffffff\"></TD>\n"; 
                        }
                        r = r.siguiente;            
                    } else { 
                        contenido+="<TR>";
                        for (int j = 0; j < dimx+1; j++) {
                            contenido+="<TD bgcolor=\"#ffffff\"></TD>\n";
                        }
                    }                
                } else { 
                    contenido+="<TR>";
                    for (int j = 0; j < dimx+1; j++) {
                        contenido+="<TD bgcolor=\"#ffffff\"></TD>\n";
                    }
                }
                contenido+="</TR>";            
            }
            contenido+="</TABLE>>][color=white]";
            pw.println(contenido);
            pw.println("}");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+"HD.png",name+"HD.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
}
