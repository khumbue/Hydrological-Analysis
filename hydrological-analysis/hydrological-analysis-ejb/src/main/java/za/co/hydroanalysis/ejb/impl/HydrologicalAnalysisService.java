package za.co.jobcreation.ejb.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.jobcreation.api.IJobCreationService;
import za.co.jobcreation.api.dto.*;

/**
 * @author: khumbu
 */
@Stateless(mappedName = "JobCreationService")
@Remote(IJobCreationService.class)
public class JobCreationService implements IJobCreationService, Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger log = LoggerFactory.getLogger(JobCreationService.class);

    @Inject
    private AnnualTurnOverBean annualTurnOverBean;

    @Inject
    private EnterpriseBean enterpriseBean;

    @Inject
    private JobsBean jobsBean;

    @Inject
    private IndustrySectorBean industrySectorBean;

    @Inject
    private ProvinceBean provinceBean;

    @Inject
    private RoleBean roleBean;

    @Inject
    private IncomeCategoryBean incomeCategoryBean;

    @Inject
    private UserBean userBean;

    @Inject
    private ReportCriteriaBean reportCriteriaBean;

    @Inject
    DepartmentBean departmentBean;

    @Inject
    ChartTypeBean chartTypeBean;

    @Inject
    BbbeeRatingBean bbbeeRatingBean;

    @Override
    public Response addUser(UserDto userDto) {
        return userBean.addUser(userDto);
    }

    @Override
    public Response editUser(UserDto userDto) {
        return userBean.editUser(userDto);
    }

    @Override
    public Response deleteUser(UserDto userDto) {
        return userBean.deleteUser(userDto);
    }

    @Override
    public boolean isUserActive(String userName) {
        return userBean.isUserActive(userName);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userBean.getAllUsers();
    }

    @Override
    public List<EnterpriseDto> getAllEnterprises() {
        return enterpriseBean.getAllEnterprises();
    }

    @Override
    public List<ProvinceDto> getAllProvinces() {
        return provinceBean.getAllProvinces();
    }

    @Override
    public List<IndustrySectorDto> getAllIndustrySectors() {
        return industrySectorBean.getAllIndustrySectors();
    }

    @Override
    public Response addEnterprise(EnterpriseDto enterpriseDto) {
        return enterpriseBean.addEnterprise(enterpriseDto);
    }

    @Override
    public Response editEnterprise(EnterpriseDto enterpriseDto) {
        Response response = enterpriseBean.editEnterprise(enterpriseDto);
        return response;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleBean.getAllRoles();
    }

    @Override
    public UserDto getUserByUserName(String userName) {
        return userBean.findByUserName(userName);
    }

    @Override
    public Response addJobs(JobsDto jobsDto) {
        return jobsBean.addJobs(jobsDto);
    }

    @Override
    public Response editJobs(JobsDto jobsDto) {
        return jobsBean.editJobs(jobsDto);
    }

    @Override
    public JobsDto getJobsByEnterpriseAndProvince(String enterprise, String province, Date date) {
        return jobsBean.getJobsByEnterpriseAndProvince(enterprise, province, date);
    }

    @Override
    public List<JobsDto> getAllJobs() {
        return jobsBean.getAllJobs();
    }

    @Override
    public List<ReportCriteriaDto> getAllReportCriterion() {
        return reportCriteriaBean.getAllReportCriterias();
    }

    @Override
    public List<JobsDto> getJobsForAllProvincesForRange(Date fromDate, Date toDate) {
        return jobsBean.getJobsForAllProvincesForRange(fromDate, toDate);
    }

    @Override
    public List<JobsDto> getEnterpriseJobsForRange(String enterprise, Date fromDate, Date toDate) {
        return jobsBean.getEnterpriseJobsForRange(enterprise, fromDate, toDate);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentBean.getAllDepartments();
    }

    @Override
    public Response addDepartment(DepartmentDto departmentDto) {
        return departmentBean.addDepartment(departmentDto);
    }

    @Override
    public Response editDepartment(DepartmentDto departmentDto) {
        return departmentBean.editDepartment(departmentDto);
    }

    @Override
    public List<ChartTypeDto> getAllChartTypes() {
        return chartTypeBean.getAllChartTypes();
    }

    @Override
    public List<JobsDto> getDepartmentJobsForRange(String department, Date fromDate, Date toDate) {
        return jobsBean.getDepartmentJobsForRange(department, fromDate, toDate);
    }

    @Override
    public List<AnnualTurnOverDto> getAllAnnualTurnOvers() {
        return annualTurnOverBean.getAllAnnualTurnOvers();
    }

    @Override
    public List<BbbeeRatingDto> getAllBbbeeRatings() {
        return bbbeeRatingBean.getAllBeeeRatings();
    }
}
