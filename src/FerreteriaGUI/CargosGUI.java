package FerreteriaGUI;

import FerreteriaDAO.CargosDAO;
import FerreteriaEntityClass.Cargos;
import javax.swing.JOptionPane;


public class CargosGUI extends javax.swing.JFrame {

    
    private CargosDAO cjc = new CargosDAO();
    private Cargos cargo = new Cargos();
    private String mensaje = "";
    private CargosDAO cdao = new CargosDAO();
    public CargosGUI() {
        initComponents();
        
        this.setTitle("Formulario Cargos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    private void limpiarCampos() {
        textoNumero.setText("");
        textoNombre.setText("");
        textoSalario.setText(""); 
    }
    
    private void inhabilitarCargo(String numero) {
        cjc.inhabilitarCargo(numero);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoSalario = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Número:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Salario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        textoNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 110, -1));

        textoNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 210, -1));

        textoSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 210, -1));

        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonEliminar.setText("Inhabilitar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 120, -1));

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, -1));

        botonActualizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cargos 64x64.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String numero = textoNumero.getText();
        if((textoNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de codigo");
        }else{
            numero = textoNumero.getText();
            Cargos c = cjc.findCargos(numero);
            if (c == null){
                
                limpiarCampos();
                
            }else
            {   textoNumero.setText(c.getNumero());
                textoNombre.setText(c.getNombre());
                textoSalario.setText(c.getSalario());}
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
            if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoSalario.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            cargo.setNumero(textoNumero.getText());
            cargo.setNombre(textoNombre.getText());
            cargo.setSalario(textoSalario.getText());
            cargo.setEstado("On");
            try {
                    cjc.create(cargo);
                    mensaje = "Cargo registrado";
                    JOptionPane.showMessageDialog(null, "Cargo registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el cargo. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el cargo. \n" + e.getMessage());
                }
        }
            limpiarCampos();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoSalario.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            
            cargo.setNumero(textoNumero.getText());
            cargo.setNombre(textoNombre.getText());
            cargo.setSalario(textoSalario.getText());
            cargo.setEstado("On");
            try {
                    cjc.edit(cargo);
                    mensaje = "Cargo actualizado";
                    JOptionPane.showMessageDialog(null, "Cargo actualizado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo actualizado el cargo. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo actualizado el cargo. \n" + e.getMessage());
                }
            
            limpiarCampos();
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

         if((textoNumero.getText().length()==0)||
            (textoNombre.getText().length()==0)||
            (textoSalario.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Busque el cargo que desea inhabilitar");
        }else{
            inhabilitarCargo(textoNumero.getText());
            JOptionPane.showMessageDialog(null, "Cargo inhabilitado");
            
            limpiarCampos();
        } 

    }//GEN-LAST:event_botonEliminarActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JTextField textoSalario;
    // End of variables declaration//GEN-END:variables
}
