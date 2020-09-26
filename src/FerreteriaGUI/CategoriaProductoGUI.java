package FerreteriaGUI;

import FerreteriaDAO.CategoriaProductoDAO;
import FerreteriaEntityClass.CategoriaProducto;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;


public class CategoriaProductoGUI extends javax.swing.JFrame {

    private CategoriaProductoDAO cpjc = new CategoriaProductoDAO();
    private CategoriaProducto categoria = new CategoriaProducto();
    private String mensaje = "";
    private CategoriaProductoDAO cpdao = new CategoriaProductoDAO();
    public CategoriaProductoGUI() {
        initComponents();
        
        textoDescripcion.setLineWrap(true);
        
        this.setTitle("Formulario Categoria de Producto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }
    
    private void limpiarCampos() {
        textoNumero.setText("");
        textoNombre.setText("");
        textoDescripcion.setText("");
        textoIva.setText("");
    }
    
    private void inhabilitarCategoriaproducto(String numero) {
        cpjc.inhabilitarCategoriaproducto(numero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        botonctualizar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textoIva = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Categoria 63x63.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Descripción:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Número:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Iva:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 60, -1));

        textoNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNumeroKeyTyped(evt);
            }
        });
        jPanel1.add(textoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 130, -1));

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 240, -1));

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonEliminar.setText("Inhabilitar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        botonctualizar1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonctualizar1.setText("Actualizar");
        botonctualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonctualizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonctualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        textoIva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textoIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 60, -1));

        textoDescripcion.setColumns(20);
        textoDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoDescripcion.setRows(5);
        jScrollPane2.setViewportView(textoDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 240, 90));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("%");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

          if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDescripcion.getText().length()==0)||
            (textoIva.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Busque la cetegoría que desea inhabilitar");
        }else{
            inhabilitarCategoriaproducto(textoNumero.getText());
            JOptionPane.showMessageDialog(null, "Categoría inhabilitada");
            
            limpiarCampos();
        }  

    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String codigo = textoNumero.getText();
        if((textoNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de codigo");
        }else{
            codigo = textoNumero.getText();
            CategoriaProducto c = cpjc.findCategoriaProducto(codigo);
            if (c == null){
                JOptionPane.showMessageDialog(null,"Categoría con número " + codigo + " no existe");
                limpiarCampos();
                
            }else
            {   textoNombre.setText(c.getNombre());
                textoDescripcion.setText(c.getDescripcion());
                textoIva.setText(c.getIva());}
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDescripcion.getText().length()==0)||
            (textoIva.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            categoria.setNumero(textoNumero.getText());
            categoria.setNombre(textoNombre.getText());
            categoria.setDescripcion(textoDescripcion.getText());
            categoria.setIva(textoIva.getText());
            categoria.setEstado("On");
            try {
                    cpjc.create(categoria);
                    mensaje = "Categoria registrada";
                    JOptionPane.showMessageDialog(null, "Categoria registrada");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar la categoria. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar la categoria. \n" + e.getMessage());
                }
            
        }
        
            limpiarCampos();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonctualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonctualizar1ActionPerformed
        if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDescripcion.getText().length()==0)||
            (textoIva.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            categoria.setNumero(textoNumero.getText());
            categoria.setNombre(textoNombre.getText());
            categoria.setDescripcion(textoDescripcion.getText());
            categoria.setIva(textoIva.getText());
            categoria.setEstado("On");
            try {
                    cpjc.edit(categoria);
                    mensaje = "Categoria actualizada";
                    JOptionPane.showMessageDialog(null, "Categoria actualizada");
                } catch (Exception e) {
                    System.out.println("Mensaje en actualizar: " + e.getMessage());
                    mensaje = "No se pudo actualizar la categoria. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la categoria. \n" + e.getMessage());
                }
            
            limpiarCampos();
        }
    }//GEN-LAST:event_botonctualizar1ActionPerformed

    private void textoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNumeroKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
        int caracteres=10;
        if(textoNumero.getText().length()>=caracteres){
            JOptionPane.showMessageDialog(null, "Sobrepasa la cantidad de números permitidos");
        }
    }//GEN-LAST:event_textoNumeroKeyTyped

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonctualizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoIva;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoNumero;
    // End of variables declaration//GEN-END:variables
}
