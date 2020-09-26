package FerreteriaEntityClass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByNumero", query = "SELECT v FROM Ventas v WHERE v.numero = :numero")
    , @NamedQuery(name = "Ventas.findByFechaventa", query = "SELECT v FROM Ventas v WHERE v.fechaventa = :fechaventa")
    , @NamedQuery(name = "Ventas.findByDireccionenvio", query = "SELECT v FROM Ventas v WHERE v.direccionenvio = :direccionenvio")
    , @NamedQuery(name = "Ventas.findByEstado", query = "SELECT v FROM Ventas v WHERE v.estado = :estado")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "FECHAVENTA")
    private String fechaventa;
    @Basic(optional = false)
    @Column(name = "DIRECCIONENVIO")
    private String direccionenvio;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private Collection<DetalleVenta> detalleVentaCollection;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "RUT_NUIP")
    @ManyToOne
    private Clientes cliente;
    @JoinColumn(name = "EMPLEADO", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Empleados empleado;

    public Ventas() {
    }

    public Ventas(String numero) {
        this.numero = numero;
    }

    public Ventas(String numero, String fechaventa, String direccionenvio, String estado) {
        this.numero = numero;
        this.fechaventa = fechaventa;
        this.direccionenvio = direccionenvio;
        this.estado = estado;
    }

//    public int subtotal = 0;
//
//    public void calcularSubtotal(DetalleVenta venta){ 
//        int a,b;
//        a=Integer.parseInt(String.valueOf(venta.getProductos().getPrecio()));
//        b=Integer.parseInt(venta.getCantidad());
//        subtotal =  a * b;
//        }
//    
//    public int Subtotal(){return subtotal;}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getDireccionenvio() {
        return direccionenvio;
    }

    public void setDireccionenvio(String direccionenvio) {
        this.direccionenvio = direccionenvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<DetalleVenta> getDetalleVentaCollection() {
        return detalleVentaCollection;
    }

    public void setDetalleVentaCollection(Collection<DetalleVenta> detalleVentaCollection) {
        this.detalleVentaCollection = detalleVentaCollection;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

}
