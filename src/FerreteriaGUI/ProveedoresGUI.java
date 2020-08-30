package FerreteriaGUI;

import FerreteriaDAO.ProveedoresDAO;
import FerreteriaEntityClass.Proveedores;
import javax.swing.JOptionPane;


public class ProveedoresGUI extends javax.swing.JFrame {

    
    private ProveedoresDAO pjc = new ProveedoresDAO();
    private Proveedores proveedor = new Proveedores();
    private String mensaje = "";
    private ProveedoresDAO pdao = new ProveedoresDAO();
    
    public ProveedoresGUI() {
        initComponents();
        
        this.setTitle("Formulario Proveedores");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void limpiarCampos() {
        textoRut.setText("");
        textoRazonsocial.setText("");
        textoNombrecontacto.setText("");
        textoCargocontacto.setText("");
        textoDireccion.setText("");
        textoTelefono.setText("");
        textoCiudad.setText("");
        textoRubro.setText("");
        textoEmail.setText("");
        textoSitioweb.setText("");
    }
    
    private void inhabilitarProveedor(String rut) {
        pjc.inhabilitarProveedor(rut);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonInhabilitar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        textoEmail = new javax.swing.JTextField();
        textoRut = new javax.swing.JTextField();
        textoRazonsocial = new javax.swing.JTextField();
        textoNombrecontacto = new javax.swing.JTextField();
        textoCargocontacto = new javax.swing.JTextField();
        textoCiudad = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        textoSitioweb = new javax.swing.JTextField();
        textoRubro = new javax.swing.JTextField();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedores 64x64.png"))); // NOI18N
        jPanel1.add(jLabel0, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RUT:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Razón Social:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Sitio Web:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nombre de contacto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cargo del contacto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Teléfono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Ciudad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Rubro:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Email:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        botonInhabilitar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonInhabilitar.setText("Inhabilitar");
        botonInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInhabilitarActionPerformed(evt);
            }
        });
        jPanel1.add(botonInhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 120, -1));

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, -1));

        botonActualizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 130, -1));

        textoEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 180, -1));

        textoRut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 310, -1));

        textoRazonsocial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoRazonsocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 340, -1));

        textoNombrecontacto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNombrecontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 270, -1));

        textoCargocontacto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoCargocontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 270, -1));

        textoCiudad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 140, -1));

        textoTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 150, -1));

        textoDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 370, -1));

        textoSitioweb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoSitioweb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 370, -1));

        textoRubro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String rut = textoRut.getText();
        if((textoRut.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el Rut");
        }else{
            rut = textoRut.getText();
            Proveedores p = pjc.findProveedores(rut);
            if (p == null){
                
                limpiarCampos();
                
            }else
            {   textoRut.setText(p.getRut());
                textoRazonsocial.setText(p.getRazonSocial());
                textoNombrecontacto.setText(p.getNombrecontacto());
                textoCargocontacto.setText(p.getCargocontacto());
                textoDireccion.setText(p.getDireccion());
                textoTelefono.setText(p.getTelefono());
                textoCiudad.setText(p.getCiudad());
                textoRubro.setText(p.getRubro());
                textoEmail.setText(p.getEmail());
                textoSitioweb.setText(p.getSitioweb());}
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        if((textoRut.getText().length()==0)||
            (textoRazonsocial.getText().length()==0)||
            (textoNombrecontacto.getText().length()==0)||
            (textoCargocontacto.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)||
            (textoCiudad.getText().length()==0)||
            (textoRubro.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Campos obligatorios");
        }else{
            proveedor.setRut(textoRut.getText());
            proveedor.setRazonSocial(textoRazonsocial.getText());
            proveedor.setNombrecontacto(textoNombrecontacto.getText());
            proveedor.setCargocontacto(textoCargocontacto.getText());
            proveedor.setDireccion(textoDireccion.getText());
            proveedor.setTelefono(textoTelefono.getText());
            proveedor.setCiudad(textoCiudad.getText());
            proveedor.setRubro(textoRubro.getText());
            proveedor.setEmail(textoEmail.getText());
            proveedor.setSitioweb(textoSitioweb.getText());
            proveedor.setEstado("On");
            try {
                    pjc.create(proveedor);
                    mensaje = "Proveedor registrado";
                    JOptionPane.showMessageDialog(null, "Proveedor registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el Proveedor. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el Proveedor. \n" + e.getMessage());
                }
        }
            limpiarCampos();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if((textoRut.getText().length()==0)||
            (textoRazonsocial.getText().length()==0)||
            (textoNombrecontacto.getText().length()==0)||
            (textoCargocontacto.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)||
            (textoCiudad.getText().length()==0)||
            (textoRubro.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Campos obligatorios");
        }else{
            
            proveedor.setRut(textoRut.getText());
            proveedor.setRazonSocial(textoRazonsocial.getText());
            proveedor.setNombrecontacto(textoNombrecontacto.getText());
            proveedor.setCargocontacto(textoCargocontacto.getText());
            proveedor.setDireccion(textoDireccion.getText());
            proveedor.setTelefono(textoTelefono.getText());
            proveedor.setCiudad(textoCiudad.getText());
            proveedor.setRubro(textoRubro.getText());
            proveedor.setEmail(textoEmail.getText());
            proveedor.setSitioweb(textoSitioweb.getText());
            proveedor.setEstado("On");
            try {
                    pjc.edit(proveedor);
                    mensaje = "Proveedor registrado";
                    JOptionPane.showMessageDialog(null, "Proveedor registrado");
                } catch (Exception e) {
                    System.out.println("Mensaje en guardar: " + e.getMessage());
                    mensaje = "No se pudo registrar el Proveedor. \n" + e.getMessage();  
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el Proveedor. \n" + e.getMessage());
                }
            
            limpiarCampos();
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInhabilitarActionPerformed

        if((textoRut.getText().length()==0)||
            (textoRazonsocial.getText().length()==0)||
            (textoNombrecontacto.getText().length()==0)||
            (textoCargocontacto.getText().length()==0)||
            (textoDireccion.getText().length()==0)||
            (textoTelefono.getText().length()==0)||
            (textoCiudad.getText().length()==0)||
            (textoRubro.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Busque el cliente que desea inhabilitar");
        }else{
            inhabilitarProveedor(textoRut.getText());
            JOptionPane.showMessageDialog(null, "Cliente inhabilitado");
            
            limpiarCampos();
        } 
    }//GEN-LAST:event_botonInhabilitarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonInhabilitar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textoCargocontacto;
    private javax.swing.JTextField textoCiudad;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoNombrecontacto;
    private javax.swing.JTextField textoRazonsocial;
    private javax.swing.JTextField textoRubro;
    private javax.swing.JTextField textoRut;
    private javax.swing.JTextField textoSitioweb;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
