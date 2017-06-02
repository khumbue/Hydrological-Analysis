package za.co.jobcreation.ejb.dao;

import za.co.jobcreation.ejb.model.User;

public class UserDao extends BaseDao<User> {
    public User findByName(String userName) {
        return findSingularBy(User.class, "userName", userName);
    }
}
