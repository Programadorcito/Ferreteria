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
import FerreteriaEntityClass.Pedidos;
import FerreteriaEntityClass.Proveedores;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WIN8
 */
public class ProveedoresDAO implements Serializable {

    public ProveedoresDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ProveedoresDAO() {
    }

    public void create(Proveedores proveedores) throws PreexistingEntityException, Exception {
        if (proveedores.getPedidosCollection() == null) {
            proveedores.setPedidosCollection(new ArrayList<Pedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedidos> attachedPedidosCollection = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionPedidosToAttach : proveedores.getPedidosCollection()) {
                pedidosCollectionPedidosToAttach = em.getReference(pedidosCollectionPedidosToAttach.getClass(), pedidosCollectionPedidosToAttach.getNumero());
                attachedPedidosCollection.add(pedidosCollectionPedidosToAttach);
            }
            proveedores.setPedidosCollection(attachedPedidosCollection);
            em.persist(proveedores);
            for (Pedidos pedidosCollectionPedidos : proveedores.getPedidosCollection()) {
                Proveedores oldProveedorOfPedidosCollectionPedidos = pedidosCollectionPedidos.getProveedor();
                pedidosCollectionPedidos.setProveedor(proveedores);
                pedidosCollectionPedidos = em.merge(pedidosCollectionPedidos);
                if (oldProveedorOfPedidosCollectionPedidos != null) {
                    oldProveedorOfPedidosCollectionPedidos.getPedidosCollection().remove(pedidosCollectionPedidos);
                    oldProveedorOfPedidosCollectionPedidos = em.merge(oldProveedorOfPedidosCollectionPedidos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedores(proveedores.getRut()) != null) {
                throw new PreexistingEntityException("Proveedores " + proveedores + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedores proveedores) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores persistentProveedores = em.find(Proveedores.class, proveedores.getRut());
            Collection<Pedidos> pedidosCollectionOld = persistentProveedores.getPedidosCollection();
            Collection<Pedidos> pedidosCollectionNew = proveedores.getPedidosCollection();
            List<String> illegalOrphanMessages = null;
            for (Pedidos pedidosCollectionOldPedidos : pedidosCollectionOld) {
                if (!pedidosCollectionNew.contains(pedidosCollectionOldPedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedidos " + pedidosCollectionOldPedidos + " since its proveedor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Pedidos> attachedPedidosCollectionNew = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionNewPedidosToAttach : pedidosCollectionNew) {
                pedidosCollectionNewPedidosToAttach = em.getReference(pedidosCollectionNewPedidosToAttach.getClass(), pedidosCollectionNewPedidosToAttach.getNumero());
                attachedPedidosCollectionNew.add(pedidosCollectionNewPedidosToAttach);
            }
            pedidosCollectionNew = attachedPedidosCollectionNew;
            proveedores.setPedidosCollection(pedidosCollectionNew);
            proveedores = em.merge(proveedores);
            for (Pedidos pedidosCollectionNewPedidos : pedidosCollectionNew) {
                if (!pedidosCollectionOld.contains(pedidosCollectionNewPedidos)) {
                    Proveedores oldProveedorOfPedidosCollectionNewPedidos = pedidosCollectionNewPedidos.getProveedor();
                    pedidosCollectionNewPedidos.setProveedor(proveedores);
                    pedidosCollectionNewPedidos = em.merge(pedidosCollectionNewPedidos);
                    if (oldProveedorOfPedidosCollectionNewPedidos != null && !oldProveedorOfPedidosCollectionNewPedidos.equals(proveedores)) {
                        oldProveedorOfPedidosCollectionNewPedidos.getPedidosCollection().remove(pedidosCollectionNewPedidos);
                        oldProveedorOfPedidosCollectionNewPedidos = em.merge(oldProveedorOfPedidosCollectionNewPedidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = proveedores.getRut();
                if (findProveedores(id) == null) {
                    throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String rut) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proveedores;
            try {
                proveedores = em.getReference(Proveedores.class, rut);
                proveedores.getRut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedores with id " + rut + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Pedidos> pedidosCollectionOrphanCheck = proveedores.getPedidosCollection();
            for (Pedidos pedidosCollectionOrphanCheckPedidos : pedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedores (" + proveedores + ") cannot be destroyed since the Pedidos " + pedidosCollectionOrphanCheckPedidos + " in its pedidosCollection field has a non-nullable proveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proveedores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedores> findProveedoresEntities() {
        return findProveedoresEntities(true, -1, -1);
    }

    public List<Proveedores> findProveedoresEntities(int maxResults, int firstResult) {
        return findProveedoresEntities(false, maxResults, firstResult);
    }

    private List<Proveedores> findProveedoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedores.class));
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

    public Proveedores findProveedores(String rut) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedores.class, rut);
        } finally {
            em.close();
        }
    }

    public int getProveedoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedores> rt = cq.from(Proveedores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void inhabilitarProveedor(String rut) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE Proveedores p SET p.estado = 'Off' where p.rut LIKE :rut");
      query.setParameter("rut", rut);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }
    
}
