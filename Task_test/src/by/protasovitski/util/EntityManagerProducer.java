package by.protasovitski.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class EntityManagerProducer{
    @Inject
    private EntityManagerFactory emf;



    @Produces
    @RequestScoped
    public EntityManager create() {
        EntityManager em = emf.createEntityManager();
//        System.out.println("EntityManager created!");
        return em;
    }
    public void dispose(@Disposes EntityManager em) {
        em.close();
    }
}
