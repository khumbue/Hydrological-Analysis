package za.co.jobcreation.ejb.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Audited(targetAuditMode = NOT_AUDITED)
@Entity
@Table(name = "INCOME_CATEGORY")
public class IncomeCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
