package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author khumbu
 */

@Embeddable
public class Address implements Serializable {

    @Column(name = "STREET_LINE_1")
    private String streetLine1;

    @Column(name = "STREET_LINE_2")
    private String streetLine2;

    @Column(name = "STREET_LINE_3")
    private String streetLine3;

    @Column(name = "SUBURB")
    private String suburb;

    @Column(name = "CITY")
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

    @Column(name = "CODE")
    private String code;

    @Column(name = "COUNTRY")
    private String country;

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getStreetLine3() {
        return streetLine3;
    }

    public void setStreetLine3(String streetLine3) {
        this.streetLine3 = streetLine3;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
