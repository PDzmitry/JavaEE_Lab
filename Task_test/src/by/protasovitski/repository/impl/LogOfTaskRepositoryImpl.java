package by.protasovitski.repository.impl;

import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.repository.LogOfTaskRepository;
import by.protasovitski.util.JpaUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class LogOfTaskRepositoryImpl implements LogOfTaskRepository {
    @Inject
    private EntityManager em;


    @Override
    public LogOfTasks save(LogOfTasks log) throws RepositoryException {
        try {
//            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            if (log.getId() == null) {
                em.persist(log);
            } else {
                em.merge(log);
            }
            em.getTransaction().commit();
            return log;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
            if (em != null && em.isOpen())
                em.close();
        }
    }

    @Override
    public void remove(Long id) throws RepositoryException {
        try {
//            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            LogOfTasks log = em.find(LogOfTasks.class, id);
            em.remove(log);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<LogOfTasks> findAll() throws RepositoryException {
        try {
//            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            List<LogOfTasks> logs = em.createQuery("select l from LogOfTasks l").getResultList();
            em.getTransaction().commit();
            return logs;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Optional<LogOfTasks> findById(Long id) throws RepositoryException {
        try {
//            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            LogOfTasks log = em.find(LogOfTasks.class, id);
            em.getTransaction().commit();
            return log != null ? Optional.of(log) : Optional.empty();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
