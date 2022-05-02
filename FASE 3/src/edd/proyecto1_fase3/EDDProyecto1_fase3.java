
package edd.proyecto1_fase3;

public class EDDProyecto1_fase3 {

    static Lista CLIENTES = new Lista();
    static TablaHash MENSAJEROS = new TablaHash();
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
        
    }
    
    
    public static void AgregarCliente(Clientes c){
        CLIENTES.append(c);
    }
     
    public static void AgregarMensajero(Mensajero m){
        MENSAJEROS.add(m);
    }
}
