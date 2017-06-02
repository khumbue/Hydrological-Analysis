package za.co.jobcreation.ejb.impl.util;

import za.co.jobcreation.api.dto.*;
import za.co.jobcreation.api.util.MapperHelper;
import za.co.jobcreation.ejb.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author khumbu
 */
public class Mapper {

    public IncomeCategory mapIncomeCategoryDtoToEntity(IncomeCategoryDto source) {
        IncomeCategory destination = new IncomeCategory();
        return (IncomeCategory) MapperHelper.copyProperties(destination, source);
    }

    public List<IncomeCategoryDto> mapIncomeCategoryEntitiesToDtos(List<IncomeCategory> sourceList) {
        List<IncomeCategoryDto> destinationList = new ArrayList<>();
        for (IncomeCategory source : sourceList) {
            destinationList.add(mapIncomeCategoryEntityToDto(source));
        }
        return destinationList;
    }

    private IncomeCategoryDto mapIncomeCategoryEntityToDto(IncomeCategory source) {
        IncomeCategoryDto destination = new IncomeCategoryDto();
        return (IncomeCategoryDto) MapperHelper.copyProperties(destination, source);
    }

    public Role mapRoleDtoToEntity(RoleDto source) {
        Role destination = new Role();
        return (Role) MapperHelper.copyProperties(destination, source);
    }

    public List<RoleDto> mapRoleEntitiesToDtos(List<Role> sourceList) {
        List<RoleDto> destinationList = new ArrayList<>();
        for (Role source : sourceList) {
            destinationList.add(mapRoleEntityToDto(source));
        }
        return destinationList;
    }

    private RoleDto mapRoleEntityToDto(Role source) {
        RoleDto destination = new RoleDto();
        return (RoleDto) MapperHelper.copyProperties(destination, source);
    }

    public IndustrySector mapIndustrySectorDtoToEntity(IndustrySectorDto source) {
        IndustrySector destination = new IndustrySector();
        return (IndustrySector) MapperHelper.copyProperties(destination, source);
    }

    public List<IndustrySectorDto> mapIndustrySectorEntitiesToDtos(List<IndustrySector> sourceList) {
        List<IndustrySectorDto> destinationList = new ArrayList<>();
        for (IndustrySector source : sourceList) {
            destinationList.add(mapIndustrySectorEntityToDto(source));
        }
        return destinationList;
    }

    public IndustrySectorDto mapIndustrySectorEntityToDto(IndustrySector source) {
        IndustrySectorDto destination = new IndustrySectorDto();
        return (IndustrySectorDto) MapperHelper.copyProperties(destination, source);
    }

    public List<AnnualTurnOverDto> mapAnnualTurnOverEntitiesToDtos(List<AnnualTurnOver> sourceList) {
        List<AnnualTurnOverDto> destinationList = new ArrayList<>();
        for (AnnualTurnOver source : sourceList) {
            destinationList.add(mapAnnualTurnOverEntityToDto(source));
        }
        return destinationList;
    }

    public AnnualTurnOver mapAnnualTurnOverDtoToEntity(AnnualTurnOverDto source) {
        AnnualTurnOver destination = new AnnualTurnOver();
        return (AnnualTurnOver) MapperHelper.copyProperties(destination, source);
    }

    public AnnualTurnOverDto mapAnnualTurnOverEntityToDto(AnnualTurnOver source) {
        AnnualTurnOverDto destination = new AnnualTurnOverDto();
        return (AnnualTurnOverDto) MapperHelper.copyProperties(destination, source);
    }

    public List<JobsDto> mapJobsEntitiesToDtos(List<Jobs> sourceList) {
        List<JobsDto> destinationList = new ArrayList<>();
        for (Jobs source : sourceList) {
            destinationList.add(mapJobsEntityToDto(source));
        }
        return destinationList;
    }

    public JobsDto mapJobsEntityToDto(Jobs source) {
        JobsDto destination = new JobsDto();
        destination = (JobsDto) MapperHelper.copyProperties(destination, source);
        destination.setDepartmentDto(mapDepartmentEntityToDto(source.getDepartment()));
        destination.setEnterpriseDto(mapEnterpriseEntityToDto(source.getEnterprise()));
        destination.setProvinceDto(mapProvinceEntityToDto(source.getProvince()));
        return destination;
    }

    public Jobs mapJobsDtoToEntity(JobsDto source) {
        Jobs destination = new Jobs();
        destination = (Jobs) MapperHelper.copyProperties(destination, source);
        return destination;
    }

    public Province mapProvinceDtoToEntity(ProvinceDto source) {
        Province destination = new Province();
        return (Province) MapperHelper.copyProperties(destination, source);
    }

    public List<EnterpriseDto> mapEnterpriseEntityToDtos(List<Enterprise> sourceList) {
        List<EnterpriseDto> destinationList = new ArrayList<>();
        for (Enterprise source : sourceList) {
            destinationList.add(mapEnterpriseEntityToDto(source));
        }
        return destinationList;
    }

    public Enterprise mapEnterpriseDtoToEntity(EnterpriseDto source) {
        Enterprise destination = new Enterprise();
        return (Enterprise) MapperHelper.copyProperties(destination, source);
    }

    public List<UserDto> mapUserEntityToDtos(List<User> sourceList) {
        List<UserDto> destinationList = new ArrayList<>();
        for (User source : sourceList) {
            destinationList.add(mapUserEntityToDto(source));
        }
        return destinationList;
    }

    public User mapUserDtoToEntity(UserDto source) {
        User destination = new User();
        return (User) MapperHelper.copyProperties(destination, source);
    }

    public UserDto mapUserEntityToDto(User source) {
        UserDto destination = new UserDto();
        destination = (UserDto) MapperHelper.copyProperties(destination, source);
        destination.setRole(mapRoleEntityToDto(source.getRole()));
        return destination;
    }

    private EnterpriseDto mapEnterpriseEntityToDto(Enterprise source) {
        EnterpriseDto destination = new EnterpriseDto();
        destination = (EnterpriseDto) MapperHelper.copyProperties(destination, source);
        if (source.getAddress() != null) {
            destination.setAddress(mapAddressEntityToDto(source.getAddress()));
        }
        destination.setIndustrySector(mapIndustrySectorEntityToDto(source.getIndustrySector()));
        destination.setAnnualTurnOver(mapAnnualTurnOverEntityToDto(source.getAnnualTurnOver()));
        destination.setBeeeRating(mapBeeeRatingEntityToDto(source.getBbbeeRating()));
        return destination;
    }

    public List<BbbeeRatingDto> mapBeeeRatingEntitiesToDtos(List<BbbeeRating> sourceList) {
        List<BbbeeRatingDto> destinationList = new ArrayList<>();
        for (BbbeeRating source : sourceList) {
            destinationList.add(mapBeeeRatingEntityToDto(source));
        }
        return destinationList;
    }

    public BbbeeRatingDto mapBeeeRatingEntityToDto(BbbeeRating source) {
        BbbeeRatingDto destination = new BbbeeRatingDto();
        return (BbbeeRatingDto) MapperHelper.copyProperties(destination, source);
    }

    private List<AddressDto> mapAddressEntitiesToDtos(List<Address> entities) {
        List<AddressDto> dtos = new ArrayList<>();
        for (Address entity : entities) {
            dtos.add(mapAddressEntityToDto(entity));
        }
        return dtos;
    }

    private AddressDto mapAddressEntityToDto(Address source) {
        AddressDto destination = new AddressDto();
        destination = (AddressDto) MapperHelper.copyProperties(destination, source);
        destination.setProvince(mapProvinceEntityToDto(source.getProvince()));
        return destination;
    }

    private List<Address> mapAddressDtosToEntities(List<AddressDto> addressDtos) {
        List<Address> entities = new ArrayList<>();
        for (AddressDto dto : addressDtos) {
            entities.add(mapAddressDtoToEntity(dto));
        }
        return entities;
    }

    public Address mapAddressDtoToEntity(AddressDto source) {
        Address destination = new Address();
        return (Address) MapperHelper.copyProperties(destination, source);
    }

    public List<ProvinceDto> mapProvinceEntitiesToDtos(List<Province> entities) {
        List<ProvinceDto> dtos = new ArrayList<>();
        for (Province entity : entities) {
            dtos.add(mapProvinceEntityToDto(entity));
        }
        return dtos;
    }

    public ProvinceDto mapProvinceEntityToDto(Province source) {
        ProvinceDto destination = new ProvinceDto();
        return (ProvinceDto) MapperHelper.copyProperties(destination, source);
    }

    public List<ReportCriteriaDto> mapReportCriteriaEntitiesToDtos(List<ReportCriteria> sourceList) {
        List<ReportCriteriaDto> destinationList = new ArrayList<>();
        for (ReportCriteria source : sourceList) {
            destinationList.add(mapReportCriteriaEntityToDto(source));
        }
        return destinationList;
    }

    public ReportCriteriaDto mapReportCriteriaEntityToDto(ReportCriteria source) {
        ReportCriteriaDto destination = new ReportCriteriaDto();
        return (ReportCriteriaDto) MapperHelper.copyProperties(destination, source);
    }

    public ReportCriteria mapReportCriteriaDtoToEntity(ReportCriteriaDto source) {
        ReportCriteria destination = new ReportCriteria();
        return (ReportCriteria) MapperHelper.copyProperties(destination, source);
    }

    public List<DepartmentDto> mapDepartmentEntityToDtos(List<Department> sourceList) {
        List<DepartmentDto> destinationList = new ArrayList<>();
        for (Department source : sourceList) {
            destinationList.add(mapDepartmentEntityToDto(source));
        }
        return destinationList;
    }

    public DepartmentDto mapDepartmentEntityToDto(Department source) {
        DepartmentDto destination = new DepartmentDto();
        destination = (DepartmentDto) MapperHelper.copyProperties(destination, source);
        if (source.getProvince() != null) {
            destination.setProvince(mapProvinceEntityToDto(source.getProvince()));
        }
        return destination;
    }

    public Department mapDepartmentDtoToEntity(DepartmentDto source) {
        Department destination = new Department();
        return (Department) MapperHelper.copyProperties(destination, source);
    }

    public ChartType mapChartTypeDtoToEntity(ChartTypeDto source) {
        ChartType destination = new ChartType();
        return (ChartType) MapperHelper.copyProperties(destination, source);
    }

    public List<ChartTypeDto> mapChartTypeEntitiesToDtos(List<ChartType> sourceList) {
        List<ChartTypeDto> destinationList = new ArrayList<>();
        for (ChartType source : sourceList) {
            destinationList.add(mapChartTypeEntityToDto(source));
        }
        return destinationList;
    }

    public ChartTypeDto mapChartTypeEntityToDto(ChartType source) {
        ChartTypeDto destination = new ChartTypeDto();
        return (ChartTypeDto) MapperHelper.copyProperties(destination, source);
    }

    public void updateEnterpriseEntityFields(Enterprise destination, EnterpriseDto source) {
        MapperHelper.copyProperties(destination, source);
    }

    public void updateUserEntityFields(User destination, UserDto source) {
        MapperHelper.copyProperties(destination, source);
    }
}
