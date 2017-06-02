package za.co.hydroanalysis.api;

import za.co.hydroanalysis.api.dto.StationDto;
import za.co.hydroanalysis.api.dto.*;

import java.util.Date;
import java.util.List;

public interface IHydrologicalAnalysisService {

    List<StationDto> getAllStationsData();

    StationDto getStationData(String stationName);

}
