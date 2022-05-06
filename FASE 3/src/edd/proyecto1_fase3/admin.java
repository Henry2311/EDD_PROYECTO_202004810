/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_fase3;



import at.favre.lib.crypto.bcrypt.BCrypt;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class admin extends javax.swing.JFrame {
    
    static Lista datosM = new Lista();
    static Lista datosMensajeros = new Lista();
    
    public admin() {
        initComponents();
        setLocationRelativeTo(null);
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "DPI", "User", "Password", "Correo", "Telefono", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Carga Masiva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Usuarios");

        jButton4.setText("Insertar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar Sesión");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(299, 299, 299)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addComponent(jButton5))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carga de Usuarios", jPanel1);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Listado de Mensajeros");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Dpi", "Licencia", "Genero", "Telefono", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jScrollPane2.setViewportView(jTable2);

        jButton6.setText("Carga Masiva");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("Mostrar hash");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cargar lugares");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Cargar rutas");
        jButton11.setToolTipText("");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel4)
                .addContainerGap(349, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carga de Mensajeros", jPanel2);

        jLabel2.setText(".");
        jScrollPane3.setViewportView(jLabel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Estructuras: ");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Tabla Hash", "Grafo", "Matriz Adyacente", "Blockchain", "Clientes" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Reportes");

        jComboBox2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Top viajes", "Top clientes", "Top Mensajeros" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel3);
        jPanel3.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(this, "Añadir actualizar");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FileReader fr = null;
        try {
            // TODO add your handling code here:
            String file="";
            File archivo=null;
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivo = fc.getSelectedFile();
            }
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                file += "\n"+linea;
            }
            JsonParser parser = new JsonParser();
            JsonArray clientes = parser.parse(file).getAsJsonArray();
            
            for(int i=0;i<clientes.size();i++){
                JsonObject c = clientes.get(i).getAsJsonObject();
                String n = c.get("dpi").getAsString();
                Long Ln = new Long(Long.parseLong(n));
                
                String aux_c = c.get("contrasenia").getAsString();
                String contraseña = BCrypt.withDefaults().hashToString(12, aux_c.toCharArray());
                
                Clientes nuevo = new Clientes(Ln,
                                              c.get("id_municipio").getAsInt(),
                                              c.get("nombre_completo").getAsString(),
                                              contraseña,
                                              c.get("nombre_usuario").getAsString(),
                                              c.get("correo").getAsString(),
                                              c.get("telefono").getAsString(),
                                              c.get("direccion").getAsString());
                EDDProyecto1_fase3.AgregarCliente(nuevo);
                datosM.append(nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han cargado los clientes correctamente");
            actualizarTabla();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Register(true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        FileReader fr = null;
        try {
            // TODO add your handling code here:
            String file="";
            File archivo=null;
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivo = fc.getSelectedFile();
            }
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                file += "\n"+linea;
            }
            JsonParser parser = new JsonParser();
            JsonArray mensajeros = parser.parse(file).getAsJsonArray();
            System.out.println(mensajeros);
            for(int i=0;i<mensajeros.size();i++){
                JsonObject c = mensajeros.get(i).getAsJsonObject();
                
                String n = c.get("dpi").getAsString();
                n = n.replaceAll(" ", "");
                Long Ln = Long.parseLong(n);
                Mensajero nuevo = new Mensajero(Ln,c.get("nombres").getAsString(),
                                              c.get("apellidos").getAsString(),
                                              c.get("tipo_licencia").getAsString(),
                                              c.get("genero").getAsString(),
                                              c.get("telefono").getAsString(),
                                              c.get("direccion").getAsString());
                EDDProyecto1_fase3.AgregarMensajero(nuevo);
                datosMensajeros.append(nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han cargado los mensajeros correctamente");
            actualizarTablaM();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        EDDProyecto1_fase3.MENSAJEROS.graph();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        EDDProyecto1_fase3.MENSAJEROS.mostrar();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FileReader fr = null;
        try {
            // TODO add your handling code here:
            String file="";
            File archivo=null;
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivo = fc.getSelectedFile();
            }
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                file += "\n"+linea;
            }
            JsonParser parser = new JsonParser();
            JsonObject Lugares = parser.parse(file).getAsJsonObject();
            System.out.println(Lugares);
            JsonArray lugar = Lugares.get("Lugares").getAsJsonArray();
            for(int i=0;i<lugar.size();i++){
                JsonObject c = lugar.get(i).getAsJsonObject();
                
                Lugar nuevo = new Lugar(c.get("id").getAsInt(),
                                        c.get("departamento").getAsString(),
                                        c.get("nombre").getAsString(),
                                        c.get("sn_sucursal").getAsString());
                
                EDDProyecto1_fase3.AgregarLugar(nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han cargado los lugares correctamente");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        FileReader fr = null;
        try {
            if(EDDProyecto1_fase3.LUGARES.size() > 0){
                // TODO add your handling code here:
                String file="";
                File archivo=null;
                JFileChooser fc = new JFileChooser();
                int op = fc.showOpenDialog(this);
                if (op == JFileChooser.APPROVE_OPTION) {
                    archivo = fc.getSelectedFile();
                }
                fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    file += "\n"+linea;
                }
                JsonParser parser = new JsonParser();
                JsonObject Rutas = parser.parse(file).getAsJsonObject();
                System.out.println(Rutas);
                JsonArray ruta = Rutas.get("Grafo").getAsJsonArray();
                for(int i=0;i<ruta.size();i++){
                    JsonObject c = ruta.get(i).getAsJsonObject();
                    int inicio = c.get("inicio").getAsInt();
                    vecino nuevo = new vecino(c.get("peso").getAsInt(),
                                            c.get("final").getAsInt());

                    EDDProyecto1_fase3.AgregarRuta(inicio,nuevo);
                }
                JOptionPane.showMessageDialog(this, "Se han cargado las rutas correctamente");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        EDDProyecto1_fase3.LUGARES.graficar();
        EDDProyecto1_fase3.LUGARES.grafo_nodirigido();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        String option = (String) this.jComboBox1.getSelectedItem();
        
        switch (option) {
            case "Tabla Hash":
                {
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TablaHash.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Grafo":
                {
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("GrafoNoDirigido.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Matriz Adyacente":
                {
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TablaAdyacencia.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Blockchan":
                {
                    System.out.println("PENDIENTE");
                    break;
                }
            case "Clientes":
                {
                    EDDProyecto1_fase3.CLIENTES.Tabla_Clientes();
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TablaClientes.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        String option = (String) this.jComboBox2.getSelectedItem();
        
        switch (option) {
            case "Top viajes":
                {
                    EDDProyecto1_fase3.VIAJES.TopViajes();
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TopViajes.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Grafo":
                {
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("GrafoNoDirigido.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Matriz Adyacente":
                {
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TablaAdyacencia.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            case "Blockchan":
                {
                    System.out.println("PENDIENTE");
                    break;
                }
            case "Clientes":
                {
                    EDDProyecto1_fase3.CLIENTES.Tabla_Clientes();
                    JOptionPane.showMessageDialog(this, "Se ha creado la imagen correctamente");
                    ImageIcon img = new ImageIcon("TablaClientes.png");
                    this.jLabel2.setIcon(img);
                    break;
                }
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public void actualizarTabla(){
        if(datosM.size()!=0){
            Object datos [][] = new Object[datosM.size()][7];   

            Lista.Nodo aux = datosM.first;
            int i = 0;
            while(aux!=null){
                Clientes data = (Clientes) aux.data;
                datos[i][0] = data.getName();
                datos[i][1] = data.getDpi();
                datos[i][2] = data.getUser();
                datos[i][3] = data.getPassword();
                datos[i][4] = data.getCorreo();
                datos[i][5] = data.getTelefono();
                datos[i][6] = data.getDireccion();
                
                i++;
                aux = aux.next;
            }
            this.jTable1.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String [] {
                    "Nombre", "DPI", "User", "Password","Correo","Telefono","Direccion"
                }
                ));
        }
    }
    
    public void actualizarTablaM(){
        if(datosMensajeros.size()!=0){
            Object datos [][] = new Object[datosMensajeros.size()][7];   

            Lista.Nodo aux = datosMensajeros.first;
            int i = 0;
            while(aux!=null){
                Mensajero data = (Mensajero) aux.data;
                datos[i][0] = data.getNombre();
                datos[i][1] = data.getApellido();
                datos[i][2] = data.getDpi();
                datos[i][3] = data.getLicencia();
                datos[i][4] = data.getGenero();
                datos[i][5] = data.getTelefono();
                datos[i][6] = data.getDireccion();
                
                i++;
                aux = aux.next;
            }
            this.jTable2.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String [] {
                    "Nombre", "Apellido", "DPI", "Licencia","Genero","Telefono","Direccion"
                }
                ));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
