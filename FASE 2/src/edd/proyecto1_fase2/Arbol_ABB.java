
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

    public String preorder(Nodo raiz,String nodos) {
        if (raiz != null) {
            nodos+=raiz.id.id+",";
            nodos = preorder(raiz.izq,nodos);
            nodos = preorder(raiz.der,nodos);
        }
        return nodos;
    }
    
    public String inorden(Nodo raiz,String nodos) {
        if (raiz != null) {
            nodos = inorden(raiz.izq,nodos);
            nodos+=raiz.id.id+",";
            nodos = inorden(raiz.der,nodos);
        }
        return nodos;
    }

    public String postorden(Nodo raiz,String nodos) {
        if (raiz != null) {
            nodos = postorden(raiz.izq,nodos);
            nodos = postorden(raiz.der,nodos);
            nodos+=raiz.id.id+",";
        }
        return nodos;
    }
     

    public String postordenL(Nodo raiz,String nodos,int contador) {
        if (raiz != null && contador > 0) {
            contador--;
            nodos = postordenL(raiz.izq,nodos,contador);
            nodos = postordenL(raiz.der,nodos,contador);
            nodos+=raiz.id.id+",";
        }
        return nodos;
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
    
    public int Contar_Nodos(Nodo raiz, int contador){
        if (raiz.izq != null) {
            contador = Contar_Nodos(raiz.izq,contador+1);
        }
        if(raiz.der !=null){
            contador = Contar_Nodos(raiz.der,contador+1);
        }
        return contador;
    }
    
    public String Nodos_hoja(Nodo raiz, String nodos){
    
        if(raiz != null){
            if(raiz.der == null && raiz.izq == null){
                nodos+="Capa"+raiz.id.id+",";
            }
            nodos = Nodos_hoja(raiz.izq,nodos);
            nodos = Nodos_hoja(raiz.der,nodos);
        }
        return nodos;
    }
    
    public String profundidad(Nodo raiz,int nivel){
    
        String nodos = "";
        Nodo aux = raiz;
        if(aux!=null){
            nodos+="nivel"+nivel+"[label=\"Nivel "+nivel+"\"]";
            
            nodos+=aux.valor+"[label=\"Capa_"+aux.id.id+"\"]";
            nodos+="rank = same{nivel"+nivel+" -> "+aux.valor+"};\n";
            
            if(aux.izq != null){
                nodos+="nivel"+nivel+" -> nivel"+(nivel+1)+";\n";
                nodos+=profundidad(aux.izq,nivel+1);
            }
            if(aux.der != null){
                nodos+=profundidad(aux.der,nivel+1);
            }    
        }
        
        return nodos;
    }
        
    
    
}


