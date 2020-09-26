package FerreteriaDAO;

import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import FerreteriaEntityClass.DetallePedido;
import FerreteriaEntityClass.DetallePedidoPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import FerreteriaEntityClass.Pedidos;
import FerreteriaEntityClass.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DetallePedidoDAO implements Serializable {

    public DetallePedidoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DetallePedidoDAO() {
    }

    public void create(DetallePedido detallePedido) throws PreexistingEntityException, Exception {
        if (detallePedido.getDetallePedidoPK() == null) {
            detallePedido.setDetallePedidoPK(new DetallePedidoPK());
        }
        detallePedido.getDetallePedidoPK().setProducto(detallePedido.getProductos().getCodigo());
        detallePedido.getDetallePedidoPK().setPedido(detallePedido.getPedidos().getNumero());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos pedidos = detallePedido.getPedidos();
            if (pedidos != null) {
                pedidos = em.getReference(pedidos.getClass(), pedidos.getNumero());
                detallePedido.setPedidos(pedidos);
            }
            Productos productos = detallePedido.getProductos();
            if (productos != null) {
                productos = em.getReference(productos.getClass(), productos.getCodigo());
                detallePedido.setProductos(productos);
            }
            em.persist(detallePedido);
            if (pedidos != null) {
                pedidos.getDetallePedidoCollection().add(detallePedido);
                pedidos = em.merge(pedidos);
            }
            if (productos != null) {
//                productos.getDetallePedidoCollection().add(detallePedido);
                productos = em.merge(productos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetallePedido(detallePedido.getDetallePedidoPK()) != null) {
                throw new PreexistingEntityException("DetallePedido " + detallePedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetallePedido detallePedido) throws NonexistentEntityException, Exception {
        detallePedido.getDetallePedidoPK().setProducto(detallePedido.getProductos().getCodigo());
        detallePedido.getDetallePedidoPK().setPedido(detallePedido.getPedidos().getNumero());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallePedido persistentDetallePedido = em.find(DetallePedido.class, detallePedido.getDetallePedidoPK());
            Pedidos pedidosOld = persistentDetallePedido.getPedidos();
            Pedidos pedidosNew = detallePedido.getPedidos();
            Productos productosOld = persistentDetallePedido.getProductos();
            Productos productosNew = detallePedido.getProductos();
            if (pedidosNew != null) {
                pedidosNew = em.getReference(pedidosNew.getClass(), pedidosNew.getNumero());
                detallePedido.setPedidos(pedidosNew);
            }
            if (productosNew != null) {
                productosNew = em.getReference(productosNew.getClass(), productosNew.getCodigo());
                detallePedido.setProductos(productosNew);
            }
            detallePedido = em.merge(detallePedido);
            if (pedidosOld != null && !pedidosOld.equals(pedidosNew)) {
                pedidosOld.getDetallePedidoCollection().remove(detallePedido);
                pedidosOld = em.merge(pedidosOld);
            }
            if (pedidosNew != null && !pedidosNew.equals(pedidosOld)) {
                pedidosNew.getDetallePedidoCollection().add(detallePedido);
                pedidosNew = em.merge(pedidosNew);
            }
            if (productosOld != null && !productosOld.equals(productosNew)) {
//                productosOld.getDetallePedidoCollection().remove(detallePedido);
                productosOld = em.merge(productosOld);
            }
            if (productosNew != null && !productosNew.equals(productosOld)) {
//                productosNew.getDetallePedidoCollection().add(detallePedido);
                productosNew = em.merge(productosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetallePedidoPK id = detallePedido.getDetallePedidoPK();
                if (findDetallePedido(id) == null) {
                    throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetallePedidoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallePedido detallePedido;
            try {
                detallePedido = em.getReference(DetallePedido.class, id);
                detallePedido.getDetallePedidoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.", enfe);
            }
            Pedidos pedidos = detallePedido.getPedidos();
            if (pedidos != null) {
                pedidos.getDetallePedidoCollection().remove(detallePedido);
                pedidos = em.merge(pedidos);
            }
            Productos productos = detallePedido.getProductos();
            if (productos != null) {
//                productos.getDetallePedidoCollection().remove(detallePedido);
                productos = em.merge(productos);
            }
            em.remove(detallePedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetallePedido> findDetallePedidoEntities() {
        return findDetallePedidoEntities(true, -1, -1);
    }

    public List<DetallePedido> findDetallePedidoEntities(int maxResults, int firstResult) {
        return findDetallePedidoEntities(false, maxResults, firstResult);
    }

    private List<DetallePedido> findDetallePedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetallePedido.class));
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

    public DetallePedido findDetallePedido(DetallePedidoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetallePedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallePedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetallePedido> rt = cq.from(DetallePedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void listarDetalles(JTable tablaProductos, String numero) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "NOMBRE", "COSTO", "CANTIDAD", "SUBTOTAL"};
        model = new DefaultTableModel(null, titulo);

        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM DetallePedido p WHERE p.detallePedidoPK.pedido LIKE :numero");
        query.setParameter("numero", numero + "%");
        List<DetallePedido> lista = query.getResultList();

        String[] datosDetalle = new String[5];
        for (DetallePedido dc : lista) {
            datosDetalle[0] = dc.getProductos().getCodigo() + "";
            datosDetalle[1] = dc.getProductos().getNombre() + "";
            datosDetalle[2] = dc.getCostoproducto() + "";
            datosDetalle[3] = dc.getCantidad() + "";

            String n1, n2;
            int a, b, subtotal;
            n1 = datosDetalle[2] = dc.getCostoproducto() + "";
            n2 = datosDetalle[3] = dc.getCantidad() + "";
            a = Integer.parseInt(n1);
            b = Integer.parseInt(n2);
            subtotal = a * b;

            datosDetalle[4] = Integer.toString(subtotal);

            model.addRow(datosDetalle);

        }
        tablaProductos.setModel(model);
    }

    public void stockRestado(String codigo, String cantidad) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Productos p SET p.stock = Stock - LIKE cantidad where p.codigo LIKE :codigo");
        query.setParameter("codigo", codigo);
        query.setParameter("cantidad", cantidad);
        query.executeUpdate();
//      int rowsDeleted = query.executeUpdate();
//      System.out.println("entities deleted: " + rowsDeleted);
        em.getTransaction().commit();
        em.close();
    }

    public void selectCantidad(JTextField textoCantidad, String codigo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p Cantidad FROM Detalle_Pedido p where p.detallePedidoPK.producto LIKE :codigo");
        query.setParameter("codigo", codigo);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarDetalle(String codigo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM DetallePedido p WHERE p.detallePedidoPK.producto LIKE :codigo");
        query.setParameter("codigo", codigo);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarDetalles(String numero) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM DetallePedido p WHERE p.detallePedidoPK.pedido LIKE :numero");
        query.setParameter("numero", numero);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
