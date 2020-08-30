package FerreteriaDAO;

import FerreteriaExceptions.IllegalOrphanException;
import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import FerreteriaEntityClass.CategoriaProducto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import FerreteriaEntityClass.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CategoriaProductoDAO implements Serializable {

    public CategoriaProductoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CategoriaProductoDAO() {
    }

    public void create(CategoriaProducto categoriaProducto) throws PreexistingEntityException, Exception {
        if (categoriaProducto.getProductosCollection() == null) {
            categoriaProducto.setProductosCollection(new ArrayList<Productos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Productos> attachedProductosCollection = new ArrayList<Productos>();
            for (Productos productosCollectionProductosToAttach : categoriaProducto.getProductosCollection()) {
                productosCollectionProductosToAttach = em.getReference(productosCollectionProductosToAttach.getClass(), productosCollectionProductosToAttach.getCodigo());
                attachedProductosCollection.add(productosCollectionProductosToAttach);
            }
            categoriaProducto.setProductosCollection(attachedProductosCollection);
            em.persist(categoriaProducto);
            for (Productos productosCollectionProductos : categoriaProducto.getProductosCollection()) {
                CategoriaProducto oldCategoriaOfProductosCollectionProductos = productosCollectionProductos.getCategoria();
                productosCollectionProductos.setCategoria(categoriaProducto);
                productosCollectionProductos = em.merge(productosCollectionProductos);
                if (oldCategoriaOfProductosCollectionProductos != null) {
                    oldCategoriaOfProductosCollectionProductos.getProductosCollection().remove(productosCollectionProductos);
                    oldCategoriaOfProductosCollectionProductos = em.merge(oldCategoriaOfProductosCollectionProductos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoriaProducto(categoriaProducto.getNumero()) != null) {
                throw new PreexistingEntityException("CategoriaProducto " + categoriaProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CategoriaProducto categoriaProducto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CategoriaProducto persistentCategoriaProducto = em.find(CategoriaProducto.class, categoriaProducto.getNumero());
            Collection<Productos> productosCollectionOld = persistentCategoriaProducto.getProductosCollection();
            Collection<Productos> productosCollectionNew = categoriaProducto.getProductosCollection();
            List<String> illegalOrphanMessages = null;
            for (Productos productosCollectionOldProductos : productosCollectionOld) {
                if (!productosCollectionNew.contains(productosCollectionOldProductos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Productos " + productosCollectionOldProductos + " since its categoria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Productos> attachedProductosCollectionNew = new ArrayList<Productos>();
            for (Productos productosCollectionNewProductosToAttach : productosCollectionNew) {
                productosCollectionNewProductosToAttach = em.getReference(productosCollectionNewProductosToAttach.getClass(), productosCollectionNewProductosToAttach.getCodigo());
                attachedProductosCollectionNew.add(productosCollectionNewProductosToAttach);
            }
            productosCollectionNew = attachedProductosCollectionNew;
            categoriaProducto.setProductosCollection(productosCollectionNew);
            categoriaProducto = em.merge(categoriaProducto);
            for (Productos productosCollectionNewProductos : productosCollectionNew) {
                if (!productosCollectionOld.contains(productosCollectionNewProductos)) {
                    CategoriaProducto oldCategoriaOfProductosCollectionNewProductos = productosCollectionNewProductos.getCategoria();
                    productosCollectionNewProductos.setCategoria(categoriaProducto);
                    productosCollectionNewProductos = em.merge(productosCollectionNewProductos);
                    if (oldCategoriaOfProductosCollectionNewProductos != null && !oldCategoriaOfProductosCollectionNewProductos.equals(categoriaProducto)) {
                        oldCategoriaOfProductosCollectionNewProductos.getProductosCollection().remove(productosCollectionNewProductos);
                        oldCategoriaOfProductosCollectionNewProductos = em.merge(oldCategoriaOfProductosCollectionNewProductos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = categoriaProducto.getNumero();
                if (findCategoriaProducto(id) == null) {
                    throw new NonexistentEntityException("The categoriaProducto with id " + id + " no longer exists.");
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
            CategoriaProducto categoriaProducto;
            try {
                categoriaProducto = em.getReference(CategoriaProducto.class, numero);
                categoriaProducto.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriaProducto with id " + numero + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Productos> productosCollectionOrphanCheck = categoriaProducto.getProductosCollection();
            for (Productos productosCollectionOrphanCheckProductos : productosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This CategoriaProducto (" + categoriaProducto + ") cannot be destroyed since the Productos " + productosCollectionOrphanCheckProductos + " in its productosCollection field has a non-nullable categoria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(categoriaProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CategoriaProducto> findCategoriaProductoEntities() {
        return findCategoriaProductoEntities(true, -1, -1);
    }

    public List<CategoriaProducto> findCategoriaProductoEntities(int maxResults, int firstResult) {
        return findCategoriaProductoEntities(false, maxResults, firstResult);
    }

    private List<CategoriaProducto> findCategoriaProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CategoriaProducto.class));
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

    public CategoriaProducto findCategoriaProducto(String numero) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaProducto.class, numero);
        } finally {
            em.close();
        }
    }

    public int getCategoriaProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CategoriaProducto> rt = cq.from(CategoriaProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void inhabilitarCategoriaproducto(String numero) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE CategoriaProducto p SET p.estado = 'Off' where p.numero LIKE :numero");
      query.setParameter("numero", numero);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }
    
}
