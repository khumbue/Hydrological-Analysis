package za.co.jobcreation.ejb.dao;

import org.junit.Ignore;
import org.junit.Test;
import za.co.jobcreation.ejb.AbstractTest;
import za.co.jobcreation.ejb.TestConstants;
import za.co.jobcreation.ejb.model.User;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author khumbu
 */
public class UserDaoTest extends AbstractTest {
    private UserDao userDao;
    private User testUser;

    @Override
    public void init() {
        userDao = new UserDao();
        userDao.setEntityManager(entityManager);
        User testUser = buildFirstTestUser();
        userDao.add(testUser);
    }

    @Test
    public void testFindUserName() throws Exception {
        testUser = userDao.findSingularBy(User.class, "userName", TestConstants.userName);
        assertNotNull(testUser);
        assertEquals(testUser.getUserName(), TestConstants.userName);
        assertTrue(testUser.isActive());
    }

    /*@Test
    public void testAddEntity() throws Exception {
        assertNotNull(userDao.findByPrimaryKey(User.class, 1));
    }*/

    private User buildFirstTestUser() {
        User user = new User();
        user.setUserName(TestConstants.userName);
        user.setActive(TestConstants.userActiveTrue);
        user.setLastUpdateDateTime(new Date());
        user.setPassword(TestConstants.password);
        return user;
    }
}
