
package edd.proyecto1_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;

class SparseNode {
    Object data;
    int row, col;
    SparseNode up;
    SparseNode down;
    SparseNode right;
    SparseNode left;

    public SparseNode(Object data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
        up = down = right = left = null;
    }
}

public class Matriz {
    SparseNode head;

    public Matriz() {
        head = new SparseNode("XX", 0, 0);
    }

    void add(Object data, int row, int col) {        
        SparseNode ci  = null; // col iterator
        SparseNode cip = null; // col iterator preview
        SparseNode ri  = null; // row iterator
        SparseNode rip = null; // row iterator preview

        boolean update = false;
        SparseNode newnode = null;
        
        // bind column
        ci = head; // col iterator
        cip = null; // col iterator preview
        while (ci!=null) {
            if (ci.col == col) {
                // search row
                ri = ci; // row iterator
                rip = null; // row iterator preview
                while (ri!=null) {
                    if (ri.row == row) {                        
                        // update
                        ri.data = data;
                        update = true;
                        break;
                    } else if (ri.row > row) {
                        // add at middle
                        newnode = new SparseNode(data, row, col);
                        newnode.up = rip;
                        newnode.down = ri;
                        rip.down = newnode;
                        ri.up = newnode;
                        if (col==0) update = true;
                        break;
                    } else if (ri.down == null) {
                        // add at end
                        newnode = new SparseNode(data, row, col);
                        newnode.up = ri;
                        ri.down = newnode;
                        if (col==0) update = true;
                        break;
                    }
                    rip = ri;
                    ri = ri.down;
                }
                break;
            } else if (ci.col > col) {
                // add at middle
                if (row == 0) {
                    newnode = new SparseNode(data, row, col);
                    newnode.left = cip;
                    newnode.right = ci;
                    cip.right = newnode;
                    ci.left = newnode;
                    update = true;  
                } else {
                    SparseNode tmp = new SparseNode("XX", 0, col);
                    tmp.left = cip;
                    tmp.right = ci;
                    cip.right = tmp;
                    ci.left = tmp;
                    newnode = new SparseNode(data, row, col);
                    tmp.down = newnode;
                    newnode.up = tmp;                                    
                }
                break;
            } else if (ci.right == null) {
                // add at end
                if (row == 0) {
                    newnode = new SparseNode(data, row, col);
                    newnode.left = ci;
                    ci.right = newnode;
                    update = true;
                } else {
                    SparseNode tmp = new SparseNode("XX", 0, col);
                    tmp.left = ci;
                    ci.right = tmp;
                    newnode = new SparseNode(data, row, col);
                    tmp.down = newnode;
                    newnode.up = tmp;
                }
                break;
            }            
            cip = ci;
            ci = ci.right;
        }

        // bind row        
        if (!update) {
            ri = head; // col iterator
            rip = null; // col iterator preview
            while (ri!=null) {
                if (ri.row == row) {
                    // search col
                    ci = ri; // col iterator
                    cip = null; // col iterator preview
                    while (ci!=null) {
                        if (ci.col > col) {
                            // add at middle                            
                            newnode.left = cip;
                            newnode.right = ci;
                            cip.right = newnode;
                            ci.left = newnode;
                            break;
                        } else if (ci.right == null) {
                            // add at end
                            newnode.left = ci;
                            ci.right = newnode;
                            break;
                        }
                        cip = ci;
                        ci = ci.right;
                    }
                    break;
                } else if (ri.row > row) {
                    // add at middle
                    if (col == 0) {
                        newnode.up = cip;
                        newnode.down = ci;
                        cip.down = newnode;
                        ci.up = newnode;
                    } else {
                        SparseNode tmp = new SparseNode("XX", row, 0);
                        tmp.up = cip;
                        tmp.down = ci;
                        cip.down = tmp;
                        ci.up = tmp;
                        // newnode bind
                        tmp.right = newnode;
                        newnode.left = tmp;    
                    }
                    break;
                } else if (ri.down == null) {
                    // add at end
                    if (col == 0) {
                        newnode.up = cip;
                        newnode.down = ci;
                        cip.down = newnode;
                        ci.up = newnode;
                    } else {
                        SparseNode tmp = new SparseNode("XX", row, 0);
                        tmp.up = ri;
                        ri.down = tmp;
                        //newnode bind
                        tmp.right = newnode;
                        newnode.left = tmp;
                    }
                    break;
                }
                rip = ri;
                ri = ri.down;
            }    
        }
    }
    
    void printRef(int dim) {
        SparseNode r, c;
        r = head;
        for (int i = 0; i < dim; i++) {
            if (r!=null) {
                if (r.col == i) {
                    c = r;
                    for (int j = 0; j < dim; j++) {                        
                        if (c != null) {
                            if (c.row == j) {
                                System.out.print(c.data+" ");
                                c = c.down;
                            } else System.out.print("   "); 
                        } else System.out.print("   "); 
                    }
                    r = r.right;            
                } else { 
                    for (int j = 0; j < dim; j++) {
                        System.out.print("   ");
                    }
                }                
            } else { 
                for (int j = 0; j < dim; j++) {
                    System.out.print("   ");
                }
            }
            System.out.println();            
        }

    }
    
    Matriz Nuevo(Matriz nuevo,int dim){
        SparseNode r, c;
        r = head;
        for (int i = 0; i < dim; i++) {
            if (r!=null) {
                if (r.row == i) {
                    c = r;
                    for (int j = 0; j < dim; j++) {                        
                        if (c != null) {
                            if (c.col == j) {
                                if(!c.data.equals("XX")){
                                    nuevo.add(c.data, c.row, c.col);
                                }
                                c = c.right;
                            }
                        }
                    }
                    r = r.down;            
                }                
            }
        }
        return nuevo;
    }
    
    public void Graphviz(int dimx,int dimy,String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
        capa = new FileWriter(name+".dot");
        pw = new PrintWriter(capa);
        
        pw.println("digraph G {");
        pw.println("node [shape=box]");
        
        pw.println(" Mt[ label = \"\", group = 0 ];");
        pw.println("e0[ shape = point, width = 0 ];\n" +
                   "e1[ shape = point, width = 0 ];");
        
        String fila="", columna = "";
        String enlaceF="Mt -> F1[dir = \"both\"];\n", enlaceC = "rank = same{ Mt -> C1[dir = \"both\"]};\n";
        for (int i = 1; i < dimx+1; i++) {
            columna+="C"+i+"[ label = \"\", group = "+i+"];\n";
            if((i+1)<dimx+1){
                enlaceC+="rank = same{ C"+i+" -> C"+(i+1)+"[dir = \"both\"]};\n";
            }
        }
        for (int i = 1; i < dimy+1; i++) {
            fila+="F"+i+"[ label = \"\", group = 0];\n";
            if((i+1)<dimy+1){
                enlaceF+="F"+i+" -> F"+(i+1)+"[dir = \"both\"];\n";
            }
        }
        pw.println(fila);
        pw.println(enlaceF);
        pw.println(columna);
        pw.println(enlaceC);
        
        String nodos="",enlaceFC="";
        SparseNode r, c;
        r = head;
        while(r!=null){
            c=r;
            while(c!=null){
                if(!c.data.equals("XX")){
                    nodos+="NF"+c.col+"C"+c.row+"[ label = \"\", style = filled, fillcolor = \""+c.data+"\",group = "+c.row+"];\n";
                }
                c = c.down;
            }
            r = r.right;  
        }
        
        r = head;
        for (int i = 0; i < dimy+1; i++) {
            if (r!=null) {
                if (r.col == i) {
                    c = r;
                    for (int j = 0; j < dimx+1; j++) {                        
                        if (c != null) {
                            if (c.row == j) {
                                if(!c.data.equals("XX") && (c.left != null && c.up != null)){
                                    if((c.left.data.equals("XX") && c.up.data.equals("XX")) ){
                                        enlaceFC+="rank = same{ F"+c.col+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"]};\n";
                                        enlaceFC+="C"+c.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"];\n";
                                    }else if(c.left.data.equals("XX")  && !c.up.data.equals("XX")){
                                        enlaceFC+="rank = same{ NF"+c.up.col+"C"+c.up.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"]};\n";
                                        enlaceFC+="C"+c.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"];\n";
                                    }else if(!c.left.data.equals("XX")  &&c.up.data.equals("XX")){
                                        enlaceFC+="rank = same{ F"+c.col+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"]};\n";
                                        enlaceFC+="NF"+c.left.col+"C"+c.left.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"];\n";
                                    }else{
                                        enlaceFC+="rank = same{ NF"+c.up.col+"C"+c.up.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"]};\n";
                                        enlaceFC+="NF"+c.left.col+"C"+c.left.row+" -> "+"NF"+c.col+"C"+c.row+"[dir = \"both\"];\n";
                                    }
                                }
                                c = c.down;
                            }
                        }
                    }
                    r = r.right;            
                }                
            }            
        }
        pw.println(nodos);
        pw.println(enlaceFC);
        
        pw.println("}");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+".png",name+".dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    public void imagen_png(int dimx,int dimy,String name){
        FileWriter capa = null;
        PrintWriter pw = null;
        try{
        capa = new FileWriter(name+"HD.dot");
        pw = new PrintWriter(capa);
        
        pw.println("digraph G {");
        pw.println("a0 [label=< \n <TABLE cellspacing=\"0\" cellpadding=\"10\">");
        
        String contenido="";
        SparseNode r, c;
        r = head;
        for (int i = 0; i < dimy+1; i++) {
            if (r!=null) {
                if (r.col == i) {
                    c = r;
                    contenido+="<TR>";
                    for (int j = 0; j < dimx+1; j++) {                        
                        if (c != null) {
                            if (c.row == j) {
                                if(!c.data.equals("XX")){
                                    contenido+="<TD bgcolor=\""+c.data.toString()+"\"></TD>\n";
                                }else{
                                    contenido+="<TD bgcolor=\"#ffffff\"></TD>\n";
                                }
                                c = c.down;
                            } else contenido+="<TD bgcolor=\"#ffffff\"></TD>\n"; 
                        } else contenido+="<TD bgcolor=\"#ffffff\"></TD>\n"; 
                    }
                    r = r.right;            
                } else { 
                    contenido+="<TR>";
                    for (int j = 0; j < dimx+1; j++) {
                        contenido+="<TD bgcolor=\"#ffffff\"></TD>\n";
                    }
                }                
            } else { 
                contenido+="<TR>";
                for (int j = 0; j < dimx+1; j++) {
                    contenido+="<TD bgcolor=\"#ffffff\"></TD>\n";
                }
            }
            contenido+="</TR>";            
        }
        contenido+="</TABLE>>][color=white]";
        pw.println(contenido);
        pw.println("}");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{       
                if(null != capa){
                    capa.close();
                    ProcessBuilder buil = new ProcessBuilder("dot","-Tpng","-o",name+"HD.png",name+"HD.dot");
                    buil.redirectErrorStream(true);
                    buil.start();           
                }
        }catch(Exception e2){
        e2.printStackTrace();
        }
        }
    }
    
    
}
