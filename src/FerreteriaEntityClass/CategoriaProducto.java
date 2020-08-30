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
@Table(name = "CATEGORIA_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c")
    , @NamedQuery(name = "CategoriaProducto.findByNumero", query = "SELECT c FROM CategoriaProducto c WHERE c.numero = :numero")
    , @NamedQuery(name = "CategoriaProducto.findByNombre", query = "SELECT c FROM CategoriaProducto c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CategoriaProducto.findByDescripcion", query = "SELECT c FROM CategoriaProducto c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CategoriaProducto.findByIva", query = "SELECT c FROM CategoriaProducto c WHERE c.iva = :iva")
    , @NamedQuery(name = "CategoriaProducto.findByEstado", query = "SELECT c FROM CategoriaProducto c WHERE c.estado = :estado")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "IVA")
    private String iva;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Collection<Productos> productosCollection;

    public CategoriaProducto() {
    }

    public CategoriaProducto(String numero) {
        this.numero = numero;
    }

    public CategoriaProducto(String numero, String nombre, String descripcion, String iva, String estado) {
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.iva = iva;
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    
    @Override
    public String toString() {
        return nombre ;
    }
    

    
}
