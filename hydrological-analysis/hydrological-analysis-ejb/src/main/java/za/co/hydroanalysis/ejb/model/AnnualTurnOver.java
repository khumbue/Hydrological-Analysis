package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Audited(targetAuditMode = NOT_AUDITED)
@Entity
@Table(name = "ANNUAL_TURN_OVER")
public class AnnualTurnOver extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TURN_OVER", nullable = false)
    private String turnOver;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(String turnOver) {
        this.turnOver = turnOver;
    }

}
