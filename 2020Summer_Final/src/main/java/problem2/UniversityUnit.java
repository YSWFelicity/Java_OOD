package problem2;

/**
 * Class UniversityUnit represents information about a university unit, and faculty members appointment within
 * that unit. Every university unit has a name (e.g., College of Computer Sciences, School of Computer
 * Science and Engineering, Department of Bioengineering, etc.,). For every university unit, a faculty member
 * has a appointment title (e.g., assistant professor, associate research professor, professor of practice, etc.).
 * Every faculty member also has years of experience within a specific university unit.
 */
public class UniversityUnit {

  private String unitName;
  private String appointmentTitle;
  private Integer yearsOfExperience;

  public UniversityUnit(String unitName, String appointmentTitle, Integer yearsOfExperience) {
    this.unitName = unitName;
    this.appointmentTitle = appointmentTitle;
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getUnitName() {
    return unitName;
  }

  public String getAppointmentTitle() {
    return appointmentTitle;
  }

  public Integer getYearsOfExperience() {
    return yearsOfExperience;
  }
}
