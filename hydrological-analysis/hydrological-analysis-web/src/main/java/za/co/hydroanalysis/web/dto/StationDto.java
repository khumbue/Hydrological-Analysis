package za.co.hydroanalysis.web.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author khumbu
 */
public class StationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stationName;
    private String place;
    private int catchmentArea;
    private String dataAvailable;
    private long latitude;
    private long longitude;
    private Date date;
    private Date peakDate;

    //TODO: Change to correct variable type.
    private Date peakTime;
    private float peakFlow;
    private float peakLevel;
    private String peakCode1;
    private String peakCode2;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCatchmentArea() {
        return catchmentArea;
    }

    public void setCatchmentArea(int catchmentArea) {
        this.catchmentArea = catchmentArea;
    }

    public String getDataAvailable() {
        return dataAvailable;
    }

    public void setDataAvailable(String dataAvailable) {
        this.dataAvailable = dataAvailable;
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

    public Date getPeakDate() {
        return peakDate;
    }

    public void setPeakDate(Date peakDate) {
        this.peakDate = peakDate;
    }

    public Date getPeakTime() {
        return peakTime;
    }

    public void setPeakTime(Date peakTime) {
        this.peakTime = peakTime;
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

    public String getPeakCode1() {
        return peakCode1;
    }

    public void setPeakCode1(String peakCode1) {
        this.peakCode1 = peakCode1;
    }

    public String getPeakCode2() {
        return peakCode2;
    }

    public void setPeakCode2(String peakCode2) {
        this.peakCode2 = peakCode2;
    }
}
