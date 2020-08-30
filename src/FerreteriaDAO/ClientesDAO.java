package FerreteriaDAO;

import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import FerreteriaEntityClass.Clientes;
import java.io.Serializable;
import javax.persistence.Query;
import FerreteriaEntityClass.Ventas;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientesDAO implements Serializable {

    public ClientesDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ClientesDAO() {
    }

    public void create(Clientes clientes) throws PreexistingEntityException, Exception {
        if (clientes.getVentasCollection() == null) {
            clientes.setVentasCollection(new ArrayList<Ventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ventas> attachedVentasCollection = new ArrayList<Ventas>();
            for (Ventas ventasCollectionVentasToAttach : clientes.getVentasCollection()) {
                ventasCollectionVentasToAttach = em.getReference(ventasCollectionVentasToAttach.getClass(), ventasCollectionVentasToAttach.getNumero());
                attachedVentasCollection.add(ventasCollectionVentasToAttach);
            }
            clientes.setVentasCollection(attachedVentasCollection);
            em.persist(clientes);
            for (Ventas ventasCollectionVentas : clientes.getVentasCollection()) {
                Clientes oldClienteOfVentasCollectionVentas = ventasCollectionVentas.getCliente();
                ventasCollectionVentas.setCliente(clientes);
                ventasCollectionVentas = em.merge(ventasCollectionVentas);
                if (oldClienteOfVentasCollectionVentas != null) {
                    oldClienteOfVentasCollectionVentas.getVentasCollection().remove(ventasCollectionVentas);
                    oldClienteOfVentasCollectionVentas = em.merge(oldClienteOfVentasCollectionVentas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientes(clientes.getRutNuip()) != null) {
                throw new PreexistingEntityException("Cliente con rut/nuip " + clientes.getRutNuip() + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getRutNuip());
            Collection<Ventas> ventasCollectionOld = persistentClientes.getVentasCollection();
            Collection<Ventas> ventasCollectionNew = clientes.getVentasCollection();
            Collection<Ventas> attachedVentasCollectionNew = new ArrayList<Ventas>();
            for (Ventas ventasCollectionNewVentasToAttach : ventasCollectionNew) {
                ventasCollectionNewVentasToAttach = em.getReference(ventasCollectionNewVentasToAttach.getClass(), ventasCollectionNewVentasToAttach.getNumero());
                attachedVentasCollectionNew.add(ventasCollectionNewVentasToAttach);
            }
            ventasCollectionNew = attachedVentasCollectionNew;
            clientes.setVentasCollection(ventasCollectionNew);
            clientes = em.merge(clientes);
            for (Ventas ventasCollectionOldVentas : ventasCollectionOld) {
                if (!ventasCollectionNew.contains(ventasCollectionOldVentas)) {
                    ventasCollectionOldVentas.setCliente(null);
                    ventasCollectionOldVentas = em.merge(ventasCollectionOldVentas);
                }
            }
            for (Ventas ventasCollectionNewVentas : ventasCollectionNew) {
                if (!ventasCollectionOld.contains(ventasCollectionNewVentas)) {
                    Clientes oldClienteOfVentasCollectionNewVentas = ventasCollectionNewVentas.getCliente();
                    ventasCollectionNewVentas.setCliente(clientes);
                    ventasCollectionNewVentas = em.merge(ventasCollectionNewVentas);
                    if (oldClienteOfVentasCollectionNewVentas != null && !oldClienteOfVentasCollectionNewVentas.equals(clientes)) {
                        oldClienteOfVentasCollectionNewVentas.getVentasCollection().remove(ventasCollectionNewVentas);
                        oldClienteOfVentasCollectionNewVentas = em.merge(oldClienteOfVentasCollectionNewVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clientes.getRutNuip();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Clientes findClientes(String rutnuip) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, rutnuip);
        } finally {
            em.close();
        }
    }
   
    public void inhabilitarCliente(String rutNuip) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE Clientes p SET p.estado = 'Off' where p.rutNuip LIKE :rutNuip");
      query.setParameter("rutNuip", rutNuip);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }
 
}
