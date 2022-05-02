package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplicantProcessor {

  private List<Applicant> listOfApplicants = new ArrayList<>();

  public ApplicantProcessor(List<Applicant> listOfApplicants) {

    this.listOfApplicants = listOfApplicants;
  }

  public ApplicantProcessor(Applicant applicant1, Applicant applicant2){
    this.listOfApplicants.add(applicant1);
    this.listOfApplicants.add(applicant2);
  }

  public List<Applicant> getListOfApplicants() {
    return listOfApplicants;
  }

  public void addApplicant(Applicant applicant){
    if(applicant != null){
      this.listOfApplicants.add(applicant);
    }
  }

  /**
   * Method processApplicants takes a list of Applicants, and returns a map of applicants, where the key is
   * an applicant's previous employer
   * @param  - list of applicants
   * @return - map of applicants, parametrized by an applicant's previous employer
   */
  public static Map<String, List<Applicant>> processApplicants(List<Applicant> applicants){
    return applicants.stream().collect(Collectors.groupingBy(Applicant::getPreviousEmployer));
  }

  /**
   * Method filterBySkillExperience takes the required experience, and the required skill, and returns the list
   * of applicants who posses the needed skill and experience.
   * @param experience - the required experience, represented as an Integer
   * @param skill - the required skill, represented as a String
   * @return list of qualified applicants
   */
  public List<Applicant> filterBySkillExperience(Integer experience, String skill){
    //YOUR CODE HERE
    List<Applicant> resultingList = new ArrayList<>();
    resultingList = this.listOfApplicants.stream()
        .filter(x -> x.getYearsOfExperince() > experience && x.getSkills().contains(skill))
        .collect(Collectors.toList());
    return resultingList;
  }

  private static Boolean isQualifiedApplicant(Applicant applicant, Integer experience, List<String> skills){
    return applicant.getYearsOfExperince() > experience && applicant.getSkills().containsAll(skills);
  }

  public List<Applicant> filterBySkillExperience2(Integer experience, List<String> skills){
    return this.listOfApplicants.stream()
        .filter(x -> ApplicantProcessor.isQualifiedApplicant(x, experience, skills))
        .collect(Collectors.toList());
  }

}