
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Objects;


public class Arbol_B {
    
    int orden_arbol = 5;
    RamaB raiz;

    public class NodoB {
        Long id;
        Clientes c;
        NodoB siguiente;
        NodoB anterior;
        RamaB derecha;
        RamaB izquierda;

        public NodoB(Long id, Clientes c) {
            this.id = id;
            this.c = c;
            this.anterior = null;
            this.siguiente = null;
            this.derecha = null;
            this.izquierda = null;
        }
    }
    
    public class RamaB {

        boolean hoja;
        int contador;
        NodoB primero;

        public RamaB() {
            this.primero = null;
            this.hoja = true;
            this.contador = 0;
        }

        public void insertar(NodoB nuevo) {
            if (primero == null) {
                primero = nuevo;
                contador++;
            } else {
                NodoB aux = primero;
                while (aux != null) {
                    if (Objects.equals(aux.id, nuevo.id)) {
                        System.out.println("El ID " + nuevo.id + " ya existe");
                        break;
                    } else {
                        if (aux.id > nuevo.id) {
                            if (aux == primero) {
                                aux.anterior = nuevo;
                                nuevo.siguiente = aux;
                               
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;

                                primero = nuevo;
                                contador++;
                                break;
                            } else {
                                nuevo.siguiente = aux;
                               
                                aux.izquierda = nuevo.derecha;
                                nuevo.derecha = null;

                                nuevo.anterior = aux.anterior;
                                aux.anterior.siguiente = nuevo;
                                aux.anterior = nuevo;
                                contador++;
                                break;
                            }
                        } else if (aux.siguiente == null) {
                            aux.siguiente = nuevo;
                            nuevo.anterior = aux;
                            contador++;
                            break;
                        }
                    }
                    aux = aux.siguiente;
                }

            }
    }

        public NodoB search(Long index) {
            NodoB aux =this.primero;
            while(aux.siguiente != null){
                if(Objects.equals(aux.id, index)){
                    return aux;
                }
                aux = aux.siguiente;
            }
            if(Objects.equals(aux.id, index)){
                return aux;
            }
            aux = this.primero;
            if(this.hoja){
                return null;
            }else{
                while(aux.siguiente != null){
                    NodoB aux2 = aux;
                    if(aux.izquierda != null){
                        aux = aux.izquierda.search(index);
                    }
                    if(aux!=null){
                        return aux;
                    }
                    aux = aux2;
                    if(aux.derecha != null){
                        aux = aux.derecha.search(index);
                    }
                    if(aux!=null){
                        return aux;
                    }
                    aux = aux2;
                    aux = aux.siguiente;
                }
                NodoB aux2 = aux;
                if(aux.izquierda != null){
                    aux = aux.izquierda.search(index);
                }
                if(aux!=null){
                    return aux;
                }
                aux = aux2;
                if(aux.derecha != null){
                    aux = aux.derecha.search(index);
                }
                if(aux!=null){
                    return aux;
                }
            }
            return null;
        }
        
        public String graficar(){
            String nodos = "";
            NodoB aux = primero;
            
            nodos+=aux.c.dpi+"[label = \"|"+aux.c.name;
            while(aux.siguiente!=null){
                nodos+=" || "+aux.c.name;
                aux = aux.siguiente;
            }
            if(aux.siguiente==null){nodos+="|\"]\n";}
            
            aux = primero;
            while(aux!=null){
                if(aux.izquierda != null){
                    nodos+=aux.c.dpi+" -> "+aux.izquierda.primero.c.dpi+";\n";
                    nodos+=aux.izquierda.graficar();
                }
                if(aux.derecha != null){
                    nodos+=aux.c.dpi+" -> "+aux.derecha.primero.c.dpi+";\n";
                    nodos+=aux.derecha.graficar();
                }
                aux = aux.siguiente;
            }
            
            return nodos;
        }

        public String enlistar(int nivel){
            String nodos = "";
            NodoB aux = primero;
            nodos+="nivel"+nivel+"[label=\"Nivel "+nivel+"\"]";
            int total = aux.c.avl.Contar_Nodos(aux.c.avl.root, 0);
            nodos+=aux.c.dpi+"[label=\""+aux.c.name+"\\n"+aux.c.dpi+"\\n"+total+"\"]";
            nodos+="rank = same{nivel"+nivel+" -> "+aux.c.dpi+"};\n";
            
            while(aux.siguiente!=null){
                total = aux.c.avl.Contar_Nodos(aux.c.avl.root, 0);
                nodos+=aux.c.dpi+"[label=\""+aux.c.name+"\\n"+aux.c.dpi+"\\n"+total+"\"]";
                nodos+="rank = same{"+aux.c.dpi+" -> "+aux.siguiente.c.dpi+"};\n";
                aux = aux.siguiente;
            }
            if(aux.siguiente == null){
                nodos+=aux.c.dpi+"[label=\""+aux.c.name+"\\n"+aux.c.dpi+"\\n"+total+"\"]";
            }
            aux = primero;
            while(aux!=null){
                if(aux.izquierda != null){
                    nodos+="nivel"+nivel+" -> nivel"+(nivel+1)+";\n";
                    nodos+=aux.izquierda.enlistar(nivel+1);
                }
                if(aux.derecha != null){
                    
                    nodos+=aux.derecha.enlistar(nivel+1);
                }
                aux = aux.siguiente;
            }
            
            return nodos;
        }
        
    }
    
    public Arbol_B() {
        this.raiz = null;
    }

    public void insert(Long id, Clientes C) {
        NodoB nodo = new NodoB(id,C);
        if (raiz == null) {
            raiz = new RamaB();
            raiz.insertar(nodo);
        } else {
            NodoB obj = insertar_en_rama(nodo, raiz);
            if (obj != null) {
                raiz = new RamaB();
                raiz.insertar(obj);
                raiz.hoja = false;
            }
        }
    }

    public NodoB insertar_en_rama(NodoB nodo, RamaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == orden_arbol) {
                return dividir(rama);
            } else {
                return null;
            }
        } else {
            NodoB temp = rama.primero;
            do {
                if (Objects.equals(nodo.id, temp.id)) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_rama(nodo, temp.izquierda);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_rama(nodo, temp.derecha);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    public NodoB dividir(RamaB rama) {
        Long val = new Long(-999);
        Clientes c=null;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            if (cont < 3) {
                temp = new NodoB(aux.id, aux.c);
                temp.izquierda = aux.izquierda;
                if (cont == 2) {
                    temp.derecha = aux.siguiente.izquierda;
                } else {
                    temp.derecha = aux.derecha;
                }
                if (temp.derecha != null && temp.izquierda != null) {
                    rizquierda.hoja = false;
                }

                rizquierda.insertar(temp);

            } else if (cont == 3) {
                val = aux.id;
                c = aux.c;
            } else {
                temp = new NodoB(aux.id, aux.c);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                if (temp.derecha != null && temp.izquierda != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val,c);
        Nuevito.derecha = rderecha;
        Nuevito.izquierda = rizquierda;
        return Nuevito;
    }
    
    public NodoB Search(Long id){
        RamaB root = this.raiz;
        NodoB aux = root.search(id);
        return aux;
    }
    
    public void Graficar(String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
            capa = new FileWriter(name+"arbB.dot");
            pw = new PrintWriter(capa);

            pw.println("digraph G {");
            pw.println("node[shape = \"Mrecord\"]");
            String nodos = this.raiz.graficar();
            pw.println(nodos);
            pw.println("}");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+"arbB.png",name+"arbB.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    public void Enlistar(String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
            capa = new FileWriter(name+"listaC.dot");
            pw = new PrintWriter(capa);

            pw.println("digraph G {");
            pw.println("node[shape = \"box\"]");
            String nodos = this.raiz.enlistar(0);
            pw.println(nodos);
            pw.println("}");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+"listaC.png",name+"listaC.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
}
