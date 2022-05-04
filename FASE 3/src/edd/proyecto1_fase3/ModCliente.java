
package edd.proyecto1_fase3;

import java.util.ArrayList;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modulo Cliente: ");

        jLabel2.setText("Modulo Cliente: ");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
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
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ruta_optimizada(1,6);
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void ruta_optimizada(int inicio, int fin){
        Lista lugares = EDDProyecto1_fase3.LUGARES;
        ArrayList <vecino> ruta = new ArrayList<>();
        Lista adyacente = new Lista();
        
        int peso = 0;
        Lista.Nodo aux = lugares.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            if(data.id == inicio){
                adyacente = data.Rutas;
                break;
            }
            aux = aux.next;
        }
        
        vecino v1 = new vecino(peso,inicio,adyacente);
        boolean exit = false;
        while(!exit){
            Lista.Nodo ady = adyacente.first;
            
            aux = lugares.first;
            while(aux!=null){
                Lugar data = (Lugar) aux.data;
                vecino temp = (vecino) ady.data; //produccion
                if(data.id == temp.id){
                    System.out.println("ENTRE primer if");
                    if(!data.visitado){
                        System.out.println("entre");
                        adyacente = v1.ady;
                        vecino nuevo  = new vecino(temp.peso+v1.peso,temp.id,adyacente);
                        ruta.add(nuevo);//lista temporal
                        data.visitado = true;
                        v1.anterior = temp;
                        break;
                    }
                }
                aux = aux.next;
            }
            
            //ordenar
            for (int i = 0; i < ruta.size(); i++) {
                for (int j = 0; j < ruta.size()- 1; j++) {
                    vecino actual = ruta.get(j),
                           siguiente = ruta.get(j+1);
                    if (ruta.get(j).peso > ruta.get(j+1).peso) {
                        ruta.remove(j+1);
                        ruta.add(j,siguiente);
                    }
                }
            }
            v1 = ruta.get(0);
            ruta.remove(0);
            if(v1.id == fin){
                exit=true;
            }
 
        }
        
        //actualizar visitado
        aux = lugares.first;
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            data.visitado = false;
            aux = aux.next;
        }
        //lista de ruta desde v1 por el anterior
        while(v1!=null){
            System.out.println(v1.id);
            v1=v1.anterior;
        }
    }

    
    
    public void info(){
        this.jLabel1.setText("Nombre: "+this.c.getName());
        this.jLabel2.setText("DPI: "+this.c.getDpi()+"    User: "+this.c.getUser());
        
        Lista lugares = EDDProyecto1_fase3.LUGARES;
        
        Lista.Nodo aux = lugares.first;
        
        while(aux!=null){
            Lugar data = (Lugar) aux.data;
            this.jComboBox1.addItem(data.getNombre()+" | "+data.getDepartamento());
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
        
        for (Mensajero arr1 : arr) {
            if (arr1 != null) {
                this.jComboBox2.addItem(arr1.nombre + " " + arr1.apellido);
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
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
