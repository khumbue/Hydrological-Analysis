package za.co.jobcreation.ejb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * @author khumbu
 *
 */
public abstract class AbstractTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    
    @Rule
    public TestName testMethod = new TestName();

    @BeforeClass
    public static void createEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("job-creation-pu");
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Before
    public final void initBase() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        init();
    }

    public abstract void init();

    @After
    public final void destroyBase() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
