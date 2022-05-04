
package edd.proyecto1_fase3;

public class Grafo {
    
    public class Vertice{
    
        String id;
        Lista vecinos;
        boolean visitado;
        Vertice padre;
        float costo;

        public Vertice(String id) {
            this.id = id;
            this.vecinos = new Lista();
            this.visitado = false;
            this.padre = null;
            this.costo = Float.POSITIVE_INFINITY;
        }
        
        public void añadirvecino(vecino v){
            if(!exist(v)){
                this.vecinos.append(v);
            }
        }
        
        public boolean exist(vecino ve){
            if(this.vecinos.size()>0){
               Lista.Nodo aux = this.vecinos.first;
               while(aux!=null){
                   vecino data = (vecino) aux.data;
                   if(data.v.id.equals(ve.v.id)){
                       return true;
                   }
                   aux = aux.next;
               }
            }
            return false;
        }
    
    }
    
    public class vecino{
        Vertice v;
        int peso;

        public vecino(Vertice v, int peso) {
            this.v = v;
            this.peso = peso;
        }
    }

    public class nodo{
        String id;
        Vertice v;

        public nodo(String id, Vertice v) {
            this.id = id;
            this.v = v;
        }
    }

    
    Lista vertices;

    public Grafo() {
        this.vertices = new Lista();
    }
    
    public void agregarvertice(String id){
        Vertice nuevo = new Vertice(id);
        nodo node = new nodo(id,nuevo);
        if(!exist(node)){
            this.vertices.append(node);
        }
    }
    
    public void agregararista(String auxa, String auxb, int peso){
        Vertice va = new Vertice(auxa);
        nodo a = new nodo(auxa,va);
        Vertice vb = new Vertice(auxb);
        nodo b = new nodo(auxb,vb);
        
        if(exist(a) && exist(b)){
            vecino vecinoA = new vecino(a.v,peso);
            vecino vecinoB = new vecino(b.v,peso);
            nodo aux = getNodo(a.id);
            aux.v.añadirvecino(vecinoB);
            aux = getNodo(b.id);
            aux.v.añadirvecino(vecinoA);
        }
    }
    
    public void camino(String inicio, String fin){
        String camino = "";
        
        Vertice actual = getNodo(fin).v; 
        while(actual!=null){
            camino+= actual.id+",";
            actual = actual.padre;
        }
        
        System.out.println(camino);
    }
    
    public Vertice minimo(Lista noVisitados){
        
        if(noVisitados.size() > 0){
            Vertice novisit = (Vertice) noVisitados.first.data;
            String primero = novisit.id;
            //System.out.println("primero "+primero);
            nodo v = getNodo(primero);
            Vertice x=v.v;
            //System.out.println("vertice "+x.id);
            float m = v.v.costo;
            
            Lista.Nodo aux = noVisitados.first;
            while(aux!=null){
                Vertice auxV = (Vertice) aux.data;
                
                String indice = auxV.id;
                nodo w = getNodo(indice);
                if(m > w.v.costo){
                    //System.out.println(v.v.id+"    "+w.v.id);
                    //System.out.println(m+"   "+w.v.costo);
                    m = w.v.costo;
                    x = w.v;
                }
                aux = aux.next;
            }
            System.out.println(x.id);
            return x;
        }      
        return null;
    }
    
    public void dijkstra(String inicio){
        if(exist(new nodo(inicio,new Vertice(inicio)))){
            Vertice a = getNodo(inicio).v; 
            a.costo = 0;
            Vertice actual = a;
            
            Lista noVisitados = new Lista();
            Lista.Nodo aux = this.vertices.first;
            while(aux!=null){
                nodo n = (nodo) aux.data;
                Vertice v = n.v;
                if(!v.id.equals(a.id)){
                    v.costo = Float.POSITIVE_INFINITY;
                }
                v.padre = null;
                noVisitados.append(v);
                aux = aux.next;
            }
            
            while(noVisitados.size() > 0){
                Lista vecinos = actual.vecinos;
                Lista.Nodo auxVecinos = vecinos.first;
                while(auxVecinos!=null){
                    vecino data = (vecino) auxVecinos.data;
                    //System.out.println("actual "+actual.id+" vecino "+data.v.id);
                    if(data.v.visitado == false){
                        if((actual.costo+data.peso) < data.v.costo){
                            data.v.costo = actual.costo+data.peso;
                            data.v.padre = actual;
                            setNodo(data.v);
                        }
                    }
                    
                    auxVecinos = auxVecinos.next;
                }
                
                actual.visitado = true;
                noVisitados.remove(actual.id);
                
                System.out.println("ACTUAL "+actual.id);
                actual = this.minimo(noVisitados);
            }
            
        }
    
    }
    
    public boolean exist(nodo n){
        if(this.vertices.size()>0){
            Lista.Nodo aux = this.vertices.first;
            while(aux!=null){
                nodo data = (nodo) aux.data;
                if(data.id.equals(n.id)){
                    return true;
                }
                aux = aux.next;
            }
        }
        return false;
    }
    
    public nodo getNodo(String n){
        if(this.vertices.size()>0){
            Lista.Nodo aux = this.vertices.first;
            while(aux!=null){
                nodo data = (nodo) aux.data;
                if(data.id.equals(n)){
                    return data;
                }
                aux = aux.next;
            }
        }
        return null;
    }
    
    public void setNodo(Vertice v){
        if(this.vertices.size()>0){
            Lista.Nodo aux = this.vertices.first;
            while(aux!=null){
                nodo data = (nodo) aux.data;
                if(data.id.equals(v.id)){
                    data.v = v;
                }
                aux = aux.next;
            }
        }
    
    }
    
    
    public void mostrarVertices(){
        Lista.Nodo aux = this.vertices.first;
        
        while(aux!=null){
            nodo data = (nodo) aux.data;
            System.out.println(data.v.id+" costo: "+data.v.costo);
            
            aux = aux.next;
        }
        
    }
    
}



