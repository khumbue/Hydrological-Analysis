package za.co.jobcreation.api;

import za.co.jobcreation.api.dto.*;

import java.util.Date;
import java.util.List;

public interface IHydrologicalAnalysisService {

    Response addUser(UserDto employeeDto);

    Response editUser(UserDto employeeDto);

    Response deleteUser(UserDto employeeDto);

    boolean isUserActive(String userName);

    List<UserDto> getAllUsers();

    List<EnterpriseDto> getAllEnterprises();

    List<ProvinceDto> getAllProvinces();

    List<IndustrySectorDto> getAllIndustrySectors();

    Response addEnterprise(EnterpriseDto enterpriseDto);

    Response editEnterprise(EnterpriseDto enterpriseDto);

    List<RoleDto> getAllRoles();

    UserDto getUserByUserName(String userName);

    Response addJobs(JobsDto jobsDto);

    Response editJobs(JobsDto jobsDto);

    JobsDto getJobsByEnterpriseAndProvince(String enterprise, String province, Date date);

    List<JobsDto> getAllJobs();

    List<ReportCriteriaDto> getAllReportCriterion();

    List<JobsDto> getJobsForAllProvincesForRange(Date fromDate, Date toDate);

    List<JobsDto> getEnterpriseJobsForRange(String enterprise, Date fromDate, Date toDate);

    List<DepartmentDto> getAllDepartments();

    Response addDepartment(DepartmentDto departmentDto);

    Response editDepartment(DepartmentDto departmentDto);

    List<ChartTypeDto> getAllChartTypes();

    List<JobsDto> getDepartmentJobsForRange(String department, Date fromDate, Date toDate);

    List<AnnualTurnOverDto> getAllAnnualTurnOvers();

    List<BbbeeRatingDto> getAllBbbeeRatings();
}
