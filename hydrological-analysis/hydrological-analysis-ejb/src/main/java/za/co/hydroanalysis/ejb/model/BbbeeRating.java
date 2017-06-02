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
@Table(name = "BBBEE_RATING")
public class BbbeeRating extends BaseEntity {

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
