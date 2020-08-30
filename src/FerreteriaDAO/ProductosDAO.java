package FerreteriaDAO;

import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import FerreteriaEntityClass.CategoriaProducto;
import FerreteriaEntityClass.Productos;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;


public class ProductosDAO implements Serializable {

    public ProductosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ProductosDAO() {
    }

    public void create(Productos productos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CategoriaProducto categoria = productos.getCategoria();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getNumero());
                productos.setCategoria(categoria);
            }
            em.persist(productos);
            if (categoria != null) {
                categoria.getProductosCollection().add(productos);
                categoria = em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductos(productos.getCodigo()) != null) {
                throw new PreexistingEntityException("Producto con código " + productos.getCodigo() + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productos productos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getCodigo());
            CategoriaProducto categoriaOld = persistentProductos.getCategoria();
            CategoriaProducto categoriaNew = productos.getCategoria();
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getNumero());
                productos.setCategoria(categoriaNew);
            }
            productos = em.merge(productos);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getProductosCollection().remove(productos);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getProductosCollection().add(productos);
                categoriaNew = em.merge(categoriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = productos.getCodigo();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Productos findProductos(String codigo) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, codigo);
        } finally {
            em.close();
        }
    }
    
    public void getCategoriaProducto (JComboBox <CategoriaProducto> ComboBoxCategoria){
        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT p FROM CategoriaProducto p").getResultList().iterator();
        CategoriaProducto p;
        try {
            while(it.hasNext()){
                p = (CategoriaProducto)it.next();
                ComboBoxCategoria.addItem(p);
            }
        }catch (Exception e){
            System.out.println("Error no se puede listar datos en el combobox Categoria");
        }
    }
    
    public void inhabilitarProducto(String codigo) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE Productos p SET p.estado = 'Off' where p.codigo LIKE :codigo");
      query.setParameter("codigo", codigo);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }

    public String mostrarStock(String codigo) {
      EntityManager em = getEntityManager();
      Query query = em.createQuery("SELECT max(p.stock) from Productos p where p.codigo LIKE :codigo");
      query.setParameter("codigo", codigo);
      List stock = query.getResultList();
      String numeroIncrementable = stock.toString();
      return numeroIncrementable.replace("[", "").replace("]", "");
     
    }

}
