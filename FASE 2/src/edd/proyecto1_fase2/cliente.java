/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_fase2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author hrmen
 */
public class cliente extends javax.swing.JFrame {

    
    static Clientes c;
    
    public cliente(Clientes c) {
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        info();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar Capas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cargar Imagenes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Albumes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Preorder", "Inorder", "Postorder", "Por Arbol", "Por Capa" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Generar Imagen: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Recorrido: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("...");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Ver imagen");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Nombre: ");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("DPI: ");

        jLabel6.setText(".");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Imagen Lógica", jPanel6);

        jLabel12.setText(".");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Imagen HD", jPanel5);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addGap(322, 322, 322)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Imagenes", jPanel1);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Reportes");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Arbol de capas", "Arbol de Imagenes", "Arbol de capas por imagen", "Lista de albums", "Buscar capa" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Estructuras");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Top 5", "Capas hoja", "Profundidad de Arbol", "Recorrido" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel11.setText(".");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel2);

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String option = (String) this.jComboBox1.getSelectedItem();
        
        switch (option) {
            case "Preorder":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese el limite del recorrido","Limite",JOptionPane.INFORMATION_MESSAGE));
                    String preorder = this.c.abb.preorder(this.c.abb.root, "");
                    this.jLabel4.setText(preorder);
                    preorder = preorder.substring(0, id+(id-1));
                    String capas [] = preorder.split(",");
                    MatrizOrtogonal imagen = new MatrizOrtogonal();
                    Arbol_ABB arb = new Arbol_ABB();
                    int x = 0, y = 0;
                    for (int i = 0; i < capas.length; i++) {
                        Arbol_ABB.Nodo capaxd = this.c.abb.search(Integer.parseInt(capas[i]));
                        capa aux_c = capaxd.id;
                        
                        SparseNode r = aux_c.pixeles.head;
                        if(aux_c.x>x){
                            x=aux_c.x;
                        }
                        if(aux_c.y>y){
                            y=aux_c.y;
                        }

                        while(r!=null){
                            SparseNode col=r;
                            while(col!=null){
                                if(!col.data.equals("XX")){
                                    imagen.insertar(col.col, col.row, col.data.toString());
                                }
                                col = col.right;
                            }
                            r = r.down;  
                        }
                        arb.agregar(capaxd.valor, aux_c);
                    }
                    int id_imagen = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese un ID nuevo a la imagen","Registrar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo tmp = this.c.avl.search(id_imagen);
                    
                    if(tmp == null){
                        top_img top_n = new top_img("IMG"+id_imagen,capas.length);
                        this.c.top.append(top_n);

                        this.jComboBox2.addItem("IMG"+id_imagen);
                        imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                        this.c.avl.add(nuevo.id,nuevo);
                        JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    }else{
                        JOptionPane.showMessageDialog(this, "ID en uso, ingrese un ID diferente");
                    }
                    break;
                }
            case "Inorder":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese el limite del recorrido","LImite",JOptionPane.INFORMATION_MESSAGE));
                    String preorder = this.c.abb.inorden(this.c.abb.root, "");
                    this.jLabel4.setText(preorder);
                    preorder = preorder.substring(0, id+(id-1));
                    String capas [] = preorder.split(",");
                    MatrizOrtogonal imagen = new MatrizOrtogonal();
                    Arbol_ABB arb = new Arbol_ABB();
                    int x = 0, y = 0;
                    for (int i = 0; i < capas.length; i++) {
                        Arbol_ABB.Nodo capaxd = this.c.abb.search(Integer.parseInt(capas[i]));
                        capa aux_c = capaxd.id;
                        
                        SparseNode r = aux_c.pixeles.head;
                        if(aux_c.x>x){
                            x=aux_c.x;
                        }
                        if(aux_c.y>y){
                            y=aux_c.y;
                        }

                        while(r!=null){
                            SparseNode col=r;
                            while(col!=null){
                                if(!col.data.equals("XX")){
                                    imagen.insertar(col.col, col.row, col.data.toString());
                                }
                                col = col.right;
                            }
                            r = r.down;  
                        }
                        arb.agregar(capaxd.valor, aux_c);
                    }
                    int id_imagen = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese un ID nuevo a la imagen","Registrar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo tmp = this.c.avl.search(id_imagen);
                    
                    if(tmp == null){
                        top_img top_n = new top_img("IMG"+id_imagen,capas.length);
                        this.c.top.append(top_n);

                        this.jComboBox2.addItem("IMG"+id_imagen);
                        imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                        this.c.avl.add(nuevo.id,nuevo);
                        JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    }else{
                        JOptionPane.showMessageDialog(this, "ID en uso, ingrese un ID diferente");
                    }
                    break;
                }
            case "Postorder":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese el limite del recorrido","Limite",JOptionPane.INFORMATION_MESSAGE));
                    String preorder = this.c.abb.postorden(this.c.abb.root, "");
                    this.jLabel4.setText(preorder);
                    preorder = preorder.substring(0, id+(id-1));
                    String capas [] = preorder.split(",");
                    MatrizOrtogonal imagen = new MatrizOrtogonal();
                    Arbol_ABB arb = new Arbol_ABB();
                    int x = 0, y = 0;
                    for (int i = 0; i < capas.length; i++) {
                        Arbol_ABB.Nodo capaxd = this.c.abb.search(Integer.parseInt(capas[i]));
                        capa aux_c = capaxd.id;
                        
                        SparseNode r = aux_c.pixeles.head;
                        if(aux_c.x>x){
                            x=aux_c.x;
                        }
                        if(aux_c.y>y){
                            y=aux_c.y;
                        }

                        while(r!=null){
                            SparseNode col=r;
                            while(col!=null){
                                if(!col.data.equals("XX")){
                                    imagen.insertar(col.col, col.row, col.data.toString());
                                }
                                col = col.right;
                            }
                            r = r.down;  
                        }
                        arb.agregar(capaxd.valor, aux_c);
                    }
                    int id_imagen = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese un ID nuevo a la imagen","Registrar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo tmp = this.c.avl.search(id_imagen);
                    
                    if(tmp == null){
                        top_img top_n = new top_img("IMG"+id_imagen,capas.length);
                        this.c.top.append(top_n);

                        this.jComboBox2.addItem("IMG"+id_imagen);
                        imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                        this.c.avl.add(nuevo.id,nuevo);
                        JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    }else{
                        JOptionPane.showMessageDialog(this, "ID en uso, ingrese un ID diferente");
                    }
                    break;
                }
            case "Por Arbol":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese ID de la imagen","Buscar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo img = this.c.avl.search(id);
                    if(img != null){
                        int id_imagen = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese un ID nuevo a la imagen","Registrar",JOptionPane.INFORMATION_MESSAGE));
                        Arbol_AVL.Nodo tmp = this.c.avl.search(id_imagen);
                        if(tmp == null){
                            String capasI = img.img.arb.preorder(img.img.arb.root, "");
                            capasI = capasI.substring(0, capasI.length()-1);
                            String capas [] = capasI.split(",");
                            
                            MatrizOrtogonal imagen = new MatrizOrtogonal();
                            Arbol_ABB arb = new Arbol_ABB();
                            int x = 0, y = 0;
                            for (int i = 0; i < capas.length; i++) {
                                int tmp_id = Integer.parseInt(capas[i]);
                                Arbol_ABB.Nodo capaxd = this.c.abb.search(tmp_id);
                                capa aux_c = capaxd.id;

                                SparseNode r = aux_c.pixeles.head;
                                if(aux_c.x>x){
                                    x=aux_c.x;
                                }
                                if(aux_c.y>y){
                                    y=aux_c.y;
                                }

                                while(r!=null){
                                    SparseNode col=r;
                                    while(col!=null){
                                        if(!col.data.equals("XX")){
                                            imagen.insertar(col.col, col.row, col.data.toString());
                                        }
                                        col = col.right;
                                    }
                                    r = r.down;  
                                }
                                arb.agregar(capaxd.valor, aux_c);
                            }
                            
                            top_img top_n = new top_img("IMG"+id_imagen,capas.length);
                            this.c.top.append(top_n);

                            this.jComboBox2.addItem("IMG"+id_imagen);
                            imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                            imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                            imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                            this.c.avl.add(nuevo.id,nuevo);
                            JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                        }else{
                            JOptionPane.showMessageDialog(this, "ID en uso, ingrese un ID diferente");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Imagen no encontrada");
                    }
                    break;
                }
            case "Por Capa":
                {
                    String id = JOptionPane.showInputDialog(this,"Ingrese las capas a utilizar separadas por coma ","Buscar",JOptionPane.INFORMATION_MESSAGE);
                    String capas [] = id.split(",");
                    MatrizOrtogonal imagen = new MatrizOrtogonal();
                    Arbol_ABB arb = new Arbol_ABB();
                    int x = 0, y = 0;
                    for (int i = 0; i < capas.length; i++) {
                        Arbol_ABB.Nodo capaxd = this.c.abb.search(Integer.parseInt(capas[i]));
                        capa aux_c = capaxd.id;
                        
                        SparseNode r = aux_c.pixeles.head;
                        if(aux_c.x>x){
                            x=aux_c.x;
                        }
                        if(aux_c.y>y){
                            y=aux_c.y;
                        }

                        while(r!=null){
                            SparseNode col=r;
                            while(col!=null){
                                if(!col.data.equals("XX")){
                                    imagen.insertar(col.col, col.row, col.data.toString());
                                }
                                col = col.right;
                            }
                            r = r.down;  
                        }
                        arb.agregar(capaxd.valor, aux_c);
                    }
                    int id_imagen = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese un ID nuevo a la imagen","Registrar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo tmp = this.c.avl.search(id_imagen);
                    
                    if(tmp == null){
                        top_img top_n = new top_img("IMG"+id_imagen,capas.length);
                        this.c.top.append(top_n);

                        this.jComboBox2.addItem("IMG"+id_imagen);
                        imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                        imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                        this.c.avl.add(nuevo.id,nuevo);
                        JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    }else{
                        JOptionPane.showMessageDialog(this, "ID en uso, ingrese un ID diferente");
                    }                   
                }
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        FileReader fr = null;
        try {
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
            JsonArray capas = parser.parse(file).getAsJsonArray();
            
            for(int i=0;i<capas.size();i++){
                JsonObject cap = capas.get(i).getAsJsonObject();
                int id_capa = cap.get("id_capa").getAsInt();
                JsonArray pixel = cap.get("pixeles").getAsJsonArray();
                Matriz pixeles = new Matriz();
                int fila,columna;
                String color;
                int x = 0, y=0; 
                for (int j = 0; j < pixel.size(); j++) {
                    JsonObject pxl = pixel.get(j).getAsJsonObject();
                    fila = pxl.get("fila").getAsInt()+1;
                    columna = pxl.get("columna").getAsInt()+1;
                    color = pxl.get("color").getAsString();
                    
                    if(columna>x){
                        x=columna;
                    }
                    if(fila>y){
                        y=fila;
                    }
                    pixeles.add(color, columna, fila);
                }
                capa nuevo = new capa(id_capa,pixeles,x,y);
                this.c.abb.agregar(nuevo.id, nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han cargado las capas correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FileReader fr = null;
        try {
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
            JsonArray imagenes = parser.parse(file).getAsJsonArray();
            
            for(int i=0;i<imagenes.size();i++){
                JsonObject cap = imagenes.get(i).getAsJsonObject();
                int id_imagen = cap.get("id").getAsInt();
                JsonArray capas = cap.get("capas").getAsJsonArray();
                MatrizOrtogonal imagen = new MatrizOrtogonal();
                Arbol_ABB arb = new Arbol_ABB();
                
                int x = 0, y = 0;
                for (int j = 0; j < capas.size(); j++) {
                    int id = capas.get(j).getAsInt();
                    Arbol_ABB.Nodo capaxd = this.c.abb.search(id);
                    capa aux_c = capaxd.id;
                    
                    SparseNode r = aux_c.pixeles.head;
                    if(aux_c.x>x){
                        x=aux_c.x;
                    }
                    if(aux_c.y>y){
                        y=aux_c.y;
                    }
                    
                    while(r!=null){
                        SparseNode col=r;
                        while(col!=null){
                            if(!col.data.equals("XX")){
                                imagen.insertar(col.col, col.row,col.data.toString());
                            }
                            col = col.right;
                        }
                        r = r.down;  
                    }
                    arb.agregar(id, aux_c);
                    
                }
                
                top_img top_n = new top_img("IMG"+id_imagen,capas.size());
                this.c.top.append(top_n);
                
                this.jComboBox2.addItem("IMG"+id_imagen);
                imagen.Graphviz(x, y, this.c.getName()+"IMG"+id_imagen);
                imagen.imagen_png(x, y, this.c.getName()+"IMG"+id_imagen);
                imagen nuevo = new imagen(id_imagen,this.c.getName()+"IMG"+id_imagen+".png",arb);
                this.c.avl.add(nuevo.id,nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han generado las imagenes correctamente");
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

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String option = (String) this.jComboBox2.getSelectedItem();
        if(!option.equals("--")){
            ImageIcon img = new ImageIcon(this.c.getName()+option+".png");
            Image nuevo = img.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon render = new ImageIcon(nuevo);
            this.jLabel6.setIcon(render);
            
            ImageIcon img2 = new ImageIcon(this.c.getName()+option+"HD.png");
            Image nuevo2 = img2.getImage().getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon render2 = new ImageIcon(nuevo2);
            this.jLabel12.setIcon(render2);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String option = (String) this.jComboBox3.getSelectedItem();
        
        switch (option) {
            case "Lista de albums":
                {
                    this.c.Grafo_Albums();
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon(this.c.getName()+"Albums.png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Arbol de capas":
                {
                    this.c.abb.Graficar(this.c.name);
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon(this.c.getName()+"ABB.png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Arbol de Imagenes":
                {
                    this.c.avl.Graficar(this.c.name);
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon(this.c.getName()+"AVL.png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Arbol de capas por imagen":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese la imagen a buscar: ","Buscar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_AVL.Nodo aux = this.c.avl.search(id);
                    aux.img.arb.Graficar(this.c.name+"Capa"+aux.img.id);
                    JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    ImageIcon img = new ImageIcon(this.c.name+"Capa"+aux.img.id+"ABB.png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Buscar capa":
                {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese la capa a buscar: ","Buscar",JOptionPane.INFORMATION_MESSAGE));
                    Arbol_ABB.Nodo aux = this.c.abb.search(id);
                    capa tmp = aux.id;
                    tmp.pixeles.Graphviz(tmp.x, tmp.y, this.c.name+"Capa"+id+"Matriz");
                    JOptionPane.showMessageDialog(this, "Se ha generado la imagen");
                    ImageIcon img = new ImageIcon(this.c.name+"Capa"+id+"Matriz.png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            default:
                break;
        }
        
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       FileReader fr = null;
        try {
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
            JsonArray albums = parser.parse(file).getAsJsonArray();
            
            for(int i=0;i<albums.size();i++){
                JsonObject cap = albums.get(i).getAsJsonObject();
                String id_album = cap.get("nombre_album").getAsString();
                JsonArray imgs = cap.get("imgs").getAsJsonArray();
                Lista imagenes = new Lista();
                for (int j = 0; j < imgs.size(); j++) {
                    int id = imgs.get(j).getAsInt();
                    Arbol_AVL.Nodo img = this.c.avl.search(id);
                    if(img!=null){
                        imagenes.append("Imagen "+id);
                    }
                }
                
                album nuevo = new album(id_album,imagenes);
                this.c.album.append(nuevo);
            }
            JOptionPane.showMessageDialog(this, "Se han cargado las albumes correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        String option = (String) this.jComboBox4.getSelectedItem();
        
        switch (option) {
            case "Top 5":
                {
                    this.c.Top5();
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon("Top"+this.c.name+".png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Capas hoja":
                {
                    this.c.hojas();
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon("Hojas"+this.c.name+".png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Profundidad de Arbol":
                {
                    this.c.Profundidad();
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon("Profundidad"+this.c.name+".png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            case "Recorrido":
                {
                    this.c.Recorridos();
                    JOptionPane.showMessageDialog(this, "Se ha generado el reporte");
                    ImageIcon img = new ImageIcon("Recorridos"+this.c.name+".png");
                    Image nuevo = img.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.jLabel11.setIcon(render);
                    break;
                }
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String option = (String) this.jComboBox2.getSelectedItem();
        if(!option.equals("--")){
            option = option.replaceAll("IMG", "");
            int id = Integer.parseInt(option);
            this.c.avl.eliminar(id);
            int comboid = this.jComboBox2.getSelectedIndex();
            this.jComboBox2.removeItemAt(comboid);
            JOptionPane.showMessageDialog(this, "Se ha eliminado la imagen");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public void info(){
        this.jLabel7.setText("Nombre: "+this.c.getName());
        this.jLabel8.setText("DPI: "+this.c.getDpi());
        
        Lista Lista_aux = this.c.top;
        Lista.Nodo aux = Lista_aux.first;
        
        while(aux!=null){
            top_img data = (top_img) aux.data;
            this.jComboBox2.addItem(data.getNombre());
            aux = aux.next;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
