package by.protasovitski.repository.impl;

import by.protasovitski.entity.Task;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.repository.TaskRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class TaskRepositoryImpl implements TaskRepository {
    @Inject
    private EntityManager em;


    @Override
    public Task save(Task task) throws RepositoryException {
        try {
            em.getTransaction().begin();
            if (task.getId() == null) {
                em.persist(task);
            } else {
                em.merge(task);
            }
            em.getTransaction().commit();
            return task;
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
            Task task = em.find(Task.class, id);
            em.remove(task);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Task> findAll() throws RepositoryException {
        try {
            em.getTransaction().begin();
            List<Task> tasks = em.createQuery("select t from Task t").getResultList();
            em.getTransaction().commit();
            return tasks;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Optional<Task> findById(Long id) throws RepositoryException {
        try {
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);
            em.getTransaction().commit();
            return task != null ? Optional.of(task) : Optional.empty();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Task> findAllByUserId(Long userId) throws RepositoryException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Task> criteriaQuery = builder.createQuery(Task.class);
            Root<Task> root = criteriaQuery.from(Task.class);
            Path<Long> user_id = root.get("user");
            Predicate predicate = builder.equal(user_id, userId);
            criteriaQuery.select(root)
                    .where(predicate);
            List<Task> tasks = em.createQuery(criteriaQuery).getResultList();
            em.getTransaction().commit();
            return tasks;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        }
    }
}
