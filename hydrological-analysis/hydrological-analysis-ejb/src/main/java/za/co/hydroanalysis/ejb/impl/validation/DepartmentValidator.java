package za.co.jobcreation.ejb.impl.validation;

import za.co.jobcreation.api.dto.DepartmentDto;
import za.co.jobcreation.api.dto.ValidationResponse;
import za.co.jobcreation.ejb.dao.DepartmentDao;

import javax.inject.Inject;

/**
 * @author khumbu
 */
public class DepartmentValidator {
    @Inject
    private DepartmentDao departmentDao;

    public ValidationResponse validateDto(DepartmentDto departmentDto, boolean isNew) {

        ValidationResponse response = new ValidationResponse();
        response.setValid(true);

        /*if (departmentDto.getEnterprises() == null) {
            response.setErrorMessage("Enterprises cannot be null.");
            response.setValid(false);
            response.setSuccessful(false);
        } else if (departmentDto.getProvince() == null) {
            response.setErrorMessage("Province cannot be null.");
            response.setValid(false);
            response.setSuccessful(false);
        }*/

        return response;
    }

    public ValidationResponse checkDuplicates(DepartmentDto departmentDto, ValidationResponse validationResponse) {
        Department currentDepartment = departmentDao.findByName(departmentDto.getName());
        if (currentDepartment != null) {
            validationResponse.setErrorMessage("Department with name '" + departmentDto.getName() + "' already exists.");
            validationResponse.setDuplicate(true);
            validationResponse.setSuccessful(false);
        }
        return validationResponse;
    }

    public ValidationResponse validateEntity(Department department, ValidationResponse response) {
        response.setValid(true);
        return response;
    }
}
