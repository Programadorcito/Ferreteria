package FerreteriaEntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DETALLE_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleVenta.findByProducto", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.producto = :producto")
    , @NamedQuery(name = "DetalleVenta.findByVenta", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.venta = :venta")
    , @NamedQuery(name = "DetalleVenta.findByEstado", query = "SELECT d FROM DetalleVenta d WHERE d.estado = :estado")
    , @NamedQuery(name = "DetalleVenta.findByPreciosalida", query = "SELECT d FROM DetalleVenta d WHERE d.preciosalida = :preciosalida")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaPK detalleVentaPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private String cantidad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "PRECIOSALIDA")
    private String preciosalida;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "VENTA", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK, String cantidad, String estado, String preciosalida) {
        this.detalleVentaPK = detalleVentaPK;
        this.cantidad = cantidad;
        this.estado = estado;
        this.preciosalida = preciosalida;
    }

    public DetalleVenta(String producto, String venta) {
        this.detalleVentaPK = new DetalleVentaPK(producto, venta);
    }

    public DetalleVentaPK getDetalleVentaPK() {
        return detalleVentaPK;
    }

    public void setDetalleVentaPK(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPreciosalida() {
        return preciosalida;
    }

    public void setPreciosalida(String preciosalida) {
        this.preciosalida = preciosalida;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

}
