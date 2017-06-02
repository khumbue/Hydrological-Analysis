package za.co.jobcreation.ejb.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.envers.Audited;

@Audited(withModifiedFlag = true)
@NamedQueries({
        @NamedQuery(name = Jobs.FIND_BY_ENTERPRISE_AND_PROVINCE, query = "SELECT j FROM Jobs j WHERE j.enterprise.name = ?1 AND j.province.name = ?2 AND j.date = ?3"),
        @NamedQuery(name = Jobs.FIND_FOR_ALL_PROVINCES_FOR_RANGE, query = "SELECT j FROM Jobs j WHERE j.date >= ?1 AND j.date <= ?2"),
        @NamedQuery(name = Jobs.FIND_FOR_ENTERPRISE_FOR_RANGE, query = "SELECT j FROM Jobs j WHERE j.enterprise.name = ?1 AND j.date >= ?2 AND j.date <= ?3"),
        @NamedQuery(name = Jobs.FIND_FOR_DEPARTMENT_FOR_RANGE, query = "SELECT j FROM Jobs j WHERE j.department.name = ?1 AND j.date >= ?2 AND j.date <= ?3"),
})
@Entity
@Table(name = "JOBS")
public class Jobs extends BaseEntity {

    private static final long serialVersionUID = 4663528760282383776L;
    public static final String FIND_BY_ENTERPRISE_AND_PROVINCE = "findByEnterpriseAndProvince";
    public static final String FIND_FOR_ALL_PROVINCES_FOR_RANGE = "findForAllProvincesForRange";
    public static final String FIND_FOR_ENTERPRISE_FOR_RANGE = "findForEnterpriseForRange";
    public static final String FIND_FOR_DEPARTMENT_FOR_RANGE = "findForDepartmentForRange";

    @Column(name = "PROCUREMENT_SPEND")
    private long procurementSpend;

    @Column(name = "NUMBER_OF_JOBS", nullable = false)
    private int numberOfJobs;

    @Column(name = "SHORT_TERM_JOBS", nullable = false)
    private int shortTermJobs;

    @Column(name = "LONG_TERM_JOBS", nullable = false)
    private int longTermJobs;

    @Column(name = "YOUTH_LEARNER_JOBS", nullable = false)
    private int youthLearnerJobs;

    @Column(name = "DISABILITY_JOBS", nullable = false)
    private int disabilityJobs;

    @Column(name = "WOMEN_JOBS", nullable = false)
    private int womenJobs;

    @Column(name = "BLACK_JOBS", nullable = false)
    private int blackJobs;

    @Column(name = "WHITE_JOBS", nullable = false)
    private int whiteJobs;

    @Column(name = "COLOURED_JOBS", nullable = false)
    private int colouredJobs;

    @Column(name = "INDIAN_JOBS", nullable = false)
    private int indianJobs;

    @Column(name = "LOW_INCOME_JOBS", nullable = false)
    private int lowIncomeJobs;

    @Column(name = "MEDIUM_INCOME_JOBS", nullable = false)
    private int mediumIncomeJobs;

    @Column(name = "HIGH_INCOME_JOBS", nullable = false)
    private int highIncomeJobs;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "ENTERPRISE_ID", referencedColumnName = "ID")
    private Enterprise enterprise;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

    public long getProcurementSpend() {
        return procurementSpend;
    }

    public void setProcurementSpend(long procurementSpend) {
        this.procurementSpend = procurementSpend;
    }

    public int getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setNumberOfJobs(int numberOfJobs) {
        this.numberOfJobs = numberOfJobs;
    }

    public int getShortTermJobs() {
        return shortTermJobs;
    }

    public void setShortTermJobs(int shortTermJobs) {
        this.shortTermJobs = shortTermJobs;
    }

    public int getLongTermJobs() {
        return longTermJobs;
    }

    public void setLongTermJobs(int longTermJobs) {
        this.longTermJobs = longTermJobs;
    }

    public int getYouthLearnerJobs() {
        return youthLearnerJobs;
    }

    public void setYouthLearnerJobs(int youthLearnerJobs) {
        this.youthLearnerJobs = youthLearnerJobs;
    }

    public int getDisabilityJobs() {
        return disabilityJobs;
    }

    public void setDisabilityJobs(int disabilityJobs) {
        this.disabilityJobs = disabilityJobs;
    }

    public int getWomenJobs() {
        return womenJobs;
    }

    public void setWomenJobs(int womenJobs) {
        this.womenJobs = womenJobs;
    }

    public int getBlackJobs() {
        return blackJobs;
    }

    public void setBlackJobs(int blackJobs) {
        this.blackJobs = blackJobs;
    }

    public int getWhiteJobs() {
        return whiteJobs;
    }

    public void setWhiteJobs(int whiteJobs) {
        this.whiteJobs = whiteJobs;
    }

    public int getColouredJobs() {
        return colouredJobs;
    }

    public void setColouredJobs(int colouredJobs) {
        this.colouredJobs = colouredJobs;
    }

    public int getIndianJobs() {
        return indianJobs;
    }

    public void setIndianJobs(int indianJobs) {
        this.indianJobs = indianJobs;
    }

    public int getLowIncomeJobs() {
        return lowIncomeJobs;
    }

    public void setLowIncomeJobs(int lowIncomeJobs) {
        this.lowIncomeJobs = lowIncomeJobs;
    }

    public int getMediumIncomeJobs() {
        return mediumIncomeJobs;
    }

    public void setMediumIncomeJobs(int mediumIncomeJobs) {
        this.mediumIncomeJobs = mediumIncomeJobs;
    }

    public int getHighIncomeJobs() {
        return highIncomeJobs;
    }

    public void setHighIncomeJobs(int highIncomeJobs) {
        this.highIncomeJobs = highIncomeJobs;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Jobs [id=" + getId() + ", enterprise=" + enterprise.getId() + "]";
    }
}
