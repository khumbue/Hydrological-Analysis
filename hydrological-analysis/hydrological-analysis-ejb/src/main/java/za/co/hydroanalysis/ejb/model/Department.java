package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

/**
 * @author khumbu
 */
@Audited(withModifiedFlag = true)
@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
//    private List<Enterprise> enterprises;

    @OneToOne
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

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

    /*public List<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }*/

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return name;
    }
}
