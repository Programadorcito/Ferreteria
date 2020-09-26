package FerreteriaGUI;

import FerreteriaController.PedidosController;
import FerreteriaDAO.DetallePedidoDAO;
import FerreteriaDAO.PedidosDAO;
import FerreteriaDAO.ProductosDAO;
import FerreteriaDAO.ProveedoresDAO;
import FerreteriaEntityClass.Pedidos;
import FerreteriaEntityClass.DetallePedido;
import FerreteriaEntityClass.Productos;
import FerreteriaEntityClass.Proveedores;
//import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.Date;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;


public class PedidosGUI extends javax.swing.JFrame {

  
    private PedidosController control = new PedidosController();
    
    private DetallePedidoDAO djc = new DetallePedidoDAO();
    private DetallePedido detalle = new DetallePedido();
    private String mensaje = "";
    private PedidosDAO pejc = new PedidosDAO();
    private Pedidos pedido = new Pedidos();
    private PedidosDAO cdao = new PedidosDAO();
    private ProductosDAO pdao = new ProductosDAO();
    private ProductosDAO pjc = new ProductosDAO();
    private ProveedoresDAO prdao = new ProveedoresDAO();
  
    Productos pr = new Productos();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
//    PlaceHolder holder;
    
    
    public PedidosGUI() {
        initComponents();
        
        this.setTitle("Formulario Pedidos a Proveedores");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        labelFecha.setText(fechaActual());

        labelNumero.setText(pejc.idIncrementable());
        
        ManejadorBuscarProducto c = new ManejadorBuscarProducto();
        textoCodigo.addActionListener(c);
        
        ManejadorBuscarProveedor p = new ManejadorBuscarProveedor();
        textoRut.addActionListener(p);
        
        ManejadorDevolverSubtotal s = new ManejadorDevolverSubtotal();
        Igual.addActionListener(s);
        
        String Dato[] = new String [5];
                modelo.addColumn("CODIGO"); 
                modelo.addColumn("NOMBRE"); 
                modelo.addColumn("COSTO");
                modelo.addColumn("CANTIDAD");
                modelo.addColumn("SUBTOTAL"); 
                tablaProductos.setModel(modelo);
                
                tablaProductos.setModel(modelo2);
        
//        holders();
//        holder = new PlaceHolder(textoCodigo,"INGRESE CODIGO");
//        holder = new PlaceHolder(textoRut,"INGRESE RUT");
//        textoCodigo.setBackground(Color.GRAY);
//        textoRut.setBackground(Color.GRAY);
        
        textoCodigo.setForeground(Color.black);
        textoRut.setForeground(Color.black);
        
    }
    
    public void holders(){ 
    }
    
    public static String fechaActual(){
        Date fecha= new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
    }

    private void llenarComboBoxProductos(JComboBox ComboBoxProductos){
        pejc.getProductos(ComboBoxProductos);
    }
    
    private void llenarComboBoxProveedores(JComboBox ComboBoxProveedores){
        pejc.getProveedores(ComboBoxProveedores);
    }
  
    private void mostrarTabla(String numero){
        djc.listarDetalles(tablaProductos, numero);
      
        TableColumnModel columnModel = tablaProductos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(15);
        columnModel.getColumn(4).setPreferredWidth(20);
    }
 
    private void eliminarDetalle(String codigo){
        djc.eliminarDetalle(codigo);
    }
    
    private void eliminarDetalles(String numero){
        djc.eliminarDetalles(numero);
    }
    
    private void inhabilitarPedido(String numero) {
        pejc.inhabilitarPedido(numero);
    }
    
    private void eliminarPedido(String numero) {
        control.eliminarPedido(numero);
    }
    
    private void stockRestado(String codigo, String cantidad){
        djc.stockRestado(codigo, cantidad);
    }
    
    private void limpiarCampos() {
        textoNumero.setText("");
        textoCodigo.setText("");
        textoNombreproducto.setText("");
        textoCosto.setText("");
        textoSubtotal.setText("");
    }
    
    private void limpiarTodosCampos() {
        textoNumero.setText("");
        //labelFecha.setText("");
        textoRut.setText("");
        labelNombreproveedor.setText("");
        textoCantidadcuotas.setText("");
        textoCodigo.setText("");
        textoNombreproducto.setText("");
        textoCosto.setText("");
        textoSubtotal.setText("");
        textoSubtotal.setText("");
        tablaProductos.setModel(modelo);

        int a = modelo.getRowCount() - 1;
        System.out.println(a);
        for (int i = a; i >= 0; i--) {
            System.out.println(i);
            modelo.removeRow(i);
        }
    }
    
 
    public void Total(){
        int fila = 0;
        int total = 0;
        for (int i = 0; i < tablaProductos.getRowCount(); i++){
           fila = Integer.parseInt(tablaProductos.getValueAt(i,4).toString());
           total += fila;
        }
        textoTotal.setText(Integer.toString(total));
    }

    public void Total2(){
        int fila = 0;
        int total = 0;
        for (int i = 0; i < tablaProductos.getRowCount(); i++){
           fila = Integer.parseInt(tablaProductos.getValueAt(i,4).toString());
           total -= fila * - 1;
        }
        textoTotal.setText(Integer.toString(total));
    }
    
    public void Subtotal(){ 
        String n1, n2;
        int a,b,subtotal = 0;
        n1= textoCosto.getText();
        n2= SpinnerCantidad.getValue().toString();
        a=Integer.parseInt(n1);
        b=Integer.parseInt(n2);
        subtotal =  a * b;
        textoSubtotal.setText(Integer.toString(subtotal));
        }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupFormapago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoCosto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SpinnerCantidad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        botonRegistrarcompra = new javax.swing.JButton();
        botonBuscarcompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        textoTotal = new javax.swing.JTextField();
        BotonAgregarProducto = new javax.swing.JButton();
        textoCodigo = new javax.swing.JTextField();
        textoNombreproducto = new javax.swing.JTextField();
        textoRut = new javax.swing.JTextField();
        textoSubtotal = new javax.swing.JTextField();
        botonCrearPedido = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Igual = new javax.swing.JButton();
        BotonQuitarProducto = new javax.swing.JButton();
        botonModificarPedido = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        radioContado = new javax.swing.JRadioButton();
        radioCuotas = new javax.swing.JRadioButton();
        textoCantidadcuotas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonCancelarPedido = new javax.swing.JButton();
        labelNombreproveedor = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compras 64x64.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 80, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Consultar Pedido:");

        textoNumero.setBackground(new java.awt.Color(204, 255, 255));
        textoNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(textoNumero))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 130, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Proveedor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Costo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Cantidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        textoCosto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textoCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Forma de Pago:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        SpinnerCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel1.add(SpinnerCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 80, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Cuotas:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        botonRegistrarcompra.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        botonRegistrarcompra.setText("Registrar Pedido");
        botonRegistrarcompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonRegistrarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarcompraActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrarcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 180, 30));

        botonBuscarcompra.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscarcompra.setText("Buscar ");
        botonBuscarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarcompraActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 130, -1));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "COSTO", "CANTIDAD", "SUBTOTAL"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(20);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(15);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 550, 90));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, -1));

        textoTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 110, -1));

        BotonAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonAgregarProducto.setText("Agregar Producto");
        BotonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 550, 30));

        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 110, -1));

        textoNombreproducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoNombreproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 300, -1));

        textoRut.setBackground(new java.awt.Color(204, 255, 255));
        textoRut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoRut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textoRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 110, -1));

        textoSubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textoSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 140, -1));

        botonCrearPedido.setBackground(new java.awt.Color(204, 255, 255));
        botonCrearPedido.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonCrearPedido.setText("Crear Pedido");
        botonCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonCrearPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 150, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Subtotal:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        Igual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Igual.setText("=");
        jPanel1.add(Igual, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 50, -1));

        BotonQuitarProducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonQuitarProducto.setText("Quitar Producto");
        BotonQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonQuitarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(BotonQuitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        botonModificarPedido.setBackground(new java.awt.Color(204, 255, 255));
        botonModificarPedido.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonModificarPedido.setText("Modificar Pedido");
        botonModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonModificarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        radioContado.setBackground(new java.awt.Color(255, 255, 255));
        groupFormapago.add(radioContado);
        radioContado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioContado.setText("Contado");

        radioCuotas.setBackground(new java.awt.Color(255, 255, 255));
        groupFormapago.add(radioCuotas);
        radioCuotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioCuotas.setText("Cuotas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(radioContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCuotas)
                    .addComponent(radioContado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 50));

        textoCantidadcuotas.setBackground(new java.awt.Color(204, 255, 255));
        textoCantidadcuotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCantidadcuotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCantidadcuotasKeyTyped(evt);
            }
        });
        jPanel1.add(textoCantidadcuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 80, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Número:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        labelNumero.setBackground(new java.awt.Color(204, 255, 255));
        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        labelFecha.setBackground(new java.awt.Color(204, 255, 255));
        labelFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 120, 30));

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Close 32x32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setBorder(null);
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setIconTextGap(-3);
        botonSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, -1));

        botonCancelarPedido.setBackground(new java.awt.Color(204, 255, 255));
        botonCancelarPedido.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        botonCancelarPedido.setText("Cancelar Pedido");
        botonCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 160, -1));

        labelNombreproveedor.setBackground(new java.awt.Color(204, 255, 255));
        labelNombreproveedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNombreproveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelNombreproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonQuitarProductoActionPerformed

        if(
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoCosto.getText().length()==0)||
            (SpinnerCantidad.getValue().toString().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Seleccione el producto que desea quitar \n ");}
        else{

            String numero = textoNumero.getText();
            Pedidos c = control.buscarPedido(numero);
            
            if(c.getEstado().equals("Off")){
                JOptionPane.showMessageDialog(null,"No puede quitar productos de un pedido registrado");
            }else{
                 if((textoNumero.getText().length()==0)||
                    (textoCodigo.getText().length()==0)||
                    (textoNombreproducto.getText().length()==0)||
                    (textoCosto.getText().length()==0)||
                    (textoSubtotal.getText().length()==0)){
                    JOptionPane.showMessageDialog(null,"Los campos deben estár llenos \n Haga la busqueda con el número de pedido");
                    
                    limpiarCampos();
                    
                }else
                {
                    String codigo = textoCodigo.getText();
                    control.eliminarDetalle(codigo);
              
                    textoNumero.setText(c.getNumero());
//                    String costo = textoCosto.getText();
                    tablaProductos.setModel(modelo);
                    mostrarTabla(textoNumero.getText());
                    Total2();

                }}}

    }//GEN-LAST:event_BotonQuitarProductoActionPerformed

    private void botonCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPedidoActionPerformed
        if ((labelNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoRut.getText().length()==0)||
            (labelNombreproveedor.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Llenar todos los campos");
        }else{
            String numero = "";
                if(labelNumero.getText().length()!=1){
                    numero = "1";
                }else{
                    numero = labelNumero.getText();
                }
                
            String pago = null;
            if (radioContado.isSelected()) {
                pago = "Contado";

            String rut = textoRut.getText();
            rut = textoRut.getText();
            Proveedores p = prdao.findProveedores(rut);
            textoRut.setText(p.getRut());
            
                
                String mensaje = "";
                mensaje = control.insertarPedidos(numero, labelFecha.getText(), pago, "0", p, "On");
                JOptionPane.showMessageDialog(null, mensaje);
            
            } else if (radioCuotas.isSelected()) {
                pago = "Cuotas";

            if((textoCantidadcuotas.getText().equals(""))||(textoCantidadcuotas.getText().equals("0"))){
                JOptionPane.showMessageDialog(null,"Ingrese el numero de cuotas a pagar");}
            else{

            String rut = textoRut.getText();
            rut = textoRut.getText();
            Proveedores p = prdao.findProveedores(rut);
            textoRut.setText(p.getRut());

                String mensaje = "";
                mensaje = control.insertarPedidos(numero, labelFecha.getText(), pago, textoCantidadcuotas.getText(), p, "On");
                JOptionPane.showMessageDialog(null, mensaje);
            }

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una Forma de Pago");
            }

        }
    }//GEN-LAST:event_botonCrearPedidoActionPerformed

    private void BotonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarProductoActionPerformed
        if(
            (labelNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoCosto.getText().length()==0)||
//            (SpinnerCantidad.getValue().toString().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos del producto deben estar llenos \n ");} 
        else{

            modelo.setRowCount(0);
            textoTotal.setText("");
            String numero = labelNumero.getText();
            pedido = control.buscarPedido(numero);
   

            //    JOptionPane.showMessageDialog(null,"Los campos deben estar llenos");
            
            if(pedido == null){
            JOptionPane.showMessageDialog(null,"Debe crear una factura de pedido para poder ingresar los detalles");
            }else
            {
            if(pedido.getEstado().equals("Off")){
                JOptionPane.showMessageDialog(null,"No puede agregar productos a un pedido registrado");
                    textoNumero.setText(""); 
                    labelNumero.setText(pejc.idIncrementable());
                    labelFecha.setText(fechaActual());
                    textoRut.setText(""); 
                    labelNombreproveedor.setText("");
                    groupFormapago.clearSelection();
                    textoCodigo.setText("");
                    textoNombreproducto.setText("");
                    textoCosto.setText("");
                    tablaProductos.setModel(modelo);
            }else{
                if( 
//                    (labelNumero.getText().length()==0)||
//                    (labelFecha.getText().length()==0)||
                    (textoCodigo.getText().length()==0)||
                    (textoNombreproducto.getText().length()==0)||
                    (textoCosto.getText().length()==0)||
                    (SpinnerCantidad.getValue().toString().length()==0)||
                    (textoSubtotal.getText().length()==0)){
                    JOptionPane.showMessageDialog(null,"Los campos deben estár llenos \n ");
                    
                    limpiarCampos();
                    
                }else
                {
                    textoNumero.setText(pedido.getNumero());

                    String codigo = textoCodigo.getText();
                    codigo = textoCodigo.getText();
//                    Productos p = pjc.findProductos(codigo);
//                    textoCodigo.setText(p.getCodigo());

                    pr = control.buscarProducto(codigo);
                    textoCodigo.setText(pr.getCodigo());

                    String [] dato = new String[5];
                    dato[0] = textoCodigo.getText();
                    dato[1] = textoNombreproducto.getText();
                    dato[2] = textoCosto.getText();
                    dato[3] = SpinnerCantidad.getValue().toString();
                    dato[4] = textoSubtotal.getText();

                modelo.addRow(dato);
                tablaProductos.setModel(modelo);

                    
                    String costoproducto = textoCosto.getText();
                    String cantidad = SpinnerCantidad.getValue().toString();
                    
                    //INSERTAR DETALLE AL PEDIDO
                    control.insertarDetallePedido(pedido, pr, costoproducto, cantidad, "On");
    
                    
                    textoCodigo.setText("");
                    textoNombreproducto.setText("");
                    textoCosto.setText("");
                    textoSubtotal.setText("");

                    tablaProductos.setModel(modelo);
                    mostrarTabla(textoNumero.getText());
                    Total();

                }}}}

    }//GEN-LAST:event_BotonAgregarProductoActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int select = tablaProductos.getSelectedRow();
        textoCodigo.setText(tablaProductos.getValueAt(select, 0)+"");
        textoNombreproducto.setText(tablaProductos.getValueAt(select, 1)+"");
        textoCosto.setText(tablaProductos.getValueAt(select, 2)+"");
        SpinnerCantidad.setValue(Integer.parseInt((tablaProductos.getValueAt(select, 3)+"")));
        textoSubtotal.setText(tablaProductos.getValueAt(select, 4)+"");
        
//        textoCantidad.setText(tablaProductos.getValueAt(select, 3)+"");
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void botonBuscarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarcompraActionPerformed
        modelo.setRowCount(0);

        String numero = textoNumero.getText();
        if((textoNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de Factura");
        }else{
            numero = textoNumero.getText();
            Pedidos c = pejc.findPedidos(numero);

            if (c == null){
                JOptionPane.showMessageDialog(null,"Pedido con numero " + numero + " no está registrado");

                //LIMPIAR CAMPOS:
                labelNumero.setText(cdao.idIncrementable());
                labelFecha.setText(fechaActual());
                textoNumero.setText("");
                textoRut.setText("");
                labelNombreproveedor.setText("");
                groupFormapago.clearSelection();
                textoCantidadcuotas.setText("");
                textoCodigo.setText("");
                textoNombreproducto.setText("");
                textoCosto.setText("");
                textoSubtotal.setText("");
                textoTotal.setText("");
                tablaProductos.setModel(modelo);

            }else
            {   textoNumero.setText(c.getNumero());
                labelNumero.setText(c.getNumero());
                labelFecha.setText(c.getFechapedido());
                labelNombreproveedor.setText(c.getProveedor().getRazonSocial());
                textoRut.setText(c.getProveedor().getRut());

                String pago = c.getFormapago();
                if(pago.equals("Contado")){
                    radioContado.setSelected(true);
                }else{
                    radioCuotas.setSelected(true);
                }

                textoCantidadcuotas.setText(c.getCuotas());
//                SpinnerCuotas.setValue(Integer.parseInt(c.getCuotas()));

                mostrarTabla(textoNumero.getText());
                Total();
            }
        }
    }//GEN-LAST:event_botonBuscarcompraActionPerformed

    private void botonRegistrarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarcompraActionPerformed
        modelo.setRowCount(0);
        
        String numero = textoNumero.getText();
//        Pedidos c = pejc.findPedidos(numero);
        
        if(
            (textoNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoRut.getText().length()==0)||
            (labelNombreproveedor.getText().length()==0)||
            (tablaProductos.getRowCount()==0 && tablaProductos.getSelectedRow()==-1)
             ){
            JOptionPane.showMessageDialog(null,"Los campos deben estar llenos y debe \n haber al menos un detalle de pedido");}

        else
        {
            if(pedido.getEstado().equals("Off")){
            JOptionPane.showMessageDialog(null,"Este pedido ya esta registrado");}
            else
        {
            
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea registrar este pedido?");
            if (confirmacion == JOptionPane.YES_OPTION)
            {
            inhabilitarPedido(textoNumero.getText());
            JOptionPane.showMessageDialog(null, "Pedido registrado");
                    tablaProductos.setModel(modelo);
                    textoNumero.setText("");
                    labelNumero.setText(cdao.idIncrementable());
                    labelFecha.setText("");
                    textoRut.setText("");
                    labelNombreproveedor.setText("");
                    groupFormapago.clearSelection();
                    textoCantidadcuotas.setText("");
                    textoCodigo.setText("");
                    textoNombreproducto.setText("");
                    textoCosto.setText("");
                    textoSubtotal.setText("");
                    
                    
            }
            if (confirmacion == JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Pedido NO registrado \n ");
                
                control.eliminarDetalles(numero);
                control.eliminarPedido(numero);
                
                    tablaProductos.setModel(modelo);
                    textoNumero.setText("");
                    labelFecha.setText("");
                    textoCodigo.setText("");
                    textoRut.setText("");
                    labelNombreproveedor.setText("");
                    textoNombreproducto.setText("");
                    textoCosto.setText("");
                    textoSubtotal.setText("");
            }
            if (confirmacion == JOptionPane.CANCEL_OPTION)
            {
//                JOptionPane.showMessageDialog(null,"Pedido NO registrado \n ");
            }
        
        }}
    }//GEN-LAST:event_botonRegistrarcompraActionPerformed

    private void botonModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarPedidoActionPerformed
        if((textoNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoRut.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos del proveedor, forma de pago y cuotas deben estar llenos");
        }else{
            
            String numero = labelNumero.getText();
            pedido = control.buscarPedido(numero);

            String pago;
            if (radioContado.isSelected()) {
                pago = "Contado";

            String rut = textoRut.getText();
            rut = textoRut.getText();
            Proveedores p = prdao.findProveedores(rut);
            textoRut.setText(p.getRut());
            
            
                String mensaje = "";
                mensaje = control.actualizarPedido(numero, labelFecha.getText(), pago, "0", p, "On");
                JOptionPane.showMessageDialog(null, mensaje);

            
            } else if (radioCuotas.isSelected()) {
                pago = "Cuotas";

            if((textoCantidadcuotas.getText().equals(""))||(textoCantidadcuotas.getText().equals("0"))){
                JOptionPane.showMessageDialog(null,"Ingrese el numero de cuotas a pagar");}
            else{

            String rut = textoRut.getText();
            rut = textoRut.getText();
            Proveedores p = prdao.findProveedores(rut);
            textoRut.setText(p.getRut());

    
                String mensaje = "";
                mensaje = control.actualizarPedido(numero, labelFecha.getText(), pago, textoCantidadcuotas.getText(), p, "On");
                JOptionPane.showMessageDialog(null, mensaje);
            }
            } 
        }
    }//GEN-LAST:event_botonModificarPedidoActionPerformed

    private void textoCantidadcuotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCantidadcuotasKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números positivos");
        }
    }//GEN-LAST:event_textoCantidadcuotasKeyTyped

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        String numero = labelNumero.getText();
        pedido = pejc.findPedidos(numero);

        if(pedido == null){
            hide();
        }else{

            if(pedido.getEstado().equals("Off")){
                hide();
            }else{
                if(pedido.getEstado().equals("On"))
                {

                    int confirmacion = JOptionPane.showConfirmDialog(null, "Si sale sin Registrar el pedido se perderán los datos. \n Desea salir?");

                    if (confirmacion == JOptionPane.YES_OPTION)
                    {   
                        control.eliminarDetalles(numero);
//                        pejc.eliminarPedido(numero);
                        control.eliminarPedido(numero);
                
//                        eliminarDetalles(textoNumero.getText());
//                        cdao.eliminarPedido(numero);
//                        eliminarPedido(textoNumero.getText());

                        labelNumero.setText(pejc.idIncrementable());
                        textoNumero.setText("");
                        //                    labelFecha.setText("");
                        
                        textoRut.setText("");
                        labelNombreproveedor.setText("");
                        textoCantidadcuotas.setText("");
                        
                        textoNumero.setText("");
                        textoCodigo.setText("");
                        textoNombreproducto.setText("");
                        textoCosto.setText("");
                        textoSubtotal.setText("");
                        modelo.setRowCount(0);
                        tablaProductos.setModel(modelo);

                        hide();
                    }

                    if (confirmacion == JOptionPane.CANCEL_OPTION)
                    {
                        //                JOptionPane.showMessageDialog(null,"Pedido NO registrado \n ");
                    }

                }else{

                    if(pedido.getEstado().equals(null))
                    {
                        hide();
                    }}}}
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarPedidoActionPerformed
        String numero = labelNumero.getText();
        if((labelNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"No hay factura de pedido \n ");
            //                textoNumero.setText(vdao.idIncrementable());
                labelFecha.setText(fechaActual());
                textoRut.setText("");
                labelNombreproveedor.setText("");
                groupFormapago.clearSelection();
                textoCantidadcuotas.setText("");
        }else{
            pedido = control.buscarPedido(numero);
            
            if(pedido == null){
                JOptionPane.showMessageDialog(null,"No hay factura de pedido");}
            else{
                if(pedido.getEstado().equals("Off")){
                    JOptionPane.showMessageDialog(null,"No puede cancelar un pedido registrado");

                    labelNumero.setText(pejc.idIncrementable());

                     limpiarTodosCampos();

            }else{
               //ELIMINAR DETALLES DE LA VENTA
                control.eliminarDetalles(numero);
                //ELIMINAR LA VENTA
                String mensaje = control.eliminarPedido(numero);
                JOptionPane.showMessageDialog(null, mensaje);
                //LIMPIAR TODOS LOS CAMPOS Y LA TABLA DE PRODUCTOS
                limpiarTodosCampos();

//                tablaProductos.setModel(modelo);
//                mostrarTabla(textoNumero.getText());

             

            }}}
    }//GEN-LAST:event_botonCancelarPedidoActionPerformed

    
    public class ManejadorBuscarProducto implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e){
        String codigo = textoCodigo.getText();
        if((textoCodigo.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de codigo");
        }else{
            codigo = textoCodigo.getText();
            Productos p = pjc.findProductos(codigo);
            if (p == null){
                textoCodigo.setText("");
                textoNombreproducto.setText("");
            }else
            {   textoCodigo.setText(p.getCodigo());
                textoNombreproducto.setText(p.getNombre());    
            }
        }}     
    }
    
    
    public class ManejadorBuscarProveedor implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e){
        String rut = textoRut.getText();
        if((textoRut.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de rut");
        }else{
            rut = textoRut.getText();
            Proveedores p = control.buscarProveedor(rut);
            
            if (p == null){
                textoRut.setText("");
                labelNombreproveedor.setText("");
            }else
            {   textoRut.setText(p.getRut());
                labelNombreproveedor.setText(p.getRazonSocial());    
            }
        }}     
    }
    
    public class ManejadorDevolverSubtotal implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e){
        try { 

           Subtotal();

        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(textoCosto, "Ingrese el costo del producto");
        }catch (Exception ex) {
                Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }}}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarProducto;
    private javax.swing.JButton BotonQuitarProducto;
    private javax.swing.JButton Igual;
    private javax.swing.JSpinner SpinnerCantidad;
    private javax.swing.JButton botonBuscarcompra;
    private javax.swing.JButton botonCancelarPedido;
    private javax.swing.JButton botonCrearPedido;
    private javax.swing.JButton botonModificarPedido;
    private javax.swing.JButton botonRegistrarcompra;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup groupFormapago;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombreproveedor;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JRadioButton radioContado;
    private javax.swing.JRadioButton radioCuotas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField textoCantidadcuotas;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoCosto;
    private javax.swing.JTextField textoNombreproducto;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JTextField textoRut;
    private javax.swing.JTextField textoSubtotal;
    private javax.swing.JTextField textoTotal;
    // End of variables declaration//GEN-END:variables
}
