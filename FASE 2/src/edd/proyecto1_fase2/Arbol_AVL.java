
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;


public class Arbol_AVL {
    
    Nodo root = null;
    
    public class Nodo {
	int value;
	Nodo left;
	Nodo right;
        int alt;
	imagen img;
        
	Nodo(int value, imagen img){
            this.value = value;
            left = null;
            right = null;
            alt = 0;
            this.img = img;
	}
    }
	
    void add(int value, imagen img) {
	root = add(value, root,img);
    }
	
    Nodo add(int value, Nodo tmp, imagen img) {
        if (tmp == null){ 
            tmp = new Nodo(value,img);
        }else if (value < tmp.value) {
            tmp.left = add(value, tmp.left, img);
            if ((altura(tmp.left)-altura(tmp.right))==2){
                if (value<tmp.left.value){ 
                    tmp = srl(tmp);
                }
                else{
                    tmp = drl(tmp);
                }
            }            
	}else {
            tmp.right = add(value, tmp.right, img);
            if ((altura(tmp.right)-altura(tmp.left))==2) {
                if (value>tmp.right.value){
                    tmp = srr(tmp);
                }else{
                    tmp = drr(tmp);
                }
            }
	}
        int d, i, m;
        d = altura(tmp.right);
        i = altura(tmp.left);
        m = maxi(d,i);
        tmp.alt = m + 1;
        return tmp;
    }

    int altura(Nodo tmp) {
        if (tmp == null) return -1;
        else return tmp.alt;
    }

    int maxi(int val1, int val2) {
        return ((val1 > val2) ? val1 : val2);
    }

    Nodo srl(Nodo t1) { //simple por la derecha
        Nodo t2;
        t2 = t1.left;
        t1.left = t2.right;
        t2.right = t1;
        t1.alt = maxi(altura(t1.left), altura(t1.right))+1;
        t2.alt = maxi(altura(t2.left),t1.alt)+1;
        return t2;
    }

    Nodo srr(Nodo t1) {//simple por la izquierda
        Nodo t2;
        t2 = t1.right;
        t1.right = t2.left;
        t2.left = t1;
        t1.alt = maxi(altura(t1.left), altura(t1.right))+1;
        t2.alt = maxi(altura(t2.right),t1.alt)+1;
        return t2;
    }

    Nodo drl(Nodo tmp) {//doble por la izquierda        
        tmp.left = srr(tmp.left);
        return srl(tmp);
    }

    Nodo drr(Nodo tmp) {//doble por la derecha
        tmp.right = srl(tmp.right);
        return srr(tmp);
    }
	
    public void Graficar(String nombre) {
        String contenido="";
        contenido+=nodos(contenido,this.root);
        contenido+=enlaces(contenido,this.root);
        FileWriter reporte1 = null;
        PrintWriter pw;
        try{
            reporte1 = new FileWriter(nombre+"AVL.dot");
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
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",nombre+"AVL.png",nombre+"AVL.dot");
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
        if (raiz.left!= null) {
            contenido += raiz.value + " -> " + raiz.left.value + "\n";
            contenido += enlaces(con,raiz.left);
        }
        con="";
        if (raiz.right != null) {
            contenido += raiz.value + " -> " + raiz.right.value + "\n";
            contenido += enlaces(con, raiz.right);
        }
        return contenido;
    }
    
    public String nodos(String contenido,Nodo raiz) {
        String con="";
        if (raiz != null) {
            contenido+=raiz.value+"[label=\"Imagen "+raiz.value+"\"]\n";
            contenido+=nodos(con,raiz.left);
            con="";
            contenido+=nodos(con,raiz.right);
        }
        return contenido;
    }
    
    public Nodo search(int id){
    
        Nodo aux = this.root;
        
        if(aux!=null){
            while(aux.value != id){
                if(id<aux.value){
                    aux = aux.left;
                }else{
                    aux = aux.right;
                }

                if(aux == null){
                    return null;
                }
            }
        }
        return aux;
    }
    
    public int Contar_Nodos(Nodo raiz, int contador){
        if(raiz!=null){
            if (raiz.left != null) {
                contador = Contar_Nodos(raiz.left,contador+1);
            }
            if(raiz.right !=null){
                contador = Contar_Nodos(raiz.right,contador+1);
            }
        }
        return contador;
    }
    
    public void eliminar(int id){
        root = eliminarAVL(root,id);
    }
    
    private Nodo eliminarAVL(Nodo actual, int id){
        
        if(actual == null){
            return actual;
        }
        
        if(id < actual.value){
            actual.left = eliminarAVL(actual.left,id);
        }else if(id > actual.value){
            actual.right = eliminarAVL(actual.right,id);
        }else{
            if((actual.left == null) || (actual.right == null)){
                Nodo temp = null;
                if(temp == actual.left){
                    temp = actual.right;
                }else{
                    temp = actual.left;
                }
                
                if(temp == null){
                    actual = null;
                }else{
                    actual = temp;
                }
                
            }else{
                Nodo temp =  Maximo(actual.left);
                actual.value = temp.value;
                actual.left = eliminarAVL(actual.left,temp.value);
            }
        }
        
        if(actual == null){
            return actual;
        }
        
        actual.alt = maxi(altura(actual.left),altura(actual.right))+1;
        int FE =  getFactorEquilibrio(actual);
        
        if (FE > 1 && getFactorEquilibrio(actual.left) >= 0) {
            return srl(actual);
        }
 
        if (FE < -1 && getFactorEquilibrio(actual.right) <= 0) {
            return srr(actual);
        }
 
        if (FE > 1 && getFactorEquilibrio(actual.left) < 0) {
            return drl(actual);
        }
        
        if (FE < -1 && getFactorEquilibrio(actual.right) > 0) {
            return drr(actual);
        }
        
        return actual;
    }
    
    private Nodo Maximo(Nodo node) {
        Nodo current = node;
        
        while (current.right != null){
           current = current.right;
        }
        
        return current;
    }
    private int getFactorEquilibrio(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
 
        return altura(nodoActual.left) - altura(nodoActual.right);
    }
}
