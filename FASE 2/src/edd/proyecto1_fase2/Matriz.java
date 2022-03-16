
package edd.proyecto1_fase2;

public class Matriz {
    Nodo head;
    
    class Nodo {
    Object data;
    int row, col;
    Nodo up,down,right,left;

    public Nodo(Object data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
        up = down = right = left = null;
    }
    }
    public Matriz() {
        head = new Nodo("XX", 0, 0);
    }

    void add(Object data, int row, int col) {        
        Nodo ci = null,cip = null,ri = null,rip = null;

        boolean update = false;
        Nodo newnode = null;
        
        ci = head; 
        cip = null; 
        while (ci!=null) {
            if (ci.col == col) {
                ri = ci; 
                rip = null; 
                while (ri!=null) {
                    if (ri.row == row) {      
                        ri.data = data;
                        update = true;
                        break;
                    } else if (ri.row > row) {
                        newnode = new Nodo(data, row, col);
                        newnode.up = rip;
                        newnode.down = ri;
                        rip.down = newnode;
                        ri.up = newnode;
                        if (col==0) update = true;
                        break;
                    } else if (ri.down == null) {
                        newnode = new Nodo(data, row, col);
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
                if (row == 0) {
                    newnode = new Nodo(data, row, col);
                    newnode.left = cip;
                    newnode.right = ci;
                    cip.right = newnode;
                    ci.left = newnode;
                    update = true;  
                } else {
                    Nodo tmp = new Nodo("--", 0, col);
                    tmp.left = cip;
                    tmp.right = ci;
                    cip.right = tmp;
                    ci.left = tmp;
                    newnode = new Nodo(data, row, col);
                    tmp.down = newnode;
                    newnode.up = tmp;                                    
                }
                break;
            } else if (ci.right == null) {
                if (row == 0) {
                    newnode = new Nodo(data, row, col);
                    newnode.left = ci;
                    ci.right = newnode;
                    update = true;
                } else {
                    Nodo tmp = new Nodo("--", 0, col);
                    tmp.left = ci;
                    ci.right = tmp;
                    newnode = new Nodo(data, row, col);
                    tmp.down = newnode;
                    newnode.up = tmp;
                }
                break;
            }            
            cip = ci;
            ci = ci.right;
        }
       
        if (!update) {
            ri = head; 
            rip = null; 
            while (ri!=null) {
                if (ri.row == row) {
                    ci = ri; 
                    cip = null; 
                    while (ci!=null) {
                        if (ci.col > col) {                            
                            newnode.left = cip;
                            newnode.right = ci;
                            cip.right = newnode;
                            ci.left = newnode;
                            break;
                        } else if (ci.right == null) {
                            newnode.left = ci;
                            ci.right = newnode;
                            break;
                        }
                        cip = ci;
                        ci = ci.right;
                    }
                    break;
                } else if (ri.row > row) {
                    if (col == 0) {
                        newnode.up = cip;
                        newnode.down = ci;
                        cip.down = newnode;
                        ci.up = newnode;
                    } else {
                        Nodo tmp = new Nodo("--", row, 0);
                        tmp.up = cip;
                        tmp.down = ci;
                        cip.down = tmp;
                        ci.up = tmp;
                        tmp.right = newnode;
                        newnode.left = tmp;    
                    }
                    break;
                } else if (ri.down == null) {
                    if (col == 0) {
                        newnode.up = cip;
                        newnode.down = ci;
                        cip.down = newnode;
                        ci.up = newnode;
                    } else {
                        Nodo tmp = new Nodo("--", row, 0);
                        tmp.up = ri;
                        ri.down = tmp;
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
        Nodo r, c;
        r = head;
        for (int i = 0; i < dim; i++) {
            if (r!=null) {
                if (r.row == i) {
                    c = r;
                    for (int j = 0; j < dim; j++) {                        
                        if (c != null) {
                            if (c.col == j) {
                                System.out.print(c.data+" ");
                                c = c.right;
                            } else System.out.print("-- "); // empty col at middle
                        } else System.out.print("-- "); // empty col at end
                    }
                    r = r.down;            
                } else { // empty row at middle
                    for (int j = 0; j < dim; j++) {
                        System.out.print("-- ");
                    }
    
                }                
            } else { //empty row at end
                for (int j = 0; j < dim; j++) {
                    System.out.print("-- ");
                }
            }
            System.out.println();            
        }

    }

}
