/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FerreteriaEntityClass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIN8
 */
@Entity
@Table(name = "PROVEEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByRut", query = "SELECT p FROM Proveedores p WHERE p.rut = :rut")
    , @NamedQuery(name = "Proveedores.findByRazonSocial", query = "SELECT p FROM Proveedores p WHERE p.razonSocial = :razonSocial")
    , @NamedQuery(name = "Proveedores.findByNombrecontacto", query = "SELECT p FROM Proveedores p WHERE p.nombrecontacto = :nombrecontacto")
    , @NamedQuery(name = "Proveedores.findByCargocontacto", query = "SELECT p FROM Proveedores p WHERE p.cargocontacto = :cargocontacto")
    , @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedores.findByCiudad", query = "SELECT p FROM Proveedores p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Proveedores.findByRubro", query = "SELECT p FROM Proveedores p WHERE p.rubro = :rubro")
    , @NamedQuery(name = "Proveedores.findByEmail", query = "SELECT p FROM Proveedores p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedores.findBySitioweb", query = "SELECT p FROM Proveedores p WHERE p.sitioweb = :sitioweb")
    , @NamedQuery(name = "Proveedores.findByEstado", query = "SELECT p FROM Proveedores p WHERE p.estado = :estado")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "NOMBRECONTACTO")
    private String nombrecontacto;
    @Basic(optional = false)
    @Column(name = "CARGOCONTACTO")
    private String cargocontacto;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "RUBRO")
    private String rubro;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SITIOWEB")
    private String sitioweb;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private Collection<Pedidos> pedidosCollection;

    public Proveedores() {
    }

    public Proveedores(String rut) {
        this.rut = rut;
    }

    public Proveedores(String rut, String razonSocial, String nombrecontacto, String cargocontacto, String direccion, String telefono, String ciudad, String rubro, String estado) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.nombrecontacto = nombrecontacto;
        this.cargocontacto = cargocontacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.rubro = rubro;
        this.estado = estado;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getCargocontacto() {
        return cargocontacto;
    }

    public void setCargocontacto(String cargocontacto) {
        this.cargocontacto = cargocontacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (rut != null ? rut.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Proveedores)) {
//            return false;
//        }
//        Proveedores other = (Proveedores) object;
//        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "FerreteriaEntityClass.Proveedores[ rut=" + rut + " ]";
//    }
    
}
