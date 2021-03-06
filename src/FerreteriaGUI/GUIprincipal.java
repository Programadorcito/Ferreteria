
package FerreteriaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GUIprincipal extends javax.swing.JFrame {

    
    private ClientesGUI c = null;
    private EmpleadosGUI e = null;
    private ProductosGUI p = null;
    private VentasGUI f = null;
    private PedidosGUI cp = null;
    private ProveedoresGUI pr = null;

    public GUIprincipal() {
        initComponents();
        
        this.setTitle("F E R R E T E R I A");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonClientes = new javax.swing.JButton();
        BotonEmpleados = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BotonProductos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BotonVentas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BotonPedidos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BotonProveedores = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        BotonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clients 128x128.png"))); // NOI18N
        BotonClientes.setBorder(null);
        BotonClientes.setBorderPainted(false);
        BotonClientes.setContentAreaFilled(false);
        BotonClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonClientes.setIconTextGap(-3);
        BotonClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });
        jPanel1.add(BotonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, 140));

        BotonEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Builder 128x128.png"))); // NOI18N
        BotonEmpleados.setBorder(null);
        BotonEmpleados.setBorderPainted(false);
        BotonEmpleados.setContentAreaFilled(false);
        BotonEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonEmpleados.setIconTextGap(-3);
        BotonEmpleados.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(BotonEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 140));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Empleados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        BotonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Product 128x128.png"))); // NOI18N
        BotonProductos.setBorder(null);
        BotonProductos.setBorderPainted(false);
        BotonProductos.setContentAreaFilled(false);
        BotonProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonProductos.setIconTextGap(-3);
        BotonProductos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProductosActionPerformed(evt);
            }
        });
        jPanel1.add(BotonProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Productos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        BotonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ventas 128x128.png"))); // NOI18N
        BotonVentas.setBorderPainted(false);
        BotonVentas.setContentAreaFilled(false);
        BotonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonVentas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentasActionPerformed(evt);
            }
        });
        jPanel1.add(BotonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 150, 140));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Ventas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, -1));

        BotonPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compras 128x128.png"))); // NOI18N
        BotonPedidos.setBorder(null);
        BotonPedidos.setBorderPainted(false);
        BotonPedidos.setContentAreaFilled(false);
        BotonPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonPedidos.setIconTextGap(-3);
        BotonPedidos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPedidosActionPerformed(evt);
            }
        });
        jPanel1.add(BotonPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 150, 140));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Pedidos a Proveedores");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 270, -1));

        BotonProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedores 128x128.png"))); // NOI18N
        BotonProveedores.setBorder(null);
        BotonProveedores.setBorderPainted(false);
        BotonProveedores.setContentAreaFilled(false);
        BotonProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonProveedores.setIconTextGap(-3);
        BotonProveedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProveedoresActionPerformed(evt);
            }
        });
        jPanel1.add(BotonProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 150, 140));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Proveedores");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo2.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 520));

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //private 
    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed

        if(c == null){
           c = new ClientesGUI();
           c.setVisible(true);
           
        }else
        c.setVisible(true);
        c.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmpleadosActionPerformed
        if(e == null){
           e = new EmpleadosGUI();
           e.setVisible(true);
           
        }else
        e.setVisible(true);
        e.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonEmpleadosActionPerformed

    private void BotonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProductosActionPerformed
        if(p == null){
           p = new ProductosGUI();
           p.setVisible(true);
           
        }else
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonProductosActionPerformed

    private void BotonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentasActionPerformed
        if(f == null){
           f = new VentasGUI();
           f.setVisible(true);
           
        }else
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonVentasActionPerformed

    private void BotonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPedidosActionPerformed
//        String usuario = JOptionPane.showInputDialog(null, "Usuario");
//        String password = JOptionPane.showInputDialog(null, "Password");
//        if( usuario.equals("Admin") && password.equals("clave")){

//        String contraseña = JOptionPane.showInputDialog(null, "INGRESE CONTRASEÑA");
//        if(contraseña.equals("123")){

        if(cp == null){
           cp = new PedidosGUI();
           cp.setVisible(true);
           
        }else
        cp.setVisible(true);
        cp.setLocationRelativeTo(null);
        
//        }else{
//            JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
//        }
        
    }//GEN-LAST:event_BotonPedidosActionPerformed

    private void BotonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProveedoresActionPerformed
        if(pr == null){
           pr = new ProveedoresGUI();
           pr.setVisible(true);
           
        }else
        pr.setVisible(true);
        pr.setLocationRelativeTo(null);
    }//GEN-LAST:event_BotonProveedoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIprincipal().setVisible(true);
            }
        });
    }

//    public class ManejadorEmpleadoGUI implements ActionListener {
//        private ClientesGUI ventana = null;
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(ventana == null){
//            ventana = new ClientesGUI();
//            jDesktopPane1.add(ventana);
//        }
//            ventana.setVisible(true);
//            //ventana.moveToFront();
//    }
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonEmpleados;
    private javax.swing.JButton BotonPedidos;
    private javax.swing.JButton BotonProductos;
    private javax.swing.JButton BotonProveedores;
    private javax.swing.JButton BotonVentas;
    private javax.swing.JLabel Fondo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


