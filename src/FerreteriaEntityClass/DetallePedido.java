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
@Table(name = "DETALLE_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")
    , @NamedQuery(name = "DetallePedido.findByCostoproducto", query = "SELECT d FROM DetallePedido d WHERE d.costoproducto = :costoproducto")
    , @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallePedido.findByProducto", query = "SELECT d FROM DetallePedido d WHERE d.detallePedidoPK.producto = :producto")
    , @NamedQuery(name = "DetallePedido.findByPedido", query = "SELECT d FROM DetallePedido d WHERE d.detallePedidoPK.pedido = :pedido")
    , @NamedQuery(name = "DetallePedido.findByEstado", query = "SELECT d FROM DetallePedido d WHERE d.estado = :estado")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePedidoPK detallePedidoPK;
    @Basic(optional = false)
    @Column(name = "COSTOPRODUCTO")
    private String costoproducto;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private String cantidad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "PEDIDO", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public DetallePedido() {
    }

    public DetallePedido(DetallePedidoPK detallePedidoPK) {
        this.detallePedidoPK = detallePedidoPK;
    }

    public DetallePedido(DetallePedidoPK detallePedidoPK, String costoproducto, String cantidad, String estado) {
        this.detallePedidoPK = detallePedidoPK;
        this.costoproducto = costoproducto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public DetallePedido(String producto, String pedido) {
        this.detallePedidoPK = new DetallePedidoPK(producto, pedido);
    }

    public DetallePedidoPK getDetallePedidoPK() {
        return detallePedidoPK;
    }

    public void setDetallePedidoPK(DetallePedidoPK detallePedidoPK) {
        this.detallePedidoPK = detallePedidoPK;
    }

    public String getCostoproducto() {
        return costoproducto;
    }

    public void setCostoproducto(String costoproducto) {
        this.costoproducto = costoproducto;
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

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

}
