package FerreteriaEntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallePedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRODUCTO")
    private String producto;
    @Basic(optional = false)
    @Column(name = "PEDIDO")
    private String pedido;

    public DetallePedidoPK() {
    }

    public DetallePedidoPK(String producto, String pedido) {
        this.producto = producto;
        this.pedido = pedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

}
