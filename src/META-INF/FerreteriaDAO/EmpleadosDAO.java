/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FerreteriaDAO;

import FerreteriaExceptions.IllegalOrphanException;
import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import FerreteriaEntityClass.Cargos;
import FerreteriaEntityClass.Empleados;
import FerreteriaEntityClass.Ventas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;

/**
 *
 * @author WIN8
 */
public class EmpleadosDAO implements Serializable {

    public EmpleadosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public EmpleadosDAO() {
    }

    public void create(Empleados empleados) throws PreexistingEntityException, Exception {
        if (empleados.getVentasCollection() == null) {
            empleados.setVentasCollection(new ArrayList<Ventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos cargo = empleados.getCargo();
            if (cargo != null) {
                cargo = em.getReference(cargo.getClass(), cargo.getNumero());
                empleados.setCargo(cargo);
            }
            Collection<Ventas> attachedVentasCollection = new ArrayList<Ventas>();
            for (Ventas ventasCollectionVentasToAttach : empleados.getVentasCollection()) {
                ventasCollectionVentasToAttach = em.getReference(ventasCollectionVentasToAttach.getClass(), ventasCollectionVentasToAttach.getNumero());
                attachedVentasCollection.add(ventasCollectionVentasToAttach);
            }
            empleados.setVentasCollection(attachedVentasCollection);
            em.persist(empleados);
            if (cargo != null) {
                cargo.getEmpleadosCollection().add(empleados);
                cargo = em.merge(cargo);
            }
            for (Ventas ventasCollectionVentas : empleados.getVentasCollection()) {
                Empleados oldEmpleadoOfVentasCollectionVentas = ventasCollectionVentas.getEmpleado();
                ventasCollectionVentas.setEmpleado(empleados);
                ventasCollectionVentas = em.merge(ventasCollectionVentas);
                if (oldEmpleadoOfVentasCollectionVentas != null) {
                    oldEmpleadoOfVentasCollectionVentas.getVentasCollection().remove(ventasCollectionVentas);
                    oldEmpleadoOfVentasCollectionVentas = em.merge(oldEmpleadoOfVentasCollectionVentas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleados(empleados.getIdentificacion()) != null) {
                throw new PreexistingEntityException("Empleados " + empleados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getIdentificacion());
            Cargos cargoOld = persistentEmpleados.getCargo();
            Cargos cargoNew = empleados.getCargo();
            Collection<Ventas> ventasCollectionOld = persistentEmpleados.getVentasCollection();
            Collection<Ventas> ventasCollectionNew = empleados.getVentasCollection();
            List<String> illegalOrphanMessages = null;
            for (Ventas ventasCollectionOldVentas : ventasCollectionOld) {
                if (!ventasCollectionNew.contains(ventasCollectionOldVentas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ventas " + ventasCollectionOldVentas + " since its empleado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cargoNew != null) {
                cargoNew = em.getReference(cargoNew.getClass(), cargoNew.getNumero());
                empleados.setCargo(cargoNew);
            }
            Collection<Ventas> attachedVentasCollectionNew = new ArrayList<Ventas>();
            for (Ventas ventasCollectionNewVentasToAttach : ventasCollectionNew) {
                ventasCollectionNewVentasToAttach = em.getReference(ventasCollectionNewVentasToAttach.getClass(), ventasCollectionNewVentasToAttach.getNumero());
                attachedVentasCollectionNew.add(ventasCollectionNewVentasToAttach);
            }
            ventasCollectionNew = attachedVentasCollectionNew;
            empleados.setVentasCollection(ventasCollectionNew);
            empleados = em.merge(empleados);
            if (cargoOld != null && !cargoOld.equals(cargoNew)) {
                cargoOld.getEmpleadosCollection().remove(empleados);
                cargoOld = em.merge(cargoOld);
            }
            if (cargoNew != null && !cargoNew.equals(cargoOld)) {
                cargoNew.getEmpleadosCollection().add(empleados);
                cargoNew = em.merge(cargoNew);
            }
            for (Ventas ventasCollectionNewVentas : ventasCollectionNew) {
                if (!ventasCollectionOld.contains(ventasCollectionNewVentas)) {
                    Empleados oldEmpleadoOfVentasCollectionNewVentas = ventasCollectionNewVentas.getEmpleado();
                    ventasCollectionNewVentas.setEmpleado(empleados);
                    ventasCollectionNewVentas = em.merge(ventasCollectionNewVentas);
                    if (oldEmpleadoOfVentasCollectionNewVentas != null && !oldEmpleadoOfVentasCollectionNewVentas.equals(empleados)) {
                        oldEmpleadoOfVentasCollectionNewVentas.getVentasCollection().remove(ventasCollectionNewVentas);
                        oldEmpleadoOfVentasCollectionNewVentas = em.merge(oldEmpleadoOfVentasCollectionNewVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empleados.getIdentificacion();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String identificacion) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, identificacion);
                empleados.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + identificacion + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ventas> ventasCollectionOrphanCheck = empleados.getVentasCollection();
            for (Ventas ventasCollectionOrphanCheckVentas : ventasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleados (" + empleados + ") cannot be destroyed since the Ventas " + ventasCollectionOrphanCheckVentas + " in its ventasCollection field has a non-nullable empleado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cargos cargo = empleados.getCargo();
            if (cargo != null) {
                cargo.getEmpleadosCollection().remove(empleados);
                cargo = em.merge(cargo);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleados findEmpleados(String identificacion) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, identificacion);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
public void getCargos (JComboBox <Cargos> ComboBoxCargos){
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT p FROM Cargos p").getResultList().iterator();
        Cargos c;
        try {
            while(it.hasNext()){
                c = (Cargos)it.next();
                ComboBoxCargos.addItem(c);
            }
        }catch (Exception e){
            System.out.println("Error no se puede listar datos en el combobox Categoria");
        }
    }
       
       public void inhabilitarEmpleado(String identificacion) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE Empleados p SET p.estado = 'Off' where p.identificacion LIKE :identificacion");
      query.setParameter("identificacion", identificacion);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }

    
}
