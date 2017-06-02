package za.co.jobcreation.ejb.impl;

import za.co.jobcreation.api.dto.Response;
import za.co.jobcreation.api.dto.UserDto;
import za.co.jobcreation.ejb.dao.RoleDao;
import za.co.jobcreation.ejb.dao.UserDao;
import za.co.jobcreation.ejb.impl.util.Mapper;
import za.co.jobcreation.ejb.model.User;

import javax.inject.Inject;
import java.util.List;

/**
 * @author khumbu
 */
public class UserBean {

    @Inject
    private UserDao userDao;

    @Inject
    RoleDao roleDao;

    @Inject
    private Mapper mapper;

    public Response addUser(UserDto userDto) {
        User user = mapper.mapUserDtoToEntity(userDto);
        user.setRole(roleDao.findByName(userDto.getRole().getName()));
        userDao.add(user);
        return setSuccessfulResponse();
    }

    public Response editUser(UserDto userDto) {
        User user = userDao.findByName(userDto.getUserName());
        mapper.updateUserEntityFields(user, userDto);
        user.setActive(userDto.isActive());
        user.setRole(roleDao.findByName(userDto.getRole().getName()));
        userDao.update(user);
        return setSuccessfulResponse();
    }

    public Response deleteUser(UserDto userDto) {
        userDao.remove(mapper.mapUserDtoToEntity(userDto));
        return setSuccessfulResponse();
    }

    public boolean isUserActive(String userName) {
        if (userDao.findByName(userName) != null) {
            return userDao.findByName(userName).isActive();
        } else {
            return false;
        }
    }

    public UserDto findByUserName(String userName) {
        User user = userDao.findSingularBy(User.class, "userName", userName);
        return mapper.mapUserEntityToDto(user);
    }

    public List<UserDto> getAllUsers() {
        return mapper.mapUserEntityToDtos(userDao.findAll(User.class));
    }

    private Response setSuccessfulResponse() {
        Response response = new Response();
        response.setSuccessful(true);
        return response;
    }
}
