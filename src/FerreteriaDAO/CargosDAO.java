package FerreteriaDAO;

import FerreteriaExceptions.IllegalOrphanException;
import FerreteriaExceptions.NonexistentEntityException;
import FerreteriaExceptions.PreexistingEntityException;
import FerreteriaEntityClass.Cargos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import FerreteriaEntityClass.Empleados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CargosDAO implements Serializable {

    public CargosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FerreteriaPersistence");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CargosDAO() {
    }

    public void create(Cargos cargos) throws PreexistingEntityException, Exception {
        if (cargos.getEmpleadosCollection() == null) {
            cargos.setEmpleadosCollection(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Empleados> attachedEmpleadosCollection = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionEmpleadosToAttach : cargos.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdentificacion());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            cargos.setEmpleadosCollection(attachedEmpleadosCollection);
            em.persist(cargos);
            for (Empleados empleadosCollectionEmpleados : cargos.getEmpleadosCollection()) {
                Cargos oldCargoOfEmpleadosCollectionEmpleados = empleadosCollectionEmpleados.getCargo();
                empleadosCollectionEmpleados.setCargo(cargos);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
                if (oldCargoOfEmpleadosCollectionEmpleados != null) {
                    oldCargoOfEmpleadosCollectionEmpleados.getEmpleadosCollection().remove(empleadosCollectionEmpleados);
                    oldCargoOfEmpleadosCollectionEmpleados = em.merge(oldCargoOfEmpleadosCollectionEmpleados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargos(cargos.getNumero()) != null) {
                throw new PreexistingEntityException("Cargos " + cargos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargos cargos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargos persistentCargos = em.find(Cargos.class, cargos.getNumero());
            Collection<Empleados> empleadosCollectionOld = persistentCargos.getEmpleadosCollection();
            Collection<Empleados> empleadosCollectionNew = cargos.getEmpleadosCollection();
            List<String> illegalOrphanMessages = null;
            for (Empleados empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empleados " + empleadosCollectionOldEmpleados + " since its cargo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Empleados> attachedEmpleadosCollectionNew = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdentificacion());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            cargos.setEmpleadosCollection(empleadosCollectionNew);
            cargos = em.merge(cargos);
            for (Empleados empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    Cargos oldCargoOfEmpleadosCollectionNewEmpleados = empleadosCollectionNewEmpleados.getCargo();
                    empleadosCollectionNewEmpleados.setCargo(cargos);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                    if (oldCargoOfEmpleadosCollectionNewEmpleados != null && !oldCargoOfEmpleadosCollectionNewEmpleados.equals(cargos)) {
                        oldCargoOfEmpleadosCollectionNewEmpleados.getEmpleadosCollection().remove(empleadosCollectionNewEmpleados);
                        oldCargoOfEmpleadosCollectionNewEmpleados = em.merge(oldCargoOfEmpleadosCollectionNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cargos.getNumero();
                if (findCargos(id) == null) {
                    throw new NonexistentEntityException("The cargos with id " + id + " no longer exists.");
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
            Cargos cargos;
            try {
                cargos = em.getReference(Cargos.class, numero);
                cargos.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargos with id " + numero + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Empleados> empleadosCollectionOrphanCheck = cargos.getEmpleadosCollection();
            for (Empleados empleadosCollectionOrphanCheckEmpleados : empleadosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cargos (" + cargos + ") cannot be destroyed since the Empleados " + empleadosCollectionOrphanCheckEmpleados + " in its empleadosCollection field has a non-nullable cargo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cargos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargos> findCargosEntities() {
        return findCargosEntities(true, -1, -1);
    }

    public List<Cargos> findCargosEntities(int maxResults, int firstResult) {
        return findCargosEntities(false, maxResults, firstResult);
    }

    private List<Cargos> findCargosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargos.class));
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

    public Cargos findCargos(String numero) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargos.class, numero);
        } finally {
            em.close();
        }
    }

    public int getCargosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargos> rt = cq.from(Cargos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public void inhabilitarCargo(String numero) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery("UPDATE Cargos p SET p.estado = 'Off' where p.numero LIKE :numero");
      query.setParameter("numero", numero);
      query.executeUpdate();
      em.getTransaction().commit();
      em.close();
    }
    
    
}
