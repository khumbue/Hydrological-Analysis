package za.co.jobcreation.api.enums;

/**
 * @author khumbu
 */
public enum SearchType {
    EMPLOYEE_ID("ID Number"),
    EMPLOYEE_NUMBER("Employee Number"),
    EMPLOYEE_COMPANY("Company");

    private String searchCriteria;

    SearchType(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }
}
