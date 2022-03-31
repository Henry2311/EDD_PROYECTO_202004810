
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Clientes {
   
    Long dpi;
    String name, password;
    Arbol_AVL avl = new Arbol_AVL();
    Arbol_B arbB;
    Arbol_ABB abb = new Arbol_ABB();
    Lista album = new Lista();
    Lista top = new Lista();
    public Clientes(Long dpi, String name, String password) {
        this.dpi = dpi;
        this.name = name;
        this.password = password;
    }

    public Long getDpi() {
        return dpi;
    }

    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Arbol_AVL getAvl() {
        return avl;
    }

    public void setAvl(Arbol_AVL avl) {
        this.avl = avl;
    }

    public Arbol_B getArbB() {
        return arbB;
    }

    public void setArbB(Arbol_B arbB) {
        this.arbB = arbB;
    }

    public Lista getAlbum() {
        return album;
    }

    public void setAlbum(Lista album) {
        this.album = album;
    }

    public Arbol_ABB getAbb() {
        return abb;
    }

    public void setAbb(Arbol_ABB abb) {
        this.abb = abb;
    }
    
    public void Grafo_Albums(){
        FileWriter reporte1 = null;
        PrintWriter pw;
        try{
            reporte1 = new FileWriter(this.name+"Albums.dot");
            pw = new PrintWriter(reporte1);
            pw.println("digraph G {");
            pw.println("node[shape=\"box\" style=filled]");
            pw.println("label = \"Listado de Albumes\"");
            
            String contenido = "";
            int i = 0;
            Lista.Nodo aux = this.album.first;
            while(aux!=null){
                album al = (album) aux.data;
                contenido+="A"+i+al.nombre.replaceAll(" ", "_")+"[label = \""+al.nombre+"\"];\n";
                Lista.Nodo aux2 = al.imagenes.first;
                int j = 0;
                while(aux2 != null){
                    String data = (String) aux2.data;
                    contenido+="I"+j+data.replaceAll(" ", "_")+"[label = \""+data+"\"];\n";
                    j++;
                    aux2 = aux2.next;
                }
                i++;
                aux = aux.next;
            }
            
            i = 0;
            aux = this.album.first;
            while(aux!=null){
                album al = (album) aux.data;
                Lista.Nodo aux2 = al.imagenes.first;
                int j = 0;
                if(aux2 != null){
                    contenido+="A"+i+al.nombre.replaceAll(" ", "_")+" -> I"+j+aux2.data.toString().replaceAll(" ", "_")+";\n";
                }
                while(aux2 != null){
                    if(aux2.next != null){
                        contenido+="I"+j+aux2.data.toString().replaceAll(" ", "_")+" -> I"+(j+1)+aux2.next.data.toString().replaceAll(" ", "_")+";\n";
                        j++;
                    }
                    aux2 = aux2.next;
                }
                i++;
                aux = aux.next;
            }
            
            i = 0;
            aux = this.album.first;
            while(aux!=null){
                if(aux.next != null){
                    album al = (album) aux.data;
                    album al2 = (album) aux.next.data;
                    contenido+="rank = same{ A"+i+al.nombre.replaceAll(" ", "_")+" -> A"+(i+1)+al2.nombre.replaceAll(" ", "_")+"};\n";
                    contenido+="rank = same{ A"+(i+1)+al2.nombre.replaceAll(" ", "_")+" -> A"+i+al.nombre.replaceAll(" ", "_")+"};\n";
                }
                i++;
                aux = aux.next;
            }
            pw.println(contenido);
            pw.println("}");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",this.name+"Albums.png",this.name+"Albums.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    public void Top5(){
        Lista.Nodo aux = top.first; 
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = top.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    top_img x = (top_img) actual.data;
                    top_img y = (top_img) siguiente.data;
                    if (x.getCantidad()<y.getCantidad()) {
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
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("Top"+this.name+".dot");
            pw = new PrintWriter(reporte1);

            pw.println("digraph G {");
            pw.println("node[shape=\"box\"]");

            Lista.Nodo aux2 = top.first;
            int i = 0;
            while(aux2 != null){
                top_img a = (top_img) aux2.data;
                pw.println("nodo"+i+"[label = \"Nombre: "+a.nombre+"\\n Cantidad de Capas: "+a.cantidad+"\"]");         
                i++;
                if(i==5){break;}
                aux2 = aux2.next;
            }
            i=0;
            aux2 = top.first;
            while(aux2 != null){
                if(aux2.next!=null){
                    pw.println("nodo"+i+"->nodo"+(i+1));
                    if(i==3){break;}
                    i++;
                }       
                aux2 = aux2.next;
            }
            pw.println("label = \"Top 5 Imagenes con más capas\";");
            pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Top"+this.name+".png","Top"+this.name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
    }
    
    public void hojas(){
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("Hojas"+this.name+".dot");
            pw = new PrintWriter(reporte1);

            pw.println("digraph G {");

            String hojas = "";
            hojas = this.abb.Nodos_hoja(this.abb.root, hojas);
            String rang = hojas.substring(0, hojas.length()-1);
            String lista_hojas [] = rang.split(",");
            
            for (int i = 0; i < lista_hojas.length; i++) {
                pw.println("nodo"+i+"[label =\""+lista_hojas[i]+"\"];");
            }
            
            pw.println("label = \"Nodos hoja del arbol de capas\";");
            pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Hojas"+this.name+".png","Hojas"+this.name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
            e2.printStackTrace();
        }
        }
    
    }
    
    public void Recorridos(){
        
        String preorder = this.abb.preorder(this.abb.root, "");
        preorder = preorder.substring(0, preorder.length()-1);
        String L_preorder [] = preorder.split(",");
        
        String inorder = this.abb.inorden(this.abb.root, "");
        inorder = inorder.substring(0, inorder.length()-1);
        String L_inorder [] = inorder.split(",");
        
        String postorder = this.abb.postorden(this.abb.root, "");
        postorder = postorder.substring(0, postorder.length()-1);
        String L_postorder [] = postorder.split(",");
        
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("Recorridos"+this.name+".dot");
            pw = new PrintWriter(reporte1);
            
            String contenido = "";
            
            pw.println("digraph G {");
            
            for (int i = 0; i < L_preorder.length; i++) {
                contenido += "pre"+i+"[label = \"Capa_"+L_preorder[i]+"\"];\n";
                contenido += "in"+i+"[label = \"Capa_"+L_inorder[i]+"\"];\n";
                contenido += "post"+i+"[label = \"Capa_"+L_postorder[i]+"\"];\n";
            }
           
            contenido += "rank = same{ Preorder -> pre0};\n";
            contenido += "rank = same{ Inorder -> in0};\n";
            contenido += "rank = same{ Postorder -> post0};\n";
            
            for (int i = 0; i < L_preorder.length-1; i++) {
                contenido += "rank = same {pre"+i+" -> pre"+(i+1)+"};\n";
                contenido += "rank = same {in"+i+" -> in"+(i+1)+"};\n";
                contenido += "rank = same {post"+i+" -> post"+(i+1)+"};\n";
            }
            contenido += "Preorder -> Inorder -> Postorder[color = white];\n";
            
            pw.println(contenido);
            pw.println("label = \"Recorridos Arbol de Capas\";");
            pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Recorridos"+this.name+".png","Recorridos"+this.name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
            e2.printStackTrace();
        }
        }
        
    }
    
    public void Profundidad(){
        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
            reporte1 = new FileWriter("Profundidad"+this.name+".dot");
            pw = new PrintWriter(reporte1);
            
            String contenido = this.abb.profundidad(this.abb.root, 0);
            
            pw.println("digraph G {");
            pw.println(contenido);
            pw.println("label = \"Recorridos Arbol de Capas\";");
            pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Profundidad"+this.name+".png","Profundidad"+this.name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
            e2.printStackTrace();
        }
        }
    }
    
}
