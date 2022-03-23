
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
    
    
    
}
