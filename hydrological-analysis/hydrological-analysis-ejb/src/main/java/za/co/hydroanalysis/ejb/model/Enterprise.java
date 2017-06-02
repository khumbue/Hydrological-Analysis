package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author khumbu
 */
@Audited(withModifiedFlag = true)
@Entity
@Table(name = "ENTERPRISE")
public class Enterprise extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE")
    private boolean active;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "INDUSTRY_SECTOR_ID", referencedColumnName = "ID")
    private IndustrySector industrySector;

    @OneToOne
    @JoinColumn(name = "ANNUAL_TURN_OVER_ID", referencedColumnName = "ID")
    private AnnualTurnOver annualTurnOver;

    @OneToOne
    @JoinColumn(name = "BEEE_RATING_ID", referencedColumnName = "ID")
    private BbbeeRating bbbeeRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AnnualTurnOver getAnnualTurnOver() {
        return annualTurnOver;
    }

    public void setAnnualTurnOver(AnnualTurnOver annualTurnOver) {
        this.annualTurnOver = annualTurnOver;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public IndustrySector getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(IndustrySector industrySector) {
        this.industrySector = industrySector;
    }

    public BbbeeRating getBbbeeRating() {
        return bbbeeRating;
    }

    public void setBbbeeRating(BbbeeRating bbbeeRating) {
        this.bbbeeRating = bbbeeRating;
    }

    @Override
    public String toString() {
        return name;
    }
}
