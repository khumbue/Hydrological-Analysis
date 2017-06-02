package za.co.hydroanalysis.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by khumbulani on 6/2/17.
 */
public class StationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stationName;
    private long latitude;
    private long longitude;
    private Date date;

    //TODO: Change to correct variable type.
    private Date timeOfPeak;
    private float peakFlow;
    private float peakLevel;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimeOfPeak() {
        return timeOfPeak;
    }

    public void setTimeOfPeak(Date timeOfPeak) {
        this.timeOfPeak = timeOfPeak;
    }

    public float getPeakFlow() {
        return peakFlow;
    }

    public void setPeakFlow(float peakFlow) {
        this.peakFlow = peakFlow;
    }

    public float getPeakLevel() {
        return peakLevel;
    }

    public void setPeakLevel(float peakLevel) {
        this.peakLevel = peakLevel;
    }
}
