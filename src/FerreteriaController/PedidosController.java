package FerreteriaController;

import FerreteriaDAO.DetallePedidoDAO;
import FerreteriaDAO.PedidosDAO;
import FerreteriaDAO.ProductosDAO;
import FerreteriaDAO.ProveedoresDAO;
import FerreteriaEntityClass.DetallePedido;
import FerreteriaEntityClass.Pedidos;
import FerreteriaEntityClass.Productos;
import FerreteriaEntityClass.Proveedores;
import javax.swing.JOptionPane;

public class PedidosController {

    private Pedidos pedido = new Pedidos();
    private PedidosDAO pdao = new PedidosDAO();
    private DetallePedidoDAO dpdao = new DetallePedidoDAO();
    private DetallePedido detalle = new DetallePedido();
    private ProveedoresDAO prodao = new ProveedoresDAO();
    private ProductosDAO prdao = new ProductosDAO();

    private String mensaje = "";

    public String insertarPedidos(String numero, String fecha, String pago, String cuotas, Proveedores proveedor, String estado) {
        try {
            pedido.setNumero(numero);
            pedido.setFechapedido(fecha);
            pedido.setFormapago(pago);
            pedido.setCuotas(cuotas);
            pedido.setProveedor(proveedor);
            pedido.setEstado(estado);
            pdao.create(pedido);
            mensaje = "Pedido creado";
        } catch (Exception e) {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo crear la factura. \n" + e.getMessage();
        }
        return mensaje;
    }

    //        try {
//            pdao.create(pedido);
//            mensaje = "Pedido registrado";
//            JOptionPane.showMessageDialog(null, "Pedido registrado");
//        } catch (Exception e) {
//            System.out.println("Mensaje en guardar: " + e.getMessage());
//            mensaje = "No se pudo registrar el Pedido. \n" + e.getMessage();  
//            JOptionPane.showMessageDialog(null, "No se pudo registrar el Pedido. \n" + e.getMessage());
//        }
    public String actualizarPedido(String numero, String fecha, String pago, String cuotas, Proveedores proveedor, String estado) {
        try {
            pedido.setNumero(numero);
            pedido.setFechapedido(fecha);
            pedido.setFormapago(pago);
            pedido.setCuotas(cuotas);
            pedido.setProveedor(proveedor);
            pedido.setEstado(estado);
            pdao.edit(pedido);
            mensaje = "Pedido modificado";
        } catch (Exception e) {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            mensaje = "No se pudo actualizar la información. \n" + e.getMessage();
        }
        return mensaje;
    }

    public String insertarDetallePedido(Pedidos pedido, Productos producto, String costoproducto, String cantidad, String estado) {
        try {
            detalle.setPedidos(pedido);
            detalle.setProductos(producto);
            detalle.setCostoproducto(costoproducto);
            detalle.setCantidad(cantidad);
            detalle.setEstado(estado);
            dpdao.create(detalle);
        } catch (Exception e) {
            System.out.println("DetallePedido ya registrado ");
            mensaje = "No se pudo registrar el producto \n";
        }
        return mensaje;
    }

    public Pedidos buscarPedido(String numero) {
        Pedidos e = pdao.findPedidos(numero);
        if (e == null) {
        }
        return e;
    }

    public Proveedores buscarProveedor(String rut) {
        Proveedores e = prodao.findProveedores(rut);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Proveedor con con rut " + rut + " no está registrado");
        }
        return e;
    }
    
    public Productos buscarProducto(String codigo) {
        Productos e = prdao.findProductos(codigo);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Producto con codigo " + codigo + " no está registrado");
        }
        return e;
    }

    public void eliminarDetalles(String numero) {
        dpdao.eliminarDetalles(numero);
    }

    public void eliminarDetalle(String codigo) {
        dpdao.eliminarDetalle(codigo);
    }

    public String eliminarPedido(String numero) {
        try {
            pdao.destroy(numero);
            mensaje = "Proceso de pedido cancelado";
        } catch (Exception e) {
            mensaje = "No se pudo cancelar el pedido \n" + e.getMessage();
            System.out.println("Mensaje en cancelar pedido: " + e.getMessage());

        }
        return mensaje;
    }
}
