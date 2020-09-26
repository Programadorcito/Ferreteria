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
@Table(name = "PEDIDOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByNumero", query = "SELECT p FROM Pedidos p WHERE p.numero = :numero")
    , @NamedQuery(name = "Pedidos.findByFechapedido", query = "SELECT p FROM Pedidos p WHERE p.fechapedido = :fechapedido")
    , @NamedQuery(name = "Pedidos.findByFormapago", query = "SELECT p FROM Pedidos p WHERE p.formapago = :formapago")
    , @NamedQuery(name = "Pedidos.findByCuotas", query = "SELECT p FROM Pedidos p WHERE p.cuotas = :cuotas")
    , @NamedQuery(name = "Pedidos.findByEstado", query = "SELECT p FROM Pedidos p WHERE p.estado = :estado")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "FECHAPEDIDO")
    private String fechapedido;
    @Basic(optional = false)
    @Column(name = "FORMAPAGO")
    private String formapago;
    @Basic(optional = false)
    @Column(name = "CUOTAS")
    private String cuotas;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos")
    private Collection<DetallePedido> detallePedidoCollection;
    @JoinColumn(name = "PROVEEDOR", referencedColumnName = "RUT")
    @ManyToOne(optional = false)
    private Proveedores proveedor;

    public Pedidos() {
    }

    public Pedidos(String numero) {
        this.numero = numero;
    }

    public Pedidos(String numero, String fechapedido, String formapago, String cuotas, String estado) {
        this.numero = numero;
        this.fechapedido = fechapedido;
        this.formapago = formapago;
        this.cuotas = cuotas;
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getCuotas() {
        return cuotas;
    }

    public void setCuotas(String cuotas) {
        this.cuotas = cuotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<DetallePedido> getDetallePedidoCollection() {
        return detallePedidoCollection;
    }

    public void setDetallePedidoCollection(Collection<DetallePedido> detallePedidoCollection) {
        this.detallePedidoCollection = detallePedidoCollection;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

}
