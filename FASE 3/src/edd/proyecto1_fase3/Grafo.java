
package edd.proyecto1_fase3;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    
    int tamaño, enlaces;
    double[] distancia;
    String[] ruta;
    ArrayList<String> vertices;
    static int[][] arr_enlaces;
    boolean[] visitados;
    
    public  Grafo(int n){
        this.tamaño = n;
        enlaces=0;
        vertices = new ArrayList<>(n);
        arr_enlaces  = new int[n][n];
        visitados = new boolean[n+1];
        distancia = new double[n];
        ruta = new String[n];
        
        Arrays.fill(distancia, Double.POSITIVE_INFINITY);
        Arrays.fill(ruta, "");
    }

    public  void añadirVertices(String s){
        vertices.add(s);
    }
    
    public  void añadirVecino(int a, int b, int peso){
        arr_enlaces[a][b] = peso;
        arr_enlaces[b][a] = peso;
        enlaces++;
    }
        
    public String [] dijkStra(int inicio, String fin){
        int aux1=0;
        int auxInicio = inicio;
        distancia[inicio]=0;
        String salida [] = new String [2];
        fin = fin.replaceAll(" ", "");
        
        while (!visitados[auxInicio]){
            boolean encontrado = false;
            for (int i = 0; i <vertices.size() ; i++) {
                if (arr_enlaces[auxInicio][i]>0){
                    aux1 = i;
                    encontrado = true;
                    break;
                } 
            }
            if(!encontrado){
                aux1 = tamaño;
            }
            
            while(visitados[aux1]){
                for (int i = aux1+1 ; i <vertices.size() ; i++) {
                    if (arr_enlaces[auxInicio][i]>0){
                        aux1 = i;
                        encontrado = true;
                        break;
                    }
                }
                if(!encontrado){
                    aux1 = tamaño;
                }
                encontrado = false;
            }
            
            encontrado = false;
            if(aux1==tamaño){
                visitados[auxInicio]=true;
            }else{
                while(!visitados[aux1] && aux1<tamaño){
                    visitados[auxInicio]=true;
                    double auxDistancia = distancia[auxInicio]+arr_enlaces[auxInicio][aux1];
                    if (auxDistancia < distancia[aux1]){
                        distancia[aux1] = auxDistancia;
                        ruta[aux1] = ruta[auxInicio]+","+vertices.get(auxInicio);
                    }
                    for (int i = aux1+1 ; i <vertices.size() ; i++) {
                        if (arr_enlaces[auxInicio][i]>0){
                            aux1 = i;
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        aux1 = tamaño;
                    }
                    encontrado = false;
                }
            }
            
            int nuevo_inicio = 0;
            double nueva_distancia = Double.POSITIVE_INFINITY;
            for (int i = 0; i < distancia.length; i++) {
                if (!visitados[i]){
                    if(distancia[i] < nueva_distancia){
                        nueva_distancia = distancia[i];
                        nuevo_inicio = i;
                    }
                }
            }   
            auxInicio = nuevo_inicio;
            
        }
        for (int i = 0; i <tamaño ; i++) {
            ruta[i] = ruta[i]+", "+vertices.get(i);
        }

        for (int i = 0; i <tamaño ; i++) {
            ruta[i]=ruta[i].replaceAll(" ","");
            ruta[i]=ruta[i].substring(1,ruta[i].length());
            String arr [] = ruta[i].split(",");
            if(arr[arr.length-1].equals(fin)){
                salida[0] = ruta[i];
                salida[1] = String.valueOf(distancia[i]) ;
            }
        }
        return salida;
    }

}



