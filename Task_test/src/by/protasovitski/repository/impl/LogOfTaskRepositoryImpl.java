package by.protasovitski.repository.impl;

import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.repository.LogOfTaskRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
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
        }
    }

    @Override
    public void remove(Long id) throws RepositoryException {
        try {
            em.getTransaction().begin();
            LogOfTasks log = em.find(LogOfTasks.class, id);
            em.remove(log);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<LogOfTasks> findAll() throws RepositoryException {
        try {
            em.getTransaction().begin();
            List<LogOfTasks> logs = em.createQuery("select l from LogOfTasks l").getResultList();
            em.getTransaction().commit();
            return logs;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Optional<LogOfTasks> findById(Long id) throws RepositoryException {
        try {
            em.getTransaction().begin();
            LogOfTasks log = em.find(LogOfTasks.class, id);
            em.getTransaction().commit();
            return log != null ? Optional.of(log) : Optional.empty();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<LogOfTasks> findAllByTaskId(Long taskId) throws RepositoryException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<LogOfTasks> criteriaQuery = builder.createQuery(LogOfTasks.class);
            Root<LogOfTasks> root = criteriaQuery.from(LogOfTasks.class);
            Path<Long> task_id = root.get("task");
            Predicate predicate = builder.equal(task_id, taskId);
            criteriaQuery.select(root)
                    .where(predicate);
            List<LogOfTasks> log = em.createQuery(criteriaQuery).getResultList();
            em.getTransaction().commit();
            return log;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }
}
