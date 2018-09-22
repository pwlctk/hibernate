package pl.sda.jpa.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static HibernateUtil INSTANCE;
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate" );
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    private HibernateUtil() {
    }

    public static HibernateUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateUtil();
        }
        return INSTANCE;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Object object) {
        entityManager.getTransaction().begin();
        if (!entityManager.contains(object)) {
            entityManager.persist(object);
        }
        entityManager.getTransaction().commit();

    }

    public void saveWithHibernateSession(Object t) {
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();

    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
