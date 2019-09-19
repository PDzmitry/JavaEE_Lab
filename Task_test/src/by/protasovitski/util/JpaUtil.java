package by.protasovitski.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory;
//    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class);
    static {
        try {
            entityManagerFactory=Persistence.createEntityManagerFactory("tasksPU");
//            PropertyConfigurator.configure("log4j.properties");
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void destroy() {
       entityManagerFactory.close();
    }
}

