
package edd.proyecto1_fase1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import edd.proyecto1_fase1.ventanilla.Nodo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EDDProyecto1_fase1 {
        static Cola clientes = new Cola();
        static ventanilla Ventanas = new ventanilla();
        static Cola img_color= new Cola();
        static Cola img_bw = new Cola();
        static Espera c_espera = new Espera();
        static Lista c_atendidos = new Lista();
        static int contador = 1;
        static int index=0;
    public static void main(String[] args) {

      boolean exit = false;
      while (!exit){
      
        System.out.println("-------MENÚ-------");
        System.out.println("1. Parámetros Iniciales");
        System.out.println("2. Ejecutar paso");
        System.out.println("3. Estado de memoria");
        System.out.println("4. Reportes");
        System.out.println("5. Acerca de");
        System.out.println("6. Salir");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("ELIJA UNA OPCIÓN: ");
        int opcion ;
            opcion = sc.nextInt();
    
      switch(opcion){
          case 1:
              clientes = read();
              Ventanas = create_v();
              System.out.println("Datos inicializados correctamente");
          break;
          case 2: 
              paso();
              imprimir();
              espera();
          break;
          case 3: 
              Estructuras();
              System.out.println("Archivo generado correctamente");
          break;
          case 4: 
                reportes();
          break;
          case 5:
              System.out.println(" -> Universidad de San Carlos de Guatemala");
              System.out.println(" -> Facultad de Ingeniería");
              System.out.println(" -> Escuela de Ciencias y Sistemas");
              System.out.println(" -> Estructuras de Datos sección C");
              System.out.println(" -> Henry Ronely Mendoza Aguilar");
              System.out.println(" -> Carnet: 202004810");
          break;
          case 6: exit = true;  //salir 
              System.out.println("Simulación finalizada");
          break;
          default: System.out.println("Elija una opcion valida");
      } 
      
        
        
        
    }
    }
    
    public static Cola read(){
        System.out.println("Escriba la ruta del archivo: ");
        Scanner sc = new Scanner(System.in);
        String root;
               root = sc.nextLine();
        
        File file;
        FileReader fr;
        BufferedReader br;
        String content = "";
        try{
            file = new File(root);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                content += line;
            }
            String json = "{"+content;
            
            json = json.replaceAll("\\{\\{", "[");
            json = json.replaceAll("}}", "}]");
            json = json.replaceAll("\"Cliente[0-9]*\":", "");
            
            JsonParser parser = new JsonParser();
            JsonArray clientes = parser.parse(json).getAsJsonArray();
            
            System.out.println("Cantidad de Clientes en la cola: " + clientes.size());
            index = clientes.size()+1;
            
            Cola filac = new Cola();
            
            for(int i=0;i<clientes.size();i++){
                JsonObject c = clientes.get(i).getAsJsonObject();
                Cliente aux = new Cliente(c.get("id_cliente").getAsString(),
                                            c.get("nombre_cliente").getAsString(),
                                            c.get("img_color").getAsString(),
                                            c.get("img_bw").getAsString(),"");
                aux.total=Integer.parseInt(aux.img_bw)+Integer.parseInt(aux.img_c);
                filac.append(aux);
            }
           
            return filac;
            
        }catch(JsonSyntaxException | IOException e){System.out.println(e);}
        
        return null;
    }
    
    public static ventanilla create_v(){
    
        System.out.println("Ingrese el número de ventanilas: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        try{
            ventanilla v = new ventanilla();
            for(int i=0;i<n;i++){
                
                Pila p = new Pila();
                v.append(p, (i+1));
            }
            return v;
            
        }catch(Exception e){System.out.println(e);}
        
        return null;
    }
    
    public static void paso(){
    
       String paso="----------Paso "+contador+"----------\n";
       Nodo aux = Ventanas.first;
       
        while(aux!=null){
            if(aux.clt==null && clientes.first!=null){
               aux.clt = (Cliente) clientes.first.data;
               aux.clt.setVentanilla(String.valueOf(aux.id));
               clientes.remove();
               paso+="EL CLIENTE "+aux.clt.id+" INGRESA A LA VENTANILLA "+aux.id+"\n";
               break;
            }else{
                if(aux.clt != null){
                    int color = Integer.parseInt(aux.clt.getImg_c());
                    int bw = Integer.parseInt(aux.clt.getImg_bw());
                    if(bw>0){
                        aux.pila.push("img_bw");
                        paso+="LA VENTANILLA "+aux.id+" RECIBE UNA IMAGEN DEL CLIENTE "+aux.clt.id+"\n";
                        bw--;
                        aux.clt.setImg_bw(String.valueOf(bw));
                    }else if(bw==0 && color>0){
                        aux.pila.push("img_c");
                        paso+="LA VENTANILLA "+aux.id+" RECIBE UNA IMAGEN DEL CLIENTE "+aux.clt.id+"\n";
                        color--;
                        aux.clt.setImg_c(String.valueOf(color));
                    }else if(color==0 && bw == 0){
                        Lista l_aux = new Lista();
                        c_espera.append(l_aux, aux.clt);
                   
                        while(aux.pila.first != null){
                            if(aux.pila.first.data == "img_bw"){
                                print img = new print("bw",aux.clt,1);
                                img_bw.append(img);
                            }else if(aux.pila.first.data == "img_c"){
                                print img = new print("c",aux.clt,2);
                                img_color.append(img);
                            }
                            aux.pila.pop();
                        }
                        paso+="LA VENTANILLA "+aux.id+" ENVIA A COLA DE IMPRESION LAS IMAGENES DEL CLIENTE "+aux.clt.id+"\n";
                        aux.clt = null;
                   
                    }
                }
            }
            aux = aux.next;
        }
        
        
        contador++;
        System.out.println(paso);
        generar_c();
        
    }
    
    public static void imprimir(){
        String paso = "";

        if(c_espera.first!=null){
            Espera.Nodo c = c_espera.first; //lista de clientes
            if(img_bw.first!=null){
                print p_bw = (print) img_bw.first.data; //impresora blanco y negro
                int tbw = p_bw.getPasos()-1;
                p_bw.setPasos(tbw);
                if(p_bw.getPasos()==0){
                    while(c!=null){
                        if(p_bw.c.id.equals(c.cliente.id)){
                            c.lista.append("bw");
                            paso+="SE REALIZÓ LA IMPRESION A BLANCO Y NEGRO PARA EL CLIENTE "+c.cliente.id+"\n";
                        }
                        c=c.next;
                    }
                    img_bw.remove();
                }
            }
            if(img_color.first!=null){
                print p_c = (print) img_color.first.data; //impresora color
                int tc = p_c.getPasos()-1;
                p_c.setPasos(tc);
                c=c_espera.first;
                if(p_c.getPasos()==0){
                    while(c!=null){
                        if(p_c.c.id.equals(c.cliente.id)){
                            c.lista.append("c");
                            paso+="SE REALIZÓ LA IMPRESION A COLOR PARA EL CLIENTE "+c.cliente.id+"\n";
                        }
                        c=c.next;
                    }
                    img_color.remove();
                }
            }
            System.out.println(paso);
        }
    }
    
    public static void espera(){
        String paso="";
        if(c_espera.first!=null){
            Espera.Nodo c = c_espera.first; //lista de clientes
            int lista=0;
            while(c!=null){
                Lista.Nodo l = c.lista.first;
                while(l!=null){
                    lista++;
                    l=l.next;
                }
                
                if(c.cliente.total==lista){
                    Atendidos a = new Atendidos(c.cliente.name,
                                                c.cliente.ventanilla,
                                                String.valueOf(c.cliente.tbw),
                                                String.valueOf(c.cliente.tc),
                                                String.valueOf(contador),
                                                c.cliente.id);
                    paso+="EL CLIENTE "+c.cliente.id+" SALE DEL SISTEMA, SE HA REGISTRADO EN EL HISTORIAL\n";
                    c_atendidos.append(a);
                    c_espera.delete(c.cliente.id);
                }
                c=c.next;
                lista=0;
            }
            System.out.println(paso);
        }
    }
    
    public static void generar_c(){
    
        String nombres [] = {"José","Alexis","Kathy","Luis","Manuel","Lucas","Kimberly","Josué","Angie","Ronely","Christopher","Alvaro","Fátima","Kevin","Diego","Rocio","Andrea","Oscar","Mario","Alán","Luisa"};
        String apellidos [] = {"Girón","Santos","Ramírez","Martínez","Vargas","Muñoz","Luna","Galindo","Estrada","Aguilar","Herrera","González","Cifuentes","Solares","Monzón","Pérez","Palacios","Padilla","Valladares","Pereira","Guzmán"};
        
        int index_n,index_a,index_color,index_bw;
        int index_c = (int) Math.floor(Math.random()*4); //cantidad de clientes

        while(index_c !=0){
            index_n = (int) Math.floor(Math.random()*20);
            index_a = (int) Math.floor(Math.random()*20);
            index_color = (int) Math.floor(Math.random()*4);
            index_bw = (int) Math.floor(Math.random()*4);
            
            Cliente c = new Cliente(String.valueOf(index),
                            nombres[index_n]+" "+apellidos[index_a],
                            String.valueOf(index_color),
                            String.valueOf(index_bw),"");
            c.total=Integer.parseInt(c.img_bw)+Integer.parseInt(c.img_c);
            clientes.append(c);
            
            index++;
            index_c--;
        }
        
        
        
    }
    
    public static void Estructuras(){
    FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
        
        reporte1 = new FileWriter("estructuras.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("label = \"Estado de Memoria de las Estructuras\"");
        pw.println("fontsize=\"20\"");
        
        
        pw.println("subgraph cluster_0 {");
        pw.println("node [style=filled];");
        Cola.Nodo aux_1 = clientes.first;
        while(aux_1!=null){
           Cliente c = (Cliente) aux_1.data;
           pw.println("C"+c.id+"[label = \"Cliente "+c.id+"\\n"+c.name+"\"];"); 
           aux_1=aux_1.next;
        }
        aux_1=clientes.first;
        while(aux_1!=null){
           if(aux_1.next!=null){
                Cliente c0 = (Cliente) aux_1.data;
                Cliente c1 = (Cliente) aux_1.next.data;
                pw.println("rank=same{C"+c1.id+"->C"+c0.id+"}");
            }
           aux_1=aux_1.next;
        }
        pw.println("label = \"Cola recepción\";");
        pw.println("color=blue}");
        
        pw.println("subgraph cluster_1 {");
        pw.println("node [style=filled];");
        ventanilla.Nodo aux_2 = Ventanas.first;
        while(aux_2!=null){
           pw.println("v"+aux_2.id+"[label = \"Ventanilla "+aux_2.id+"\",shape=\"box\"];");
           Pila p = aux_2.pila;
           Pila.Nodo aux_p = p.first;
           int img = 0;
           while(aux_p!=null){
               pw.println("i"+img+aux_2.id+"[label = \""+aux_p.data+"\",shape=\"note\"];");
               img++;
               aux_p=aux_p.next;
           }
           img=0;
           aux_2=aux_2.next;
        }
        
        aux_2 = Ventanas.first;
        while(aux_2!=null){
           Pila p = aux_2.pila;
           Pila.Nodo aux_p = p.first;
           int img = 0;
           if(aux_p!=null){
            pw.println("rank=same{v"+aux_2.id+"->i"+img+aux_2.id+"};");
           } 
            while(aux_p!=null){
                if(aux_p.next!=null){
                    pw.println("rank=same{i"+img+aux_2.id+"->i"+(img+1)+aux_2.id+"};");
                    img++;
                }
               aux_p=aux_p.next;
            }
           img=0;
           aux_2=aux_2.next;
        }
        aux_2 = Ventanas.first;
        while(aux_2!=null){
           if(aux_2.next!=null){
                pw.println("v"+aux_2.id+"->v"+aux_2.next.id);
            }
           if(aux_2.clt!=null){
               pw.println("C"+aux_2.clt.id+"[label = \"Cliente "+aux_2.clt.id+"\\n"+aux_2.clt.name+"\"];");
               pw.println("rank=same{C"+aux_2.clt.id+"->v"+aux_2.id+"};");
           }
           aux_2=aux_2.next;
        }
        pw.println("label = \"Lista de Ventanillas\";");
        pw.println("color=blue}");
        
        
        pw.println("subgraph cluster_2 {");
        pw.println("node [style=filled];");
        Cola.Nodo aux_3 = img_bw.first;
        pw.println("bw [label = \"Impresora \\n Blanco y Negro\",shape=\"note\"];");
        int i = 0;
        while(aux_3!=null){
           pw.println("bw"+i+"[label = \"img_bw\",shape=\"note\"];");
           i++;
           aux_3=aux_3.next;
        }
        Cola.Nodo aux_4 = img_color.first;
        pw.println("Cl [label = \"Impresora \\n a Color\",shape=\"note\"];");
        i = 0;
        while(aux_4!=null){
           pw.println("Cl"+i+"[label = \"img_c\",shape=\"note\"];");
           i++;
           aux_4=aux_4.next;
        }
         
        i = 0;
        aux_3 = img_bw.first;
        if(aux_3!=null){
        pw.println("rank=same{bw->bw0};");
        }
        while(aux_3!=null){
           if(aux_3.next!=null){
            pw.println("rank=same{bw"+i+"->bw"+(i+1)+"}");
            i++;
           }
           aux_3=aux_3.next;
        }
        aux_4 = img_color.first;
        
        if(aux_4!=null){
        pw.println("rank=same{Cl->Cl0};");
        }
        i = 0;
        while(aux_4!=null){
           if(aux_4.next!=null){
            pw.println("rank=same{Cl"+i+"->Cl"+(i+1)+"}");
            i++;
           }
           aux_4=aux_4.next;
        }
        
        pw.println("bw->Cl[color=\"#ffffff\"];");
        
        pw.println("label = \"Cola de Impresión\";");
        pw.println("color=blue}");
        
        pw.println("subgraph cluster_3 {");
        pw.println("node [style=filled];");
        Espera.Nodo aux_5 = c_espera.first;
        while(aux_5!=null){
           Cliente c = aux_5.cliente;
           pw.println("Es"+c.id+"[label = \"Cliente "+c.id+"\\n"+c.name+"\"];");
           Lista aux_l = aux_5.lista;
           Lista.Nodo l = aux_l.first;
           int j=0;
           while(l!=null){
               pw.println("Es"+c.id+j+"[label = \"img_"+l.data+"\",shape=\"note\"];");
               j++;
               l=l.next;
           }
           j=0;
           aux_5=aux_5.next;
        }
        
        aux_5=c_espera.first;
        while(aux_5!=null){
           Cliente c = aux_5.cliente;
           Lista aux_l = aux_5.lista;
           Lista.Nodo l = aux_l.first;
           int j=0;
           if(l!=null){
                pw.println("Es"+c.id+"->"+"Es"+c.id+j+";");
           }
           while(l!=null){
               if(l.next!=null){
                   pw.println("Es"+c.id+j+"->"+"Es"+c.id+(j+1)+";");
                   j++;
                }
               l=l.next;
            }
           j=0;
           aux_5=aux_5.next;
        }
        
        aux_5=c_espera.first;
        while(aux_5!=null){
            Cliente c = aux_5.cliente;
            if(aux_5.next!=null){
                Cliente c2=aux_5.next.cliente;
                pw.println("rank=same{Es"+c.id+"->Es"+c2.id+"};");
            }
            aux_5=aux_5.next;
        }
        
        pw.println("label = \"Lista Clientes en Espera\";");
        pw.println("color=blue}"); 

        pw.println("}");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","estructuras.png","estructuras.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    public static void reportes(){
        
        boolean exit = false;
      while (!exit){
      
        System.out.println("-------Reportes-------");
        System.out.println("1. Top 5 clientes con más imagenes a color");
        System.out.println("2. Top 5 clientes con más imagenes a blanco y negro");
        System.out.println("3. Cliente con más pasos en el sistema");
        System.out.println("4. Buscar cliente atendido");
        System.out.println("5. Salir al menú principal");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("ELIJA UNA OPCIÓN: ");
        int opcion ;
            opcion = sc.nextInt();
    
      switch(opcion){
          case 1:
              Top5Color();
              System.out.println("Archivo generado correctamente");
          break;
          case 2: 
              Top5Bw();
              System.out.println("Archivo generado correctamente");
          break;
          case 3: 
              Cpasos();
              System.out.println("Archivo generado correctamente");
          break;
          case 4: 
              buscar();
              System.out.println("Archivo generado correctamente");
          break;
          case 5: exit = true;  //salir 
              System.out.println("Simulación finalizada");
          break;
          default: System.out.println("Elija una opcion valida");
      } 
      }
    
    }
    
    public static void Top5Color(){
        Lista L = c_atendidos;
        Lista.Nodo aux = L.first; 
        
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = L.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    Atendidos x = (Atendidos) actual.data;
                    Atendidos y = (Atendidos) siguiente.data;
                    if (Integer.parseInt(x.n_imgc)<Integer.parseInt(y.n_imgc)) {
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
        reporte1 = new FileWriter("TopMasColor.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Lista.Nodo top = L.first;
        int i = 0;
        while(top != null){
            Atendidos a = (Atendidos) top.data;
            pw.println("nodo"+i+"[label = \"Nombre: "+a.cliente+"\\n Cantidad de Imagenes a Color: "+a.n_imgc+"\"]");         
            i++;
            if(i==5){break;}
            top = top.next;
        }
        i=0;
        top = L.first;
        while(top != null){
            if(top.next!=null){
                pw.println("nodo"+i+"->nodo"+(i+1));
                if(i==3){break;}
                i++;
            }       
            top = top.next;
        }
        pw.println("label = \"Top 5 Clientes con más imagenes a color\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TopMasColor.png","TopMasColor.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
        
    }
    
    public static void Top5Bw(){
        Lista L = c_atendidos;
        Lista.Nodo aux = L.first; 
        
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = L.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    Atendidos x = (Atendidos) actual.data;
                    Atendidos y = (Atendidos) siguiente.data;
                    if (Integer.parseInt(x.n_img)>Integer.parseInt(y.n_img)) {
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
        reporte1 = new FileWriter("TopMenosBN.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Lista.Nodo top = L.first;
        int i = 0;
        while(top != null){
            Atendidos a = (Atendidos) top.data;
            pw.println("nodo"+i+"[label = \"Nombre: "+a.cliente+"\\n Cantidad de Imagenes en Blanco y Negro: "+a.n_img+"\"]");         
            i++;
            if(i==5){break;}
            top = top.next;
        }
        i=0;
        top = L.first;
        while(top != null){
            if(top.next!=null){
                pw.println("nodo"+i+"->nodo"+(i+1));
                if(i==3){break;}
                i++;
            }       
            top = top.next;
        }
        pw.println("label = \"Top 5 Clientes con menos imagenes en Blanco y Negro\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","TopMenosBN.png","TopMenosBN.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    public static void Cpasos(){
    
        Lista L = c_atendidos;
        Lista.Nodo aux = L.first; 
        
        if(aux!=null){
            Lista.Nodo actual = aux;
            boolean sw;
            Object temp;
            do{
                actual = L.first;
                Lista.Nodo siguiente = actual.next;
                sw=false;
                while(actual.next!=null){
                    Atendidos x = (Atendidos) actual.data;
                    Atendidos y = (Atendidos) siguiente.data;
                    if (Integer.parseInt(x.n_pasos)<Integer.parseInt(y.n_pasos)) {
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
        reporte1 = new FileWriter("MasPasos.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Lista.Nodo top = L.first;
        Atendidos a = (Atendidos) top.data;
        pw.println("nodo[label = \" Cliente No. "+a.id+"\\n "
                        + "Nombre: "+a.cliente+"\\n "
                        + "Cantidad de Imagenes a Color: "+a.n_imgc+"\\n "
                        + "Cantidad de Imagenes en Blanco y Negro: "+a.n_img+"\\n "
                        + "Pasos en el Sistema: "+a.n_pasos+"\"]");
        
        pw.println("label = \"Cliente con Más pasos en el Sistema\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","MasPasos.png","MasPasos.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    public static void buscar(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE EL ID DEL CLIENTE A BUSCAR: ");
        String opcion ;
            opcion = sc.nextLine();

        FileWriter reporte1 = null;
        PrintWriter pw = null;
        try{
        reporte1 = new FileWriter("Buscar.dot");
        pw = new PrintWriter(reporte1);
        
        pw.println("digraph G {");
        pw.println("bgcolor = \"#9DDEFC\"");
        pw.println("node[shape=\"box\" fillcolor=\"#E6D4BE\" style =filled]");
        
        Lista L = c_atendidos;
        Lista.Nodo top = L.first;
        while(top != null){
            Atendidos a = (Atendidos) top.data;
            if(a.id.equals(String.valueOf(opcion))){
                pw.println("nodo[label = \" Cliente No. "+a.id+"\\n "
                        + "Nombre: "+a.cliente+"\\n "
                        + "Cantidad de Imagenes a Color: "+a.n_imgc+"\\n "
                        + "Cantidad de Imagenes en Blanco y Negro: "+a.n_img+"\\n "
                        + "Pasos en el Sistema: "+a.n_pasos+"\"]");
                break;
            }
            top = top.next;
        }
        
        pw.println("label = \"Cliente Encontrado\";");
        pw.println("}");
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != reporte1){
                    reporte1.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o","Buscar.png","Buscar.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    
    }
    
    
}
