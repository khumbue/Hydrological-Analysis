package za.co.jobcreation.ejb.impl.validation;

import za.co.jobcreation.api.dto.EnterpriseDto;
import za.co.jobcreation.api.dto.ValidationResponse;
import za.co.jobcreation.ejb.dao.EnterpriseDao;
import za.co.jobcreation.ejb.model.Enterprise;

import javax.inject.Inject;

/**
 * @author khumbu
 */
public class EnterpriseValidator {
    @Inject
    private EnterpriseDao enterpriseDao;

    public ValidationResponse validateDto(EnterpriseDto enterpriseDto, boolean isNew) {

        ValidationResponse response = new ValidationResponse();
        response.setValid(true);

        if (enterpriseDto.getAnnualTurnOver() == null) {
            response.setErrorMessage("Annual Turn Over cannot be null.");
            response.setValid(false);
            response.setSuccessful(false);
        } else if (enterpriseDto.getIndustrySector() == null) {
            response.setErrorMessage("Industry Sector cannot be null.");
            response.setValid(false);
            response.setSuccessful(false);
        }

        return response;
    }

    public ValidationResponse checkDuplicates(EnterpriseDto enterpriseDto, ValidationResponse validationResponse) {
        Enterprise currentEnterprise = enterpriseDao.findByName(enterpriseDto.getName());
        if (currentEnterprise != null) {
            validationResponse.setErrorMessage("Enterprise with name '" + enterpriseDto.getName() + "' already exists.");
            validationResponse.setDuplicate(true);
            validationResponse.setSuccessful(false);
        }
        return validationResponse;
    }

    public ValidationResponse validateEntity(Enterprise enterprise, ValidationResponse response) {
        response.setValid(true);
        return response;
    }
}
