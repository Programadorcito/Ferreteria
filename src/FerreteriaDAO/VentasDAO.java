package FerreteriaDAO;

import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import FerreteriaEntityClass.Clientes;
import FerreteriaEntityClass.Empleados;
import FerreteriaEntityClass.Ventas;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;

public class VentasDAO implements Serializable {

    public VentasDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");
    private String mensaje = "";

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public VentasDAO() {
    }

    public void create(Ventas ventas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes cliente = ventas.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getRutNuip());
                ventas.setCliente(cliente);
            }
            Empleados empleado = ventas.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getIdentificacion());
                ventas.setEmpleado(empleado);
            }
            em.persist(ventas);
            if (cliente != null) {
                cliente.getVentasCollection().add(ventas);
                cliente = em.merge(cliente);
            }
            if (empleado != null) {
                empleado.getVentasCollection().add(ventas);
                empleado = em.merge(empleado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVentas(ventas.getNumero()) != null) {
                throw new PreexistingEntityException("Ventas " + ventas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ventas ventas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas persistentVentas = em.find(Ventas.class, ventas.getNumero());
            Clientes clienteOld = persistentVentas.getCliente();
            Clientes clienteNew = ventas.getCliente();
            Empleados empleadoOld = persistentVentas.getEmpleado();
            Empleados empleadoNew = ventas.getEmpleado();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getRutNuip());
                ventas.setCliente(clienteNew);
            }
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getIdentificacion());
                ventas.setEmpleado(empleadoNew);
            }
            ventas = em.merge(ventas);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getVentasCollection().remove(ventas);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getVentasCollection().add(ventas);
                clienteNew = em.merge(clienteNew);
            }
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getVentasCollection().remove(ventas);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getVentasCollection().add(ventas);
                empleadoNew = em.merge(empleadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ventas.getNumero();
                if (findVentas(id) == null) {
                    throw new NonexistentEntityException("The ventas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String numero) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas ventas;
            try {
                ventas = em.getReference(Ventas.class, numero);
                ventas.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventas with id " + numero + " no longer exists.", enfe);
            }
            Clientes cliente = ventas.getCliente();
            if (cliente != null) {
                cliente.getVentasCollection().remove(ventas);
                cliente = em.merge(cliente);
            }
            Empleados empleado = ventas.getEmpleado();
            if (empleado != null) {
                empleado.getVentasCollection().remove(ventas);
                empleado = em.merge(empleado);
            }
            em.remove(ventas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Ventas findVentas(String numero) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ventas.class, numero);
        } finally {
            em.close();
        }
    }

    public void getEmpleados(JComboBox<Empleados> ComboBoxProductos) {
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT e FROM Empleados e").getResultList().iterator();
        Empleados c;
        try {
            while (it.hasNext()) {
                c = (Empleados) it.next();
                ComboBoxProductos.addItem(c);
            }
        } catch (Exception e) {
            System.out.println("Error no se puede listar datos en el combobox Empleados");
        }
    }

    public void getClientes(JComboBox<Clientes> ComboBoxProveedores) {
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT p FROM Clientes p").getResultList().iterator();
        Clientes p;
        try {
            while (it.hasNext()) {
                p = (Clientes) it.next();
                ComboBoxProveedores.addItem(p);
            }
        } catch (Exception e) {
            System.out.println("Error no se puede listar datos en el combobox Clientes");
        }
    }

    public void registrarVenta(String numero) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Ventas p SET p.estado = 'Off' where p.numero LIKE :numero");
        query.setParameter("numero", numero);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public String idIncrementable() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT max(p.numero)+1 from Ventas p");
        List numero = query.getResultList();
        String numeroIncrementable = numero.toString();
        return numeroIncrementable.replace("[", "").replace("]", "");
    }

    public void crear(Ventas venta) throws PreexistingEntityException, Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("INSERT into Ventas p (p.numero, p.fechaventa, p.direccionenvio, p.cliente, p.empleado, p.estado) values (p.?,p.?,p.?,p.?,p.?,p.?)");
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
