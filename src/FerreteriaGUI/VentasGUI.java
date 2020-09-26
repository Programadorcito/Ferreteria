package FerreteriaGUI;

import FerreteriaDAO.ClientesDAO;
import FerreteriaDAO.DetalleVentaDAO;
import FerreteriaDAO.EmpleadosDAO;
import FerreteriaDAO.ProductosDAO;
import FerreteriaController.VentasController;
import FerreteriaDAO.VentasDAO;
import FerreteriaEntityClass.Clientes;
import FerreteriaEntityClass.DetalleVenta;
import FerreteriaEntityClass.Empleados;
import FerreteriaEntityClass.Productos;
import FerreteriaEntityClass.Ventas;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.TableColumnModel;

public class VentasGUI extends javax.swing.JFrame {
    

    private VentasController control = new VentasController();
    private Ventas v = new Ventas();
    private VentasDAO vjc = new VentasDAO();
    private DetalleVentaDAO ddao = new DetalleVentaDAO();
    private ProductosDAO pdao = new ProductosDAO();
    private EmpleadosDAO edao = new EmpleadosDAO();
    private ClientesDAO cjc = new ClientesDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    private String mensaje = "";

    Empleados e = new Empleados();
    Clientes c = new Clientes();
    Productos p = new Productos();
    DetalleVenta dv = new DetalleVenta();


    public VentasGUI() {
        initComponents();
        
        this.setTitle("Formulario de Ventas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        labelFecha.setText(fechaActual());
        labelNumero.setText(vjc.idIncrementable());
    
        ManejadorBuscarEmpleado p = new ManejadorBuscarEmpleado();
        textoIdentificacion.addActionListener(p);

                String Dato[] = new String [6];
                modelo.addColumn("CODIGO"); 
                modelo.addColumn("NOMBRE"); 
                modelo.addColumn("PRECIO");
                modelo.addColumn("UNIDAD MEDIDA");
                modelo.addColumn("CANTIDAD");
                modelo.addColumn("SUBTOTAL"); 
                tablaProductos.setModel(modelo);
    }

    public void holders(){ 
    }
    
    
    public static String fechaActual(){
        Date fecha= new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
    }
    
    private void ListarDetalles(String numero){
        ddao.listarDetalles(tablaProductos, numero);
      
        TableColumnModel columnModel = tablaProductos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(15);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setPreferredWidth(5);
        columnModel.getColumn(5).setPreferredWidth(15);
    }
    

    private void limpiarTodosCampos() {
        textoNumero.setText("");
        textoIdentificacion.setText("");
        labelNombrevendedor.setText("");
        textoRutnuip.setText("");
        textoNombrecliente.setText("");
        textoDireccion.setText("");
        textoCodigo.setText("");
        textoNombreproducto.setText("");
        textoUnidadmedida.setText("");
        textoStock.setText("");
        textoPrecio.setText("");
        textoSubtotal.setText("");
        textoTotal.setText("");
        tablaProductos.setModel(modelo);

        int a =modelo.getRowCount()-1;
        System.out.println(a);
        for(int i=a; i>=0; i--){
        System.out.println(i);
        modelo.removeRow(i );
        }               
    }
 
    private void actualizarStock(String codigo){
        pdao.mostrarStock(codigo);
    }
    
    
    private void RegistrarVenta(String numero) {
        vjc.registrarVenta(numero);
    }
    

    
    void limpiartabla(){
    int a =modelo.getRowCount()-1;
    System.out.println(a);
    for(int i=a; i>=0; i--)
    {System.out.println(i);
    modelo.removeRow(i );}
    }
    
    public void Subtotal(){ 
        String codigo = textoCodigo.getText();
        Productos p = pdao.findProductos(codigo);
        
        String n2;
        int a,b,subtotal = 0;
        textoPrecio.setText(String.valueOf(p.getPrecio()));
        n2= SpinnerCantidad.getValue().toString();
        a=Integer.parseInt(String.valueOf(p.getPrecio()));
        b=Integer.parseInt(n2);
        subtotal =  a * b;
        textoSubtotal.setText(Integer.toString(subtotal));
        }

    public void sumarTotal(){
        int fila = 0;
        int total = 0;
        for (int i = 0; i < tablaProductos.getRowCount(); i++){
           fila = Integer.parseInt(tablaProductos.getValueAt(i,5).toString());
           total += fila;
        }
        textoTotal.setText(Integer.toString(total));
    }
    
    public void restarTotal(){
        int fila = 0;
        int total = 0;
        for (int i = 0; i < tablaProductos.getRowCount(); i++){
           fila = Integer.parseInt(tablaProductos.getValueAt(i,5).toString());
           total -= fila * - 1;
        }
        textoTotal.setText(Integer.toString(total));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupEnvio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonBuscarproducto = new javax.swing.JButton();
        textoCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Igual = new javax.swing.JButton();
        SpinnerCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textoNombreproducto = new javax.swing.JLabel();
        textoUnidadmedida = new javax.swing.JLabel();
        textoStock = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JLabel();
        textoSubtotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonBuscarcliente = new javax.swing.JButton();
        textoRutnuip = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        textoNombrecliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonRegistrarventa = new javax.swing.JButton();
        BotonQuitarproducto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        textoTotal = new javax.swing.JTextField();
        botonAgregarproducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textoIdentificacion = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        botonBuscarventa = new javax.swing.JButton();
        botonCrearfactura = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        botonEditarfactura = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        botonCancelarfactura = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        labelNombrevendedor = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bill 64x64.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 70, 80));

        jPanel2.setBackground(new java.awt.Color(222, 227, 227));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Código:");

        botonBuscarproducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscarproducto.setText("Buscar");
        botonBuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarproductoActionPerformed(evt);
            }
        });

        textoCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCodigoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Precio:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Cantidad:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Subtotal:");

        Igual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Igual.setText("=");
        Igual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IgualActionPerformed(evt);
            }
        });

        SpinnerCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Medida:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Stock:");

        textoNombreproducto.setBackground(new java.awt.Color(0, 0, 0));
        textoNombreproducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNombreproducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNombreproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        textoUnidadmedida.setBackground(new java.awt.Color(0, 0, 0));
        textoUnidadmedida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoUnidadmedida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoUnidadmedida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        textoStock.setBackground(new java.awt.Color(0, 0, 0));
        textoStock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        textoPrecio.setBackground(new java.awt.Color(0, 0, 0));
        textoPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        textoSubtotal.setBackground(new java.awt.Color(0, 0, 0));
        textoSubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Igual))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel11)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(textoUnidadmedida, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoNombreproducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonBuscarproducto)))
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscarproducto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoNombreproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel4)
                        .addComponent(textoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textoUnidadmedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(3, 3, 3))
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Igual)
                            .addComponent(SpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 390, 210));

        jPanel4.setBackground(new java.awt.Color(227, 231, 231));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Rut/Nuip:");

        botonBuscarcliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscarcliente.setText("Buscar");
        botonBuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarclienteActionPerformed(evt);
            }
        });

        textoRutnuip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoRutnuip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoRutnuipKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Dirección de envío:");

        textoDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("*");

        textoNombrecliente.setBackground(new java.awt.Color(0, 0, 0));
        textoNombrecliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNombrecliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNombrecliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textoDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoRutnuip, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscarcliente)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(textoNombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoRutnuip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarcliente)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(textoNombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 380, 180));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO", "UNIDAD MEDIDA", "CANTIDAD", "SUBTOTAL"
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
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(15);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(25);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(15);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 780, 130));

        botonRegistrarventa.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        botonRegistrarventa.setText("Registrar Venta");
        botonRegistrarventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botonRegistrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarventaActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 190, 30));

        BotonQuitarproducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BotonQuitarproducto.setText("Quitar producto");
        BotonQuitarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonQuitarproductoActionPerformed(evt);
            }
        });
        jPanel1.add(BotonQuitarproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, -1, 30));

        textoTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(textoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 110, -1));

        botonAgregarproducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonAgregarproducto.setText("Agregar Producto");
        botonAgregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarproductoActionPerformed(evt);
            }
        });
        jPanel1.add(botonAgregarproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 780, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Vendedor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        textoIdentificacion.setBackground(new java.awt.Color(204, 255, 255));
        textoIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoIdentificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoIdentificacionKeyTyped(evt);
            }
        });
        jPanel1.add(textoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Consultar Venta:");

        textoNumero.setBackground(new java.awt.Color(204, 255, 255));
        textoNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(textoNumero))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 140, 70));

        botonBuscarventa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonBuscarventa.setText("Buscar ");
        botonBuscarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarventaActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 140, -1));

        botonCrearfactura.setBackground(new java.awt.Color(204, 255, 255));
        botonCrearfactura.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        botonCrearfactura.setText("Crear Venta");
        botonCrearfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearfacturaActionPerformed(evt);
            }
        });
        jPanel1.add(botonCrearfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("PRODUCTO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("CLIENTE:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel21.setText("Campo opcional ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        botonEditarfactura.setBackground(new java.awt.Color(204, 255, 255));
        botonEditarfactura.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        botonEditarfactura.setText("Modificar");
        botonEditarfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarfacturaActionPerformed(evt);
            }
        });
        jPanel1.add(botonEditarfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 130, -1));

        labelFecha.setBackground(new java.awt.Color(204, 255, 255));
        labelFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 120, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        labelNumero.setBackground(new java.awt.Color(204, 255, 255));
        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Número:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        botonCancelarfactura.setBackground(new java.awt.Color(204, 255, 255));
        botonCancelarfactura.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        botonCancelarfactura.setText("Cancelar");
        botonCancelarfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarfacturaActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelarfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 340, 110, -1));

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
        jPanel1.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, -1));

        jLabel25.setText("Identificación:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel26.setText("Nombre del vendedor:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        labelNombrevendedor.setBackground(new java.awt.Color(204, 255, 255));
        labelNombrevendedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNombrevendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombrevendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));
        jPanel1.add(labelNombrevendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonQuitarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonQuitarproductoActionPerformed
 
    if(
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (textoUnidadmedida.getText().length()==0)||
            (SpinnerCantidad.getValue().toString().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Seleccione el producto que desea quitar \n ");}  
        else{   
        
        String numero = textoNumero.getText();
        v = control.buscarVenta(numero);

        if(v.getEstado().equals("Off")){
            JOptionPane.showMessageDialog(null,"No puede quitar productos de una venta registrada");
        }else{
        if((textoNumero.getText().length()==0)||
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos deben estár llenos \n Haga la busqueda con el número de compra");
            textoNumero.setText("");
            textoCodigo.setText("");
            textoNombreproducto.setText("");
            textoPrecio.setText("");
            textoSubtotal.setText("");
        }else
        {
            String codigo = textoCodigo.getText();
            control.eliminarDetalle(codigo);

            tablaProductos.setModel(modelo);
            ListarDetalles(textoNumero.getText());
            restarTotal();
            textoStock.setText(pdao.mostrarStock(codigo));
        }}}
    }//GEN-LAST:event_BotonQuitarproductoActionPerformed

    private void botonRegistrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarventaActionPerformed
        modelo.setRowCount(0);
        
        String numero = labelNumero.getText();
        
        if(
            (labelNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoIdentificacion.getText().length()==0)||
            (labelNombrevendedor.getText().length()==0)||
            (tablaProductos.getRowCount()==0 && tablaProductos.getSelectedRow()==-1)   
                ){
            JOptionPane.showMessageDialog(null,"Los campos deben estar llenos y debe \n haber al menos un detalle de venta");}
    
        else
        {
            if(v.getEstado().equals("Off")){
            JOptionPane.showMessageDialog(null,"Esta venta ya esta registrada");}
            else
            {
            
                int confirmacion = JOptionPane.showConfirmDialog(null, "Desea registrar esta venta?");
                if (confirmacion == JOptionPane.YES_OPTION)
                {   
                RegistrarVenta(labelNumero.getText());
                JOptionPane.showMessageDialog(null, "Venta registrada");
                        labelNumero.setText(vjc.idIncrementable());

                        limpiarTodosCampos();
                }
                if (confirmacion == JOptionPane.NO_OPTION)
                {

                    JOptionPane.showMessageDialog(null,"Venta NO registrada \n ");

                    control.eliminarDetalles(numero);
                    control.eliminarVenta(numero);

                    textoIdentificacion.setText(""); 
                    labelNombrevendedor.setText("");
                    textoRutnuip.setText("");
                    textoNombrecliente.setText("");
                    groupEnvio.clearSelection();
                    textoDireccion.setText("");

                    textoCodigo.setText("");
                    textoNombreproducto.setText("");
                    textoPrecio.setText("");
                    textoUnidadmedida.setText("");
                    textoStock.setText("");
                    textoSubtotal.setText("");
                    tablaProductos.setModel(modelo);

                }
                if (confirmacion == JOptionPane.CANCEL_OPTION)
                {
    //                JOptionPane.showMessageDialog(null,"Pedido NO registrado \n ");
                }
        
            }
        }
    }//GEN-LAST:event_botonRegistrarventaActionPerformed

    private void botonBuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarclienteActionPerformed
        String rutnuip = textoRutnuip.getText();
        if((textoRutnuip.getText().length()==0)){
                JOptionPane.showMessageDialog(null,"Ingrese el número de rut o nuip");
            }else{
                rutnuip = textoRutnuip.getText();
                c = control.buscarCliente(rutnuip);
                if (c == null){
                    textoRutnuip.setText("");
                    textoNombrecliente.setText("");
                    }else{       
                    textoRutnuip.setText(c.getRutNuip());
                    textoNombrecliente.setText(c.getNombre()); 
                    }
                }
    }//GEN-LAST:event_botonBuscarclienteActionPerformed

    private void botonBuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarproductoActionPerformed
                String codigo = textoCodigo.getText();
                if((textoCodigo.getText().length()==0)){
                        JOptionPane.showMessageDialog(null,"Ingrese el código del producto");
                    }else{
                        codigo = textoCodigo.getText();
                        p = control.buscarProducto(codigo);
                        if (p == null){
                            JOptionPane.showMessageDialog(null,"Producto con codigo " +codigo+ " no existe");
                                textoCodigo.setText("");
                                textoNombreproducto.setText("");
                                textoUnidadmedida.setText("");
                                textoStock.setText("");
                                textoPrecio.setText("");
                            }else
                        {       textoNombreproducto.setText(p.getNombre());
                                textoUnidadmedida.setText(p.getUnidadmedida());
                                textoStock.setText(String.valueOf(pdao.mostrarStock(codigo)));
                                textoPrecio.setText(String.valueOf(p.getPrecio()));  
                        }
                    }
    }//GEN-LAST:event_botonBuscarproductoActionPerformed

    private void botonAgregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarproductoActionPerformed

  if(
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (textoUnidadmedida.getText().length()==0)||
            (SpinnerCantidad.getValue().toString().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos del producto deben estar llenos \n ");}  
        else{ 
        
        modelo.setRowCount(0);
        textoTotal.setText("");
        String numero = labelNumero.getText();
        v = control.buscarVenta(numero);

//    JOptionPane.showMessageDialog(null,"Los campos deben estar llenos");
    
    if(v == null){
        JOptionPane.showMessageDialog(null,"Debe crear una factura para poder ingresar los detalles");
    }else
   
    {
    if(v.getEstado().equals("Off")){
        JOptionPane.showMessageDialog(null,"No puede agregar productos a una venta registrada");
                textoNumero.setText(""); 
                labelNumero.setText(vjc.idIncrementable());
                labelFecha.setText(fechaActual());
                textoIdentificacion.setText(""); 
                labelNombrevendedor.setText("");
                textoRutnuip.setText("");
                textoNombrecliente.setText("");
                groupEnvio.clearSelection();
                textoDireccion.setText("");
                tablaProductos.setModel(modelo);
                
    }else{
        if(
            (textoCodigo.getText().length()==0)||
            (textoNombreproducto.getText().length()==0)||
            (textoPrecio.getText().length()==0)||
            (SpinnerCantidad.getValue().toString().length()==0)||
            (textoSubtotal.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos deben estár llenos \n ");
            textoNumero.setText("");
            textoCodigo.setText("");
            textoNombreproducto.setText("");
            textoPrecio.setText("");
            textoSubtotal.setText("");
        }else
        {
            textoNumero.setText(v.getNumero());

            String cantidad = null;
            String n2;
            int a,b;
            textoStock.setText(String.valueOf(p.getStock()));
            n2= SpinnerCantidad.getValue().toString();
            a=Integer.parseInt(String.valueOf(p.getStock()));
            b=Integer.parseInt(n2);
            if (b > a) {
                JOptionPane.showMessageDialog(null,"La cantidad no puede ser mayor al stock");
            } else if (b <= a) {
                cantidad = SpinnerCantidad.getValue().toString();
            }

            String precioSalida = textoPrecio.getText();
                String [] dato = new String[6];
                dato[0] = textoCodigo.getText();
                dato[1] = textoNombreproducto.getText();
                dato[2] = textoPrecio.getText();
                dato[3] = textoUnidadmedida.getText();
                dato[4] = SpinnerCantidad.getValue().toString();
                dato[5] = textoSubtotal.getText();

                modelo.addRow(dato);
                tablaProductos.setModel(modelo);

                //INSERTAR DETALLE A LA VENTA
                control.insertarDetalleVenta(p, v, cantidad, precioSalida, "On");

                
                    textoCodigo.setText("");
                    textoNombreproducto.setText("");
                    textoUnidadmedida.setText("");
                    textoStock.setText("");
                    textoPrecio.setText("");
                    textoSubtotal.setText("");

                    tablaProductos.setModel(modelo);
                    ListarDetalles(textoNumero.getText());
                    sumarTotal();

        }}}}



    }//GEN-LAST:event_botonAgregarproductoActionPerformed

    private void botonBuscarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarventaActionPerformed
        modelo.setRowCount(0);
      
        String numero = textoNumero.getText();
        if((textoNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el número de factura");
        }else{
            numero = textoNumero.getText();
            v = control.buscarVenta(numero);
            
            if (v == null){
                JOptionPane.showMessageDialog(null,"Venta con numero " + numero + " no está registrado");

                //LIMPIAR CAMPOS:
                labelNumero.setText(vjc.idIncrementable());
                labelFecha.setText(fechaActual());
                
                limpiarTodosCampos();

            }else
            {   
                textoNumero.setText(v.getNumero());
                labelNumero.setText(v.getNumero());
                labelFecha.setText(v.getFechaventa());
                textoIdentificacion.setText(v.getEmpleado().getIdentificacion()); 
                labelNombrevendedor.setText(v.getEmpleado().getNombres());

                if(v.getCliente() == null){
                    textoRutnuip.setText("--");
                }else{
                textoRutnuip.setText(v.getCliente().getRutNuip());}
                
                if(v.getCliente() == null){
                    textoNombrecliente.setText("--");
                }else{
                textoNombrecliente.setText(v.getCliente().getNombre());}

                textoDireccion.setText(v.getDireccionenvio());
                
                textoCodigo.setText("");
                textoNombreproducto.setText("");
                textoPrecio.setText("");
                textoUnidadmedida.setText("");
                textoStock.setText("");
                textoSubtotal.setText("");
                tablaProductos.setModel(modelo);
                
                ListarDetalles(textoNumero.getText());
                sumarTotal();
                
            }

        }
    }//GEN-LAST:event_botonBuscarventaActionPerformed

    private void botonCrearfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearfacturaActionPerformed
        if ((labelNumero.getText().length()==0)||
            (labelFecha.getText().length()==0)||
            (textoIdentificacion.getText().length()==0)||
            (labelNombrevendedor.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos del vendedor deben estar llenos");
        }else{
            String numero = "";
                if(labelNumero.getText().length()!=1){
                    numero = "1";
                }else{
                    numero = labelNumero.getText();
                }

                if(textoRutnuip.getText().length()==0){
                c = null;
                }else{
                 textoRutnuip.setText(c.getRutNuip());
                }

                String direccion = "";
                if(textoDireccion.getText().length()==0){
                    direccion = "- - -";
                }else{
                    direccion = textoDireccion.getText();
                }

                String mensaje = "";
                mensaje = control.insertarVentas(numero, labelFecha.getText(), direccion, c, e, "On");
                JOptionPane.showMessageDialog(null, mensaje);
        }   
            
    }//GEN-LAST:event_botonCrearfacturaActionPerformed

    private void IgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IgualActionPerformed
        if(textoPrecio.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Agregue el precio por medio de la busqueda del producto");
        }else{
        Subtotal();
        }
    }//GEN-LAST:event_IgualActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int select = tablaProductos.getSelectedRow();
        textoCodigo.setText(tablaProductos.getValueAt(select, 0)+"");
        textoNombreproducto.setText(tablaProductos.getValueAt(select, 1)+"");
        textoPrecio.setText(tablaProductos.getValueAt(select, 2)+"");
        textoUnidadmedida.setText(tablaProductos.getValueAt(select, 3)+"");
        SpinnerCantidad.setValue(Integer.parseInt((tablaProductos.getValueAt(select, 4)+""))); 
        textoSubtotal.setText(tablaProductos.getValueAt(select, 5)+"");
        
        String codigo = textoCodigo.getText();
        textoStock.setText(pdao.mostrarStock(codigo));
        
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void botonEditarfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarfacturaActionPerformed

        if((textoIdentificacion.getText().length()==0)||
            (labelNombrevendedor.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Los campos del vendedor deben estar llenos");
        }else{
            
            String numero = labelNumero.getText();
            v = control.buscarVenta(numero);
            
            if(v == null){
            JOptionPane.showMessageDialog(null,"No hay factura guardada para modificar");}
            else{
            
            if(v.getEstado().equals("Off")){
            JOptionPane.showMessageDialog(null,"No puede modificar una venta registrada");}
            else{

                if(textoRutnuip.getText().length()==0){
                c = null;
                }else{
                textoRutnuip.setText(c.getRutNuip());
                }
                
                String direccion = "";
                if(textoDireccion.getText().length()==0){
                    direccion = "- - -";
                }else{
                    direccion = textoDireccion.getText();
                }

                String mensaje = "";
                mensaje = control.actualizarVenta(numero, labelFecha.getText(), direccion, c, e, "On");
                JOptionPane.showMessageDialog(null, mensaje);

        }}}


    }//GEN-LAST:event_botonEditarfacturaActionPerformed

    private void botonCancelarfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarfacturaActionPerformed
        String numero = labelNumero.getText();
        if((labelNumero.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"No hay factura de venta \n ");
                textoIdentificacion.setText(""); 
                labelNombrevendedor.setText("");
                textoRutnuip.setText("");
                textoNombrecliente.setText("");
                textoDireccion.setText("");
        }else{
            v = control.buscarVenta(numero);

            if(v == null){
                JOptionPane.showMessageDialog(null,"No hay factura de venta");}
            else{
                if(v.getEstado().equals("Off")){
                    JOptionPane.showMessageDialog(null,"No puede cancelar una venta registrada");

                    labelNumero.setText(vjc.idIncrementable());

                    limpiarTodosCampos();
            }else{
            //ELIMINAR DETALLES DE LA VENTA
//            eliminarDetalles(labelNumero.getText());
            control.eliminarDetalles(numero);
            //ELIMINAR LA VENTA
            String mensaje = control.eliminarVenta(numero);
            JOptionPane.showMessageDialog(null, mensaje);
            //LIMPIAR TODOS LOS CAMPOS Y LA TABLA DE PRODUCTOS
            limpiarTodosCampos();
                
        }}}
    }//GEN-LAST:event_botonCancelarfacturaActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        String numero = labelNumero.getText();
        v = control.buscarVenta(numero);

        if(v == null){
        hide();
        }else
        {
          if(v.getEstado().equals("Off")){
          hide();
          }else
          {
            if(v.getEstado().equals("On"))    
            {

            int confirmacion = JOptionPane.showConfirmDialog(null, "Si sale sin Registrar la Venta se perderán los datos. \n Desea salir?");

            if (confirmacion == JOptionPane.YES_OPTION)
            {   
                control.eliminarDetalles(numero);
                control.eliminarVenta(numero);
                
                labelNumero.setText(vjc.idIncrementable());

                limpiarTodosCampos();
                hide();
            }
            if (confirmacion == JOptionPane.CANCEL_OPTION)
            {
//                JOptionPane.showMessageDialog(null,"Pedido NO registrado \n ");
            }
            }else{
                if(v.getEstado().equals(null)){
                 hide();
                }
            }
          }
        }
    }//GEN-LAST:event_botonSalirActionPerformed

    private void textoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNumeroKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
    }//GEN-LAST:event_textoNumeroKeyTyped

    private void textoIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIdentificacionKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)&&(c != KeyEvent.VK_ENTER)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
    }//GEN-LAST:event_textoIdentificacionKeyTyped

    private void textoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCodigoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
    }//GEN-LAST:event_textoCodigoKeyTyped

    private void textoRutnuipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoRutnuipKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')&&(c != KeyEvent.VK_BACKSPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingresar números");
        }
    }//GEN-LAST:event_textoRutnuipKeyTyped

 
    public class ManejadorBuscarEmpleado implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent ex){
        String Id = textoIdentificacion.getText();
        if((textoIdentificacion.getText().length()==0)){
            JOptionPane.showMessageDialog(null,"Ingrese el n° de identificacion");
        }else{
            Id = textoIdentificacion.getText();
            e = control.buscarEmpleado(Id);
            if (e == null){
                textoIdentificacion.setText("");
                labelNombrevendedor.setText("");
            }else
            {    
            if(e.getEstado().equals("Off")){
            JOptionPane.showMessageDialog(null,"Este empleado esta inhabilitado");
            textoIdentificacion.setText("");
            labelNombrevendedor.setText("");}
            else  
            {   textoIdentificacion.setText(e.getIdentificacion());
                labelNombrevendedor.setText(e.getNombres());    
            }
        }} }    
    }


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonQuitarproducto;
    private javax.swing.JButton Igual;
    private javax.swing.JSpinner SpinnerCantidad;
    private javax.swing.JButton botonAgregarproducto;
    private javax.swing.JButton botonBuscarcliente;
    private javax.swing.JButton botonBuscarproducto;
    private javax.swing.JButton botonBuscarventa;
    private javax.swing.JButton botonCancelarfactura;
    private javax.swing.JButton botonCrearfactura;
    private javax.swing.JButton botonEditarfactura;
    private javax.swing.JButton botonRegistrarventa;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup groupEnvio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombrevendedor;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoIdentificacion;
    private javax.swing.JLabel textoNombrecliente;
    private javax.swing.JLabel textoNombreproducto;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JTextField textoRutnuip;
    private javax.swing.JLabel textoStock;
    private javax.swing.JLabel textoSubtotal;
    private javax.swing.JTextField textoTotal;
    private javax.swing.JLabel textoUnidadmedida;
    // End of variables declaration//GEN-END:variables

}
