package FerreteriaGUI;

import FerreteriaDAO.ClientesDAO;
import FerreteriaEntityClass.Clientes;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;


public class ClientesGUI extends javax.swing.JFrame {
        
    private Clientes cliente = new Clientes();
    private ClientesDAO cjc = new ClientesDAO();
    private String mensaje = "";
    
    public ClientesGUI() {
        initComponents();
        
        this.setTitle("Formulario Clientes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }
    
    private void inhabilitarCliente(String rutnuip) {
        cjc.inhabilitarCliente(rutnuip);
    }

    private void limpiarCampos() {
        groupTipopersona.clearSelection();
        textoRutnuip.setText("");
        textoNombre.setText("");
        textoDireccion.setText("");
        textoTelefono.setText("");
        textoEmail.setText("");
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTipopersona = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BotonBuscar = new javax.swing.JButton();
        BotonRegistrar = new javax.swing.JButton();
        BotonActualizar = new javax.swing.JButton();
        BotonInhabilitar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        radioNatural = new javax.swing.JRadioButton();
        radioJuridica = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        textoRutnuip = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Email:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Rut/Nuip:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        textoTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(textoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 270, -1));

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });
        jPanel1.add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 270, -1));

        textoDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(textoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 270, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clients 64x64.png "))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        BotonBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        BotonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonRegistrar.setText("Registrar");
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        BotonActualizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonActualizar.setText("Actualizar");
        BotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        BotonInhabilitar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonInhabilitar.setText("Inhabilitar");
        BotonInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInhabilitarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonInhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        groupTipopersona.add(radioNatural);
        radioNatural.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioNatural.setText("Natural");
        jPanel1.add(radioNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        groupTipopersona.add(radioJuridica);
        radioJuridica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioJuridica.setText("Juridica");
        jPanel1.add(radioJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tipo de Persona:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        textoEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 270, -1));

        textoRutnuip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoRutnuip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoRutnuipKeyTyped(evt);
            }
        });
        jPanel1.add(textoRutnuip, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, -1));

        jLabel21.setText("Campo opcional ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInhabilitarActionPerformed

        if((textoRutnuip.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Busque el cliente que desea inhabilitar");
        }else{
            inhabilitarCliente(textoRutnuip.getText());
            JOptionPane.showMessageDialog(null, "Cliente inhabilitado");
            
            limpiarCampos();
        }  
    }//GEN-LAST:event_BotonInhabilitarActionPerformed

    private void BotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarActionPerformed
        if((textoRutnuip.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            if (radioJuridica.isSelected()){
                cliente.setTipopersona("Juridica");          
            }else
                cliente.setTipopersona("Natural");
            
            cliente.setRutNuip(textoRutnuip.getText());
            cliente.setNombre(textoNombre.getText());
            cliente.setDireccion(textoDireccion.getText());
            cliente.setTelefono(textoTelefono.getText());
            cliente.setEmail(textoEmail.getText());
            cliente.setEstado("On");
            try {
                    cjc.edit(cliente);
                    mensaje = "Cliente actualizado";
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en actualizar: " + e.getMessage());
                    mensaje = "No se pudo actualizar la información. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la información. \n" + e.getMessage());
                }
            
            limpiarCampos();
        }
    }//GEN-LAST:event_BotonActualizarActionPerformed

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed
        if((textoRutnuip.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            if (radioJuridica.isSelected()){

            cliente.setTipopersona("Juridica");
            cliente.setRutNuip(textoRutnuip.getText());
            cliente.setNombre(textoNombre.getText());
            cliente.setDireccion(textoDireccion.getText());
            cliente.setTelefono(textoTelefono.getText());
            cliente.setEmail(textoEmail.getText());
            cliente.setEstado("On");
                try {
                    cjc.create(cliente);
                    mensaje = "Cliente registrado";
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el cliente. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente. \n" + e.getMessage());
                }
                
            limpiarCampos();
                
            }else if(radioNatural.isSelected()){

            cliente.setTipopersona("Natural");
            cliente.setRutNuip(textoRutnuip.getText());
            cliente.setNombre(textoNombre.getText());
            cliente.setDireccion(textoDireccion.getText());
            cliente.setTelefono(textoTelefono.getText());
            cliente.setEmail(textoEmail.getText());
            cliente.setEstado("On");
            
                try {
                    cjc.create(cliente);
                    mensaje = "Cliente registrado";
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el cliente. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente. \n" + e.getMessage());
                }
            
            limpiarCampos();
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de persona");
            }
        }
    }//GEN-LAST:event_BotonRegistrarActionPerformed

    //(c != KeyEvent.VK_SPACE)
    private void textoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDireccionKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')&&(c != 'ñ')&&(c != 'Ñ')&&(c < '0' || c > '9')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar letras y números");
        }
    }//GEN-LAST:event_textoDireccionKeyTyped

  //||(c == KeyEvent.VK_DELETE)
    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')&&(c != 'ñ')&&(c != 'Ñ')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar letras");
        }
    }//GEN-LAST:event_textoNombreKeyTyped

    private void textoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoTelefonoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
        int caracteres=10;
        if(textoTelefono.getText().length()>=caracteres){
            JOptionPane.showMessageDialog(null, "Sobrepasa la cantidad de números permitidos");
        }
    }//GEN-LAST:event_textoTelefonoKeyTyped

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        String rutnuip = textoRutnuip.getText();
        if((textoRutnuip.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el rup o nuip");
        }else{
            rutnuip = textoRutnuip.getText();
            Clientes c = cjc.findClientes(rutnuip);
            if (c == null){

                limpiarCampos();
                
            }else{
                if(c.getEstado().equals("Off")){
                JOptionPane.showMessageDialog(null,"Este cliente ha sido inhabilitado");

                limpiarCampos();
                }
             else  
            {   
                String tipopersona = c.getTipopersona();
                if(tipopersona.equals("Juridica")){
                radioJuridica.setSelected(true); 
                }else{
                radioNatural.setSelected(true);
                }
                
                textoRutnuip.setText(rutnuip);
                textoNombre.setText(c.getNombre());
                textoDireccion.setText(c.getDireccion());
                textoTelefono.setText(c.getTelefono());  
                textoEmail.setText(c.getEmail());
            }
        }
      }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void textoRutnuipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoRutnuipKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_SPACE)&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
        int caracteres=15;
        if(textoTelefono.getText().length()>=caracteres){
            JOptionPane.showMessageDialog(null, "Sobrepasa la cantidad de números permitidos");
        }
    }//GEN-LAST:event_textoRutnuipKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ClientesGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonInhabilitar;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.ButtonGroup groupTipopersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioJuridica;
    private javax.swing.JRadioButton radioNatural;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoRutnuip;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables



}
