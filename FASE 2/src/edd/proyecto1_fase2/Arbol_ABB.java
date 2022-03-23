
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;


public class Arbol_ABB {
    Nodo root;
    
    public class Nodo{
        int valor;
        capa id;
        Nodo izq, der;
            public Nodo(int valor, capa id){
                this.id = id;
                this.valor=valor;
                this.izq = this.der = null;
            }
    }
    
    public Arbol_ABB() {
        this.root = null;
    }

    public void agregar(int valor,capa id) {
        this.root = agregar_recursive(valor, this.root , id) ;
    }

    public Nodo agregar_recursive(int Valor, Nodo raiz ,capa id) {
        if (raiz == null) {
            return new Nodo(Valor , id);
        } else {
            if (Valor < raiz.valor) {
                raiz.izq = agregar_recursive(Valor, raiz.izq , id);
                
            } else {
                raiz.der = agregar_recursive(Valor, raiz.der , id);
            }
            return raiz;
        }
    }

    public void Graficar(String nombre) {
        String contenido="";
        contenido+=nodos(contenido,this.root);
        contenido+=enlaces(contenido,this.root);
        FileWriter reporte1 = null;
        PrintWriter pw;
        try{
            reporte1 = new FileWriter(nombre+"ABB.dot");
            pw = new PrintWriter(reporte1);
            pw.println("digraph G {");
            pw.println("node[shape=\"circle\" style =filled]");
            pw.println(contenido);
            pw.println("}");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",nombre+"ABB.png",nombre+"ABB.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    public String enlaces(String contenido,Nodo raiz) {
        String con="";
        if (raiz.izq != null) {
            contenido += raiz.valor + " -> " + raiz.izq.valor + "\n";
            contenido += enlaces(con,raiz.izq);
        }
        con="";
        if (raiz.der != null) {
            contenido += raiz.valor + " -> " + raiz.der.valor + "\n";
            contenido += enlaces(con, raiz.der);
        }
        return contenido;
    }
    
    public String nodos(String contenido,Nodo raiz) {
        String con="";
        if (raiz != null) {
            contenido+=raiz.valor+"[label=\"Capa "+raiz.valor+"\"]\n";
            contenido+=nodos(con,raiz.izq);
            con="";
            contenido+=nodos(con,raiz.der);
        }
        return contenido;
    }

    public void preorder(Nodo raiz) {
        if (raiz != null) {
            System.out.println("Hoja: " + raiz.valor);
            preorder(raiz.izq);
            preorder(raiz.der);
        }
    }
    
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.izq);
            System.out.println("Hoja: " + raiz.valor);
            inorden(raiz.der);
        }
    }

    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.izq);
            postorden(raiz.der);
            System.out.println("Hoja: " + raiz.valor);
        }
    }
    
    public Nodo search(int id){
    
        Nodo aux = this.root;
        
        while(aux.valor != id){
            if(id<aux.valor){
                aux = aux.izq;
            }else{
                aux = aux.der;
            }
            if(aux == null){return null;}
        }
        return aux;
    }
    
}


