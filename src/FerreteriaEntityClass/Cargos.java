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
@Table(name = "CARGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c")
    , @NamedQuery(name = "Cargos.findByNumero", query = "SELECT c FROM Cargos c WHERE c.numero = :numero")
    , @NamedQuery(name = "Cargos.findByNombre", query = "SELECT c FROM Cargos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cargos.findBySalario", query = "SELECT c FROM Cargos c WHERE c.salario = :salario")
    , @NamedQuery(name = "Cargos.findByEstado", query = "SELECT c FROM Cargos c WHERE c.estado = :estado")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "SALARIO")
    private String salario;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
    private Collection<Empleados> empleadosCollection;

    public Cargos() {
    }

    public Cargos(String numero) {
        this.numero = numero;
    }

    public Cargos(String numero, String nombre, String salario, String estado) {
        this.numero = numero;
        this.nombre = nombre;
        this.salario = salario;
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

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
