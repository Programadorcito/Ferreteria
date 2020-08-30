package FerreteriaGUI;

import FerreteriaDAO.ProductosDAO;
import FerreteriaEntityClass.CategoriaProducto;
import FerreteriaEntityClass.Productos;
import com.sun.glass.events.KeyEvent;
import java.math.BigInteger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;



public class ProductosGUI extends javax.swing.JFrame {
    
    private CategoriaProductoGUI cp = null;
    private ProductosDAO pjc = new ProductosDAO();
    private Productos producto = new Productos();
    private String mensaje = "";


    
    public ProductosGUI() {
        initComponents();
        
        this.setTitle("Formulario Productos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        holders();
        llenarComboBoxCategoria(ComboBoxCategoria);
    }
     
    
    public void holders(){ 
    }
    
    private void llenarComboBoxCategoria(JComboBox ComboBoxCategoria){
        pjc.getCategoriaProducto(ComboBoxCategoria);
    }
    
    private void inhabilitarProducto(String codigo) {
        pjc.inhabilitarProducto(codigo);
    }
    
    private void limpiarCampos() {
        textoCodigo.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoUnidadMedida.setText("");
        labelStock.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BotonCategoria = new javax.swing.JButton();
        ComboBoxCategoria = new javax.swing.JComboBox<>();
        textoNombre = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        textoUnidadMedida = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonInhabilitar = new javax.swing.JButton();
        BotonUpdate = new javax.swing.JButton();
        labelStock = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        categoria = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Product 64x64.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 70, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Stock:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Seleccione Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Codigo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        BotonCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Categoria 63x63.png"))); // NOI18N
        BotonCategoria.setBorder(null);
        BotonCategoria.setBorderPainted(false);
        BotonCategoria.setContentAreaFilled(false);
        BotonCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 50, 60));

        ComboBoxCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(ComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 260, 40));

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });
        jPanel1.add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 290, -1));

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Unidad de Medida:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(textoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 160, -1));

        textoUnidadMedida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoUnidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoUnidadMedidaKeyTyped(evt);
            }
        });
        jPanel1.add(textoUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 220, -1));

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        botonActualizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, -1));

        botonInhabilitar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonInhabilitar.setText("Inhabilitar");
        botonInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInhabilitarActionPerformed(evt);
            }
        });
        jPanel1.add(botonInhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, -1));

        BotonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Update 32x32.png"))); // NOI18N
        BotonUpdate.setBorder(null);
        BotonUpdate.setBorderPainted(false);
        BotonUpdate.setContentAreaFilled(false);
        BotonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(BotonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 50, 40));

        labelStock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 90, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("$");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Categoria:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, -1));

        categoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        categoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 230, 30));

        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textoPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(textoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 490));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUpdateActionPerformed
        ComboBoxCategoria.removeAllItems();
        llenarComboBoxCategoria(ComboBoxCategoria);
    }//GEN-LAST:event_BotonUpdateActionPerformed

    private void botonInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInhabilitarActionPerformed

        if((textoCodigo.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (textoUnidadMedida.getText().length()==0)||
            (labelStock.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Busque el cliente que desea inhabilitar");
        }else{
            inhabilitarProducto(textoCodigo.getText());
            JOptionPane.showMessageDialog(null, "Cliente inhabilitado");
            
            limpiarCampos();
        }  
    }//GEN-LAST:event_botonInhabilitarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if((textoCodigo.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (textoUnidadMedida.getText().length()==0)
        ){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            CategoriaProducto cp = (CategoriaProducto)ComboBoxCategoria.getSelectedItem();

            producto.setCodigo(textoCodigo.getText());
            producto.setNombre(textoNombre.getText());
            producto.setPrecio(BigInteger.ZERO);
            producto.setUnidadmedida(textoUnidadMedida.getText());
            producto.setCategoria(cp);
            producto.setEstado("On");
            try {
                    pjc.edit(producto);
                    mensaje = "Producto actualizado";
                    JOptionPane.showMessageDialog(null, "Producto actualizado");
                } catch (Exception e) {
                    System.out.println("Mensaje en actualizar: " + e.getMessage());
                    mensaje = "No se pudo actualizar la información. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la información. \n" + e.getMessage());
                }
            }
            limpiarCampos();
    
            
        
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed

        if((textoCodigo.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoUnidadMedida.getText().length()==0)
        ){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{

            CategoriaProducto cp = (CategoriaProducto)ComboBoxCategoria.getSelectedItem();

            producto.setCodigo(textoCodigo.getText());
            producto.setNombre(textoNombre.getText());
            producto.setPrecio(BigInteger.ZERO);
            producto.setUnidadmedida(textoUnidadMedida.getText());
            producto.setCategoria(cp);
            producto.setEstado("On");
            try {
                    pjc.create(producto);
                    mensaje = "Producto registrado";
                    JOptionPane.showMessageDialog(null, "Producto registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el producto. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el producto. \n" + e.getMessage());
                }
            }
            limpiarCampos();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String codigo = textoCodigo.getText();
        if((textoCodigo.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de codigo");
        }else{
            codigo = textoCodigo.getText();
            Productos c = pjc.findProductos(codigo);
            if (c == null){

                JOptionPane.showMessageDialog(null,"Producto con código " + codigo + " no existe.");
                limpiarCampos();

            }else{
                if(c.getEstado().equals("Off")){
                JOptionPane.showMessageDialog(null,"Este producto ha sido inhabilitado");
                
                limpiarCampos();
                
                }
            else
            {   textoCodigo.setText(c.getCodigo());
                textoNombre.setText(c.getNombre());
                textoPrecio.setText(String.valueOf(c.getPrecio()));
                textoUnidadMedida.setText(c.getUnidadmedida());
                labelStock.setText(c.getStock());
                categoria.setText(c.getCategoria().getNombre());
             
            }
        }
      }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void BotonCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCategoriaActionPerformed
        if(cp == null){
            cp = new CategoriaProductoGUI();
            cp.setVisible(true);

        }else
        cp.setVisible(true);
        cp.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonCategoriaActionPerformed

    private void textoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCodigoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
    }//GEN-LAST:event_textoCodigoKeyTyped

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')&&(c != 'ñ')&&(c != 'Ñ')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar letras");
        }
    }//GEN-LAST:event_textoNombreKeyTyped

    private void textoUnidadMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoUnidadMedidaKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')&&(c != 'ñ')&&(c != 'Ñ')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar letras");
        }
    }//GEN-LAST:event_textoUnidadMedidaKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCategoria;
    private javax.swing.JButton BotonUpdate;
    private javax.swing.JComboBox<Productos> ComboBoxCategoria;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonInhabilitar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelStock;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JTextField textoUnidadMedida;
    // End of variables declaration//GEN-END:variables


}
