package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

/**
 * @author khumbu
 */
@Audited(targetAuditMode = NOT_AUDITED)
@Entity
@Table(name = "CHART_TYPE")
public class ChartType extends BaseEntity {

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
