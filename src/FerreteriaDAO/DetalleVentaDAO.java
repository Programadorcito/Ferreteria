package FerreteriaDAO;

import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import FerreteriaEntityClass.DetalleVenta;
import FerreteriaEntityClass.DetalleVentaPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DetalleVentaDAO implements Serializable {

    public DetalleVentaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DetalleVentaDAO() {
    }

    public void create(DetalleVenta detalleVenta) throws PreexistingEntityException, Exception {
        if (detalleVenta.getDetalleVentaPK() == null) {
            detalleVenta.setDetalleVentaPK(new DetalleVentaPK());
        }
        detalleVenta.getDetalleVentaPK().setVenta(detalleVenta.getVentas().getNumero());
        detalleVenta.getDetalleVentaPK().setProducto(detalleVenta.getProductos().getCodigo());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleVenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleVenta(detalleVenta.getDetalleVentaPK()) != null) {
                throw new PreexistingEntityException("DetalleVenta " + detalleVenta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleVenta detalleVenta) throws NonexistentEntityException, Exception {
        detalleVenta.getDetalleVentaPK().setVenta(detalleVenta.getVentas().getNumero());
        detalleVenta.getDetalleVentaPK().setProducto(detalleVenta.getProductos().getCodigo());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleVenta = em.merge(detalleVenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleVentaPK id = detalleVenta.getDetalleVentaPK();
                if (findDetalleVenta(id) == null) {
                    throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleVentaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleVenta detalleVenta;
            try {
                detalleVenta = em.getReference(DetalleVenta.class, id);
                detalleVenta.getDetalleVentaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleVenta> findDetalleVentaEntities() {
        return findDetalleVentaEntities(true, -1, -1);
    }

    public List<DetalleVenta> findDetalleVentaEntities(int maxResults, int firstResult) {
        return findDetalleVentaEntities(false, maxResults, firstResult);
    }

    private List<DetalleVenta> findDetalleVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleVenta.class));
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

    public DetalleVenta findDetalleVenta(DetalleVentaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleVenta> rt = cq.from(DetalleVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void listarDetalles(JTable tablaProductos, String numero) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "NOMBRE", "PRECIO", "UNIDAD MEDIDA", "CANTIDAD", "SUBTOTAL"};
        model = new DefaultTableModel(null, titulo);

        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM DetalleVenta p WHERE p.detalleVentaPK.venta LIKE :numero");
        query.setParameter("numero", numero + "%");
        List<DetalleVenta> lista = query.getResultList();

        String[] datosDetalle = new String[6];
        for (DetalleVenta dc : lista) {
            datosDetalle[0] = dc.getProductos().getCodigo() + "";
            datosDetalle[1] = dc.getProductos().getNombre() + "";
            datosDetalle[2] = dc.getPreciosalida() + "";
            datosDetalle[3] = dc.getProductos().getUnidadmedida() + "";
            datosDetalle[4] = dc.getCantidad() + "";

            String n1, n2;
            int a, b, subtotal;
            n1 = datosDetalle[2] = dc.getPreciosalida() + "";
            n2 = datosDetalle[4] = dc.getCantidad() + "";
            a = Integer.parseInt(n1);
            b = Integer.parseInt(n2);
            subtotal = a * b;

            datosDetalle[5] = Integer.toString(subtotal);

            model.addRow(datosDetalle);

        }
        tablaProductos.setModel(model);
    }

    public void eliminarDetalle(String codigo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM DetalleVenta p WHERE p.detalleVentaPK.producto LIKE :codigo");
        query.setParameter("codigo", codigo);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarDetalles(String numero) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM DetalleVenta p WHERE p.detalleVentaPK.venta LIKE :numero");
        query.setParameter("numero", numero);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void buscarDetalle(String codigo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//      Query query = em.createQuery("SELECT p FROM Productos p WHERE p.codigo LIKE :codigo");
        Query query = em.createQuery("SELECT p FROM DetalleVenta p WHERE p.detalleVentaPK.producto LIKE :codigo");
        query.setParameter("codigo", codigo);
        query.executeUpdate();
        em.getTransaction().commit();
//      return em.find(DetalleVenta.class, codigo);
        em.close();
    }

}
