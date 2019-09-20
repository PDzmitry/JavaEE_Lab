package by.protasovitski.util;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;


public class EntityManagerFactoryProducer{



    @Produces
    @ApplicationScoped
    private EntityManagerFactory create() {
        EntityManagerFactory emf;
        try {
            emf = Persistence.createEntityManagerFactory("tasksPU");
//            System.out.println("EntityManagerFactory created!");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
        return emf;
    }

    private void desproy(@Disposes EntityManagerFactory emf) {
        emf.close();
    }

}
