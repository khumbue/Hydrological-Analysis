package za.co.jobcreation.ejb.impl.validation;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import za.co.jobcreation.api.dto.UserDto;
import za.co.jobcreation.api.dto.ValidationResponse;
import za.co.jobcreation.ejb.dao.UserDao;
import za.co.jobcreation.ejb.model.User;

public class UserValidator {

    @Inject
    private UserDao userDao;

    public ValidationResponse validateDto(UserDto userDto, boolean isNew) {

        ValidationResponse response = new ValidationResponse();
        response.setValid(true);

        if (userDto.getRole() == null) {
            response.setErrorMessage("Role cannot be null.");
            response.setValid(false);
            response.setSuccessful(false);
        }

        return response;
    }

    public ValidationResponse checkDuplicates(UserDto userDto, ValidationResponse validationResponse) {
        User currentUser = userDao.findSingularBy(User.class, "name", userDto);
        if (currentUser != null) {
            validationResponse.setErrorMessage("User with name '" + userDto.getUserName() + "' already exixsts.");
            validationResponse.setDuplicate(true);
            validationResponse.setSuccessful(false);
        }
        return validationResponse;
    }

    public ValidationResponse validateEntity(User user, ValidationResponse response) {
        response.setValid(true);
        return response;
    }
}
