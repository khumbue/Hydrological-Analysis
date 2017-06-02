package za.co.jobcreation.ejb.component;

/**
 * @author khumbu
 */
public enum SpecificExaminationTypeEnum {

    EAR_FUNCTION("Ear Function"),
    LUNG_FUNCTION("Lung Function"),
    PHYSICAL_FUNCTION("Physical Function");

    private String name;

    SpecificExaminationTypeEnum(String name){
        this.name = name;
    }

    public String getValue(){
        return name;
    }
}
