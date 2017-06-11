package za.co.hydroanalysis.web.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.hydroanalysis.web.dto.StationDto;

/**
 * @author: khumbu
 */
public class HydrologicalAnalysisService {

    private static final long serialVersionUID = 1L;

    private static final String ID = "_id";
    private static final String STATION_NO = "Station_No";
    private static final String PLACE = "Place";
    private static final String CATCHMENT_AREA = "Catchment_Area";
    private static final String LATITUDE = "Latitude";
    private static final String LONGITUDE = "Longitude";
    private static final String DATA_AVAILABLE = "Data_Available";
    private static final String PEAK_DATE = "Peak_Date";
    private static final String PEAK_TIME = "Peak_Time";
    private static final String PEAK_FLOW = "Peak_Flow";
    private static final String PEAK_LEVEL = "Peak_Level";
    private static final String PEAK_CODE_1 = "Peak_Code1";
    private static final String PEAK_CODE_2 = "Peak_Code2";
    private static final String JSON_OBJECT_KEY = "stations";

    @Inject
    private HydrologicalAnalysisWebClient hydrologicalAnalysisWebClient;

    private static final Logger log = LoggerFactory.getLogger(HydrologicalAnalysisWebClient.class);

    public static void main(String[] args) {
        HydrologicalAnalysisService hydrologicalAnalysisService = new HydrologicalAnalysisService();
        List<StationDto> stations;
        stations = hydrologicalAnalysisService.getAllStationsData("VaalRGC");
        for (StationDto station : stations) {
            System.out.println("Station No. is: " + station.getStationName());
            System.out.println("Station place is: " + station.getPlace());
        }

        stations = hydrologicalAnalysisService.getAllStationPeaks("C1H001");
        for (StationDto station : stations) {
            System.out.println("Station peak date is: " + station.getPeakDate());
            System.out.println("Station peak flow is: " + station.getPeakFlow());
        }

        StationDto station;
        station = hydrologicalAnalysisService.getStationPeak("C1H001", new Date());
        System.out.println("Station peak date is: " + station.getPeakDate());
        System.out.println("Station peak flow is: " + station.getPeakFlow());

        station = hydrologicalAnalysisService.getStationData("C1H001", "VaalRGC");
        System.out.println("Station No. is: " + station.getStationName());
        System.out.println("Station place is: " + station.getPlace());
    }

    public List<StationDto> getAllStationsData(String stationName) {
        return mapStationsData(getForStations(stationName));
    }

    public List<StationDto> getAllStationPeaks(String stationName) {
        return mapStationPeaks(getForStations(stationName));
    }

    private JSONArray getForStations(String stationName) {
        JSONObject object = hydrologicalAnalysisWebClient.getAllStationsData(stationName);
        List<StationDto> stations = new ArrayList<StationDto>();
        return object.getJSONArray(JSON_OBJECT_KEY);
    }


    public List<StationDto> mapStationPeaks(JSONArray array) {
        List<StationDto> stations = new ArrayList<StationDto>();
        for (int i = 0; i < array.length(); i++) {
            stations.add(mapStationPeak(array.getJSONObject(i)));
        }
        return stations;
    }

    public List<StationDto> mapStationsData(JSONArray array) {
        List<StationDto> stations = new ArrayList<StationDto>();
        for (int i = 0; i < array.length(); i++) {
            stations.add(mapStationData(array.getJSONObject(i)));
        }
        return stations;
    }

    public StationDto getStationPeak(String stationName, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyymmdd");
        return mapStationPeak(getForStation(stationName + "&" + dateFormat.format(date)));
    }

    public StationDto getStationData(String stationName, String area) {
        return mapStationData(getForStation(area + "&" + stationName));
    }

    private JSONObject getForStation(String urlSuffix) {
        JSONObject object = hydrologicalAnalysisWebClient.getForStation(urlSuffix);
        JSONArray array = object.getJSONArray(JSON_OBJECT_KEY);
        return array.getJSONObject(0);
    }

    private StationDto mapStationData(JSONObject jsonObject) {
        StationDto station = new StationDto();
        station.setStationName(jsonObject.getString(STATION_NO));
        station.setPlace(jsonObject.getString(PLACE));
        station.setCatchmentArea(jsonObject.getInt(CATCHMENT_AREA));
        station.setLatitude(jsonObject.getLong(LATITUDE));
        station.setLongitude(jsonObject.getLong(LONGITUDE));
        station.setDataAvailable(jsonObject.getString(DATA_AVAILABLE));

        return station;
    }

    private StationDto mapStationPeak(JSONObject jsonObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        StationDto station = new StationDto();
        station.setPeakFlow(jsonObject.getBigDecimal(PEAK_FLOW).floatValue());
        station.setPeakLevel(jsonObject.getBigDecimal(PEAK_LEVEL).floatValue());
        station.setPeakCode1(jsonObject.getString(PEAK_CODE_1));
        station.setPeakCode2(jsonObject.getString(PEAK_CODE_2));
        try {
            station.setPeakDate(dateFormat.parse(String.valueOf(jsonObject.getInt(PEAK_DATE))));
            station.setPeakTime(dateFormat.parse(jsonObject.getString(PEAK_TIME)));
        } catch (ParseException ex) {

        }
        return station;
    }
}
