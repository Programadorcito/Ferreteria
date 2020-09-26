package FerreteriaController;

import FerreteriaDAO.ClientesDAO;
import FerreteriaDAO.DetalleVentaDAO;
import FerreteriaDAO.EmpleadosDAO;
import FerreteriaDAO.ProductosDAO;
import FerreteriaDAO.VentasDAO;
import FerreteriaEntityClass.Clientes;
import FerreteriaEntityClass.Productos;
import FerreteriaEntityClass.Ventas;
import FerreteriaEntityClass.DetalleVenta;
import FerreteriaEntityClass.Empleados;
import javax.swing.JOptionPane;

public class VentasController {

    private EmpleadosDAO edao = new EmpleadosDAO();

    private VentasDAO vdao = new VentasDAO();
    private Ventas venta = new Ventas();

    private ClientesDAO cdao = new ClientesDAO();
    private Clientes cliente = new Clientes();

    private ProductosDAO pdao = new ProductosDAO();
    private Productos producto = new Productos();

    private DetalleVentaDAO dvdao = new DetalleVentaDAO();
    private DetalleVenta detalle = new DetalleVenta();

    private String mensaje = "";

    public Clientes buscarCliente(String rutnuip) {
        Clientes c = cdao.findClientes(rutnuip);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "El cliente con número " + rutnuip + " no está registrado");
        }
        return c;
    }

    public Empleados buscarEmpleado(String identificacion) {
        Empleados e = edao.findEmpleados(identificacion);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Empleado con identificación " + identificacion + " no está registrado");
        }
        return e;
    }

    public Productos buscarProducto(String codigo) {
        Productos e = pdao.findProductos(codigo);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Producto con codigo " + codigo + " no está registrado");
        }
        return e;
    }

    public String insertarVentas(String numero, String fecha, String direccion, Clientes cliente, Empleados empleado, String estado) {
        try {
            venta.setNumero(numero);
            venta.setFechaventa(fecha);
            venta.setDireccionenvio(direccion);
            venta.setCliente(cliente);
            venta.setEmpleado(empleado);
            venta.setEstado(estado);
            vdao.create(venta);
            mensaje = "Factura creada";
        } catch (Exception e) {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo crear la factura. \n" + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarVenta(String numero, String fecha, String direccion, Clientes cliente, Empleados empleado, String estado) {
        try {
            venta.setNumero(numero);
            venta.setFechaventa(fecha);
            venta.setDireccionenvio(direccion);
            venta.setCliente(cliente);
            venta.setEmpleado(empleado);
            venta.setEstado(estado);
            vdao.edit(venta);
            mensaje = "Factura modificada";
        } catch (Exception e) {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            mensaje = "No se pudo actualizar la información \n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarVenta(String numero) {
        try {
            vdao.destroy(numero);
            mensaje = "Proceso de venta cancelado";
        } catch (Exception e) {
            mensaje = "No se pudo cancelar la venta \n" + e.getMessage();
            System.out.println("Mensaje en cancelar venta: " + e.getMessage());

        }
        return mensaje;
    }

    public String insertarDetalleVenta(Productos producto, Ventas venta, String cantidad, String precioSalida, String estado) {
        try {
            detalle.setProductos(producto);
            detalle.setVentas(venta);
            detalle.setCantidad(cantidad);
            detalle.setPreciosalida(precioSalida);
            detalle.setEstado(estado);
            dvdao.create(detalle);
        } catch (Exception e) {
            System.out.println("DetalleVenta ya registrado ");
            mensaje = "No se pudo registrar el producto \n";
        }
        return mensaje;
    }

    public Ventas buscarVenta(String numero) {
        Ventas e = vdao.findVentas(numero);
        if (e == null) {
        }
        return e;
    }

    public void eliminarDetalles(String numero) {
        dvdao.eliminarDetalles(numero);
    }

    public void eliminarDetalle(String codigo) {
        dvdao.eliminarDetalle(codigo);
    }

}
