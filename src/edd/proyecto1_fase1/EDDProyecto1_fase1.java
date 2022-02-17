
package edd.proyecto1_fase1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import edd.proyecto1_fase1.ventanilla.Nodo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EDDProyecto1_fase1 {
        static Cola clientes = new Cola();
        static ventanilla Ventanas = new ventanilla();
        static Cola img_color, img_bw = new Cola();
        static Espera c_espera = new Espera();
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
          break;
          case 2: 
              paso();
          break;
          case 3: 
            
          break;
          case 4: 
        
          break;
          case 5:
              
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
            json = json.replaceAll("\"Cliente[0-9]\"*:", "");
            
            JsonParser parser = new JsonParser();
            JsonArray clientes = parser.parse(json).getAsJsonArray();
            
            System.out.println("Cantidad de Objetos: " + clientes.size());
            index = clientes.size()+1;
            
            Cola filac = new Cola();
            
            for(int i=0;i<clientes.size();i++){
                JsonObject c = clientes.get(i).getAsJsonObject();
                Cliente aux = new Cliente(c.get("id_cliente").getAsString(),
                                            c.get("nombre_cliente").getAsString(),
                                            c.get("img_color").getAsString(),
                                            c.get("img_bw").getAsString());
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
               clientes.remove();
               paso+="EL CLIENTE "+aux.clt.id+" INGRESA A LA VENTANILLA "+aux.id+"\n";
               break;
            }else{
                if(aux.clt != null){
               
                    int color = Integer.parseInt(aux.clt.getImg_c());
                    int bw = Integer.parseInt(aux.clt.getImg_bw());
                    System.out.println("COLOR: "+color+" BW: "+bw);
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
                                print img = new print("bw",aux.clt);
                                img_bw.append(img);
                            }else if(aux.pila.first.data == "img_c"){
                                print img = new print("c",aux.clt);
                                img_bw.append(img);
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
    
    public static void generar_c(){
    
        String nombres [] = {"José","Alexis","Kathy","Luis","Manuel","Lucas","Kimberly","Josué","Angie","Ronely","Christopher","Alvaro","Fátima","Kevin","Diego","Rocio","Andrea","Oscar","Mario","Alán","Luisa"};
        String apellidos [] = {"Girón","Santos","Ramírez","Martínez","Vargas","Muñoz","Luna","Galindo","Estrada","Aguilar","Herrera","González","Cifuentes","Solares","Monzón","Pérez","Palacios","Padilla","Valladares","Pereira","Guzmán"};
        
        int index_n,index_a,index_color,index_bw;
        int index_c = (int) Math.floor(Math.random()*4); //cantidad de clientes

        while(index_c !=0){
            index_n = (int) Math.floor(Math.random()*20);
            index_a = (int) Math.floor(Math.random()*20);
            index_color = (int) Math.floor(Math.random()*2);
            index_bw = (int) Math.floor(Math.random()*2);
            
            Cliente c = new Cliente(String.valueOf(index),
                            nombres[index_n]+" "+apellidos[index_a],
                            String.valueOf(index_color),
                            String.valueOf(index_bw));
            
            clientes.append(c);
            
            index++;
            index_c--;
        }
        
        
        
    }
    
}
