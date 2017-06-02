package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

import javax.persistence.*;


@Audited(targetAuditMode = NOT_AUDITED)
@Entity
@Table(name = "PROVINCE")
public class Province extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
