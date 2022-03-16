
package edd.proyecto1_fase2;

public class EDDProyecto1_fase2 {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                 new Register().setVisible(true);
                 new admin().setVisible(true);
                 new cliente().setVisible(true);
            }
        });
        
    }
    
}
