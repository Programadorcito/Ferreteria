package FerreteriaDAO;

import FerreteriaExceptions.IllegalOrphanException;
import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import FerreteriaEntityClass.Proveedores;
import FerreteriaEntityClass.DetallePedido;
import FerreteriaEntityClass.Pedidos;
import FerreteriaEntityClass.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;

public class PedidosDAO implements Serializable {

    public PedidosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");
    private String mensaje = "";

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PedidosDAO() {
    }

    public void create(Pedidos pedidos) throws PreexistingEntityException, Exception {
        if (pedidos.getDetallePedidoCollection() == null) {
            pedidos.setDetallePedidoCollection(new ArrayList<DetallePedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proveedor = pedidos.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getRut());
                pedidos.setProveedor(proveedor);
            }
            Collection<DetallePedido> attachedDetallePedidoCollection = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoCollectionDetallePedidoToAttach : pedidos.getDetallePedidoCollection()) {
                detallePedidoCollectionDetallePedidoToAttach = em.getReference(detallePedidoCollectionDetallePedidoToAttach.getClass(), detallePedidoCollectionDetallePedidoToAttach.getDetallePedidoPK());
                attachedDetallePedidoCollection.add(detallePedidoCollectionDetallePedidoToAttach);
            }
            pedidos.setDetallePedidoCollection(attachedDetallePedidoCollection);
            em.persist(pedidos);
            if (proveedor != null) {
                proveedor.getPedidosCollection().add(pedidos);
                proveedor = em.merge(proveedor);
            }
            for (DetallePedido detallePedidoCollectionDetallePedido : pedidos.getDetallePedidoCollection()) {
                Pedidos oldPedidosOfDetallePedidoCollectionDetallePedido = detallePedidoCollectionDetallePedido.getPedidos();
                detallePedidoCollectionDetallePedido.setPedidos(pedidos);
                detallePedidoCollectionDetallePedido = em.merge(detallePedidoCollectionDetallePedido);
                if (oldPedidosOfDetallePedidoCollectionDetallePedido != null) {
                    oldPedidosOfDetallePedidoCollectionDetallePedido.getDetallePedidoCollection().remove(detallePedidoCollectionDetallePedido);
                    oldPedidosOfDetallePedidoCollectionDetallePedido = em.merge(oldPedidosOfDetallePedidoCollectionDetallePedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedidos(pedidos.getNumero()) != null) {
                throw new PreexistingEntityException("Pedidos " + pedidos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedidos pedidos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        if (pedidos.getDetallePedidoCollection() == null) {
            pedidos.setDetallePedidoCollection(new ArrayList<DetallePedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos persistentPedidos = em.find(Pedidos.class, pedidos.getNumero());
            Proveedores proveedorOld = persistentPedidos.getProveedor();
            Proveedores proveedorNew = pedidos.getProveedor();
            Collection<DetallePedido> detallePedidoCollectionOld = persistentPedidos.getDetallePedidoCollection();
            Collection<DetallePedido> detallePedidoCollectionNew = pedidos.getDetallePedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (DetallePedido detallePedidoCollectionOldDetallePedido : detallePedidoCollectionOld) {
                if (!detallePedidoCollectionNew.contains(detallePedidoCollectionOldDetallePedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetallePedido " + detallePedidoCollectionOldDetallePedido + " since its pedidos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getRut());
                pedidos.setProveedor(proveedorNew);
            }
            Collection<DetallePedido> attachedDetallePedidoCollectionNew = new ArrayList<DetallePedido>();
            for (DetallePedido detallePedidoCollectionNewDetallePedidoToAttach : detallePedidoCollectionNew) {
                detallePedidoCollectionNewDetallePedidoToAttach = em.getReference(detallePedidoCollectionNewDetallePedidoToAttach.getClass(), detallePedidoCollectionNewDetallePedidoToAttach.getDetallePedidoPK());
                attachedDetallePedidoCollectionNew.add(detallePedidoCollectionNewDetallePedidoToAttach);
            }
            detallePedidoCollectionNew = attachedDetallePedidoCollectionNew;
            pedidos.setDetallePedidoCollection(detallePedidoCollectionNew);
            pedidos = em.merge(pedidos);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getPedidosCollection().remove(pedidos);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getPedidosCollection().add(pedidos);
                proveedorNew = em.merge(proveedorNew);
            }
            for (DetallePedido detallePedidoCollectionNewDetallePedido : detallePedidoCollectionNew) {
                if (!detallePedidoCollectionOld.contains(detallePedidoCollectionNewDetallePedido)) {
                    Pedidos oldPedidosOfDetallePedidoCollectionNewDetallePedido = detallePedidoCollectionNewDetallePedido.getPedidos();
                    detallePedidoCollectionNewDetallePedido.setPedidos(pedidos);
                    detallePedidoCollectionNewDetallePedido = em.merge(detallePedidoCollectionNewDetallePedido);
                    if (oldPedidosOfDetallePedidoCollectionNewDetallePedido != null && !oldPedidosOfDetallePedidoCollectionNewDetallePedido.equals(pedidos)) {
                        oldPedidosOfDetallePedidoCollectionNewDetallePedido.getDetallePedidoCollection().remove(detallePedidoCollectionNewDetallePedido);
                        oldPedidosOfDetallePedidoCollectionNewDetallePedido = em.merge(oldPedidosOfDetallePedidoCollectionNewDetallePedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pedidos.getNumero();
                if (findPedidos(id) == null) {
                    throw new NonexistentEntityException("The pedidos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String numero) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos pedidos;
            try {
                pedidos = em.getReference(Pedidos.class, numero);
                pedidos.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidos with id " + numero + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetallePedido> detallePedidoCollectionOrphanCheck = pedidos.getDetallePedidoCollection();
            for (DetallePedido detallePedidoCollectionOrphanCheckDetallePedido : detallePedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedidos (" + pedidos + ") cannot be destroyed since the DetallePedido " + detallePedidoCollectionOrphanCheckDetallePedido + " in its detallePedidoCollection field has a non-nullable pedidos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedores proveedor = pedidos.getProveedor();
            if (proveedor != null) {
                proveedor.getPedidosCollection().remove(pedidos);
                proveedor = em.merge(proveedor);
            }
            em.remove(pedidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedidos> findPedidosEntities() {
        return findPedidosEntities(true, -1, -1);
    }

    public List<Pedidos> findPedidosEntities(int maxResults, int firstResult) {
        return findPedidosEntities(false, maxResults, firstResult);
    }

    private List<Pedidos> findPedidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedidos.class));
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

    public Pedidos findPedidos(String numero) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedidos.class, numero);
        } finally {
            em.close();
        }
    }

    public int getPedidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedidos> rt = cq.from(Pedidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void getProductos(JComboBox<Productos> ComboBoxProductos) {
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT e FROM Productos e").getResultList().iterator();
        Productos c;
        try {
            while (it.hasNext()) {
                c = (Productos) it.next();
                ComboBoxProductos.addItem(c);
            }
        } catch (Exception e) {
            System.out.println("Error no se puede listar datos en el combobox Productos");
        }
    }

    public void getProveedores(JComboBox<Proveedores> ComboBoxProveedores) {
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT p FROM Proveedores p").getResultList().iterator();
        Proveedores p;
        try {
            while (it.hasNext()) {
                p = (Proveedores) it.next();
                ComboBoxProveedores.addItem(p);
            }
        } catch (Exception e) {
            System.out.println("Error no se puede listar datos en el combobox Proveedores");
        }
    }

    public void inhabilitarPedido(String numero) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Pedidos p SET p.estado = 'Off' where p.numero LIKE :numero");
        query.setParameter("numero", numero);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public String idIncrementable() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT max(p.numero)+1 from Pedidos p");
        List numero = query.getResultList();
        String numeroIncrementable = numero.toString();
        return numeroIncrementable.replace("[", "").replace("]", "");
    }

    public void eliminaPedido(String numero) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Pedidos p WHERE p.numero LIKE :numero");
        query.setParameter("numero", numero);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
