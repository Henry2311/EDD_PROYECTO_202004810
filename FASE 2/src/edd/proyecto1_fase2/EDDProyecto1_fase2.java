
package edd.proyecto1_fase2;

public class EDDProyecto1_fase2 {

    static Arbol_B CLIENTES = new Arbol_B();
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
    public static void AgregarCliente(Clientes c){
        CLIENTES.insert(c.getDpi(), c);
    }


}


    
