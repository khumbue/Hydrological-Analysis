package za.co.jobcreation.ejb.model;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import za.co.jobcreation.ejb.impl.util.AuditListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author khumbu
 */
@Entity
@Table(name = "REVISION_ENTITY")
@org.hibernate.envers.RevisionEntity(AuditListener.class)
public class RevisionEntity implements Serializable {

    private static final long serialVersionUID = -3344484071287964706L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    private Date timestamp;

    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
