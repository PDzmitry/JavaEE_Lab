package by.protasovitski.repository.impl;

import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.repository.UserRepository;
import by.protasovitski.util.JpaUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Named
@RequestScoped
public class UserRepositoryImpl implements UserRepository {

    @Inject
    private EntityManager em;

    @Override
    public User save(User user) throws RepositoryException {
        try {
            em.getTransaction().begin();
            if (user.getId() == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
           /* if (em != null && em.isOpen()){
                em.close();
            }*/

        }
    }

    @Override
    public void remove(Long id) throws RepositoryException {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
           /* if (em != null && em.isOpen()) {
                em.close();
            }*/
        }
    }

    @Override
    public List<User> findAll() throws RepositoryException {
        try {
            em.getTransaction().begin();
            List<User> users = em.createQuery("select u from User u").getResultList();
            em.getTransaction().commit();
            return users;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
            /*if (em != null && em.isOpen()) {
                em.close();
            }*/
        }
    }

    @Override
    public Optional<User> findById(Long id) throws RepositoryException {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            em.getTransaction().commit();
            return user != null ? Optional.of(user) : Optional.empty();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
           /* if (em != null && em.isOpen()) {
                em.close();
            }*/
        }
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, byte[] password) throws RepositoryException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            Path<String> userLogin = root.get("login");
            Path<byte[]> userPassword = root.get("password");
            Predicate userLoginPredicate = builder.equal(userLogin, login);
            Predicate userPasswordPredicate = builder.equal(userPassword, password);
            Predicate predicate = builder.and(userLoginPredicate, userPasswordPredicate);

            criteriaQuery.select(root)
                    .where(predicate);
            User user = em.createQuery(criteriaQuery).getSingleResult();
            em.getTransaction().commit();
            return user != null ? Optional.of(user) : Optional.empty();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
           /* if (em != null && em.isOpen()) {
                em.close();
            }*/
        }

    }

    @Override
    public List<Map<User, Integer>> findAllWithCountTasks() throws RepositoryException {
        try {
            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            List<Map<User, Integer>> users = em.createQuery(
                    "select new map (u as user ,(select count (*) from Task as t where t.user=u) as task_count) from User  as u"
            ).getResultList();
            return users;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
            /*if (em != null && em.isOpen()) {
                em.close();
            }*/
        }
    }

    @Override
    public List<User> findAllHaveTasksWithTotalTimeMore(Long totalTime) throws RepositoryException {
        try {
            em = JpaUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            List<User> users = em.createQuery(
                    "select u from User u" +
                            " where u.id in (" +
                            "select t from Task t where t.id in (" +
                            "select task" +
                            "               from LogOfTasks" +
                            "               group by task" +
                            "               having sum(timeSpent)>:totalTime))").
                    setParameter("totalTime", totalTime)
                    .getResultList();
            return users;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RepositoryException(e.getMessage());
        } finally {
           /* if (em != null && em.isOpen()) {
                em.close();
            }*/
        }
    }
}
