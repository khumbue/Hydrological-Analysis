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
@Table(name = "REPORT_CRITERIA")
public class ReportCriteria extends BaseEntity {

    @Column(name = "CRITERIA")
    private String criteria;

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}
