package za.co.jobcreation.ejb.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.envers.Audited;

@Audited(withModifiedFlag = true)
@Entity
@Table(name = "APPLICATION_USER")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
