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
@Table(name = "SETTING")
public class Setting extends BaseEntity {
    @Column(name = "SETTING_KEY")
    private String key;

    @Column
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
