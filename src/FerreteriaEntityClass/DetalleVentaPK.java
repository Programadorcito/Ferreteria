package FerreteriaEntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRODUCTO")
    private String producto;
    @Basic(optional = false)
    @Column(name = "VENTA")
    private String venta;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(String producto, String venta) {
        this.producto = producto;
        this.venta = venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

}
