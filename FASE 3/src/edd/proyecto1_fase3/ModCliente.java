
package edd.proyecto1_fase3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ModCliente extends javax.swing.JFrame {

    
    static Clientes c;
    
    public ModCliente(Clientes c) {
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        info();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Modulo Cliente: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Modulo Cliente: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Sucursal");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jLabel4.setText("Destino");

        jLabel5.setText("Mensajero");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jButton1.setText("Enviar solicitud");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fecha: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Grafo recorrido = new Grafo(EDDProyecto1_fase3.LUGARES.size());
        
        Lista.Nodo aux = EDDProyecto1_fase3.LUGARES.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            recorrido.añadirVertices(data.nombre);
            aux = aux.next;
        }
        
        Lista.Nodo auxR = EDDProyecto1_fase3.RUTA.first;
        while(auxR != null){
            String r = (String) auxR.data;
            String arr [] = r.split(",");
            recorrido.añadirVecino(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
            auxR = auxR.next;
        }

        String sucursal=(String) this.jComboBox1.getSelectedItem();
        String destino = this.jTextField1.getText();
        String mensajero = (String) this.jComboBox2.getSelectedItem();
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        
        String aux_s [] = sucursal.split(",");
        String aux_d [] = destino.split(",");
        String aux_m [] = mensajero.split("|");
        
        Mensajero m = EDDProyecto1_fase3.MENSAJEROS.getMensajero(Integer.parseInt(aux_m[0]));
        
        String ruta []= recorrido.dijkStra(EDDProyecto1_fase3.LUGARES.getId_lugar(aux_s[0])-1,aux_d[0]);
        System.out.println("Ruta optima "+ruta[0]+" Tiempo: "+ruta[1]+" min");
        System.out.println("Mensajero: "+m.nombre+" "+m.apellido);
        System.out.println("Fecha: "+fecha);
        
        String r [] = ruta[0].split(",");
        Lista graficar_ruta = new Lista();
        for (String r1 : r) {
            graficar_ruta.append(r1);
        }
        graficar_ruta.recorrido(this.c.user);
        viajes nuevo_viaje = new viajes(graficar_ruta,Integer.parseInt(ruta[1]));
        EDDProyecto1_fase3.AgregarViaje(nuevo_viaje);
        this.c.addPedido(1);
        EDDProyecto1_fase3.MENSAJEROS.añadirPedido(Integer.parseInt(aux_m[0]), 1);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void info(){
        this.jLabel1.setText("Nombre: "+this.c.getName());
        this.jLabel2.setText("DPI: "+this.c.getDpi()+"    User: "+this.c.getUser());
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        this.jLabel6.setText("Fecha: "+fecha);
        
        Lista lugares = EDDProyecto1_fase3.LUGARES;
        
        Lista.Nodo aux = lugares.first;
        
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            this.jComboBox1.addItem(data.getNombre()+", "+data.getDepartamento());
            aux = aux.next;
        }
        
        aux = lugares.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == this.c.getId_municipio()){
                this.jTextField1.setText(data.nombre+", "+data.departamento);
                break;
            }
            aux = aux.next;
        }
        
        TablaHash mensajeros = EDDProyecto1_fase3.MENSAJEROS;
        Mensajero arr [] = mensajeros.getTabla();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                this.jComboBox2.addItem(i+"|"+arr[i].nombre + " " + arr[i].apellido);
            }
        }
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
