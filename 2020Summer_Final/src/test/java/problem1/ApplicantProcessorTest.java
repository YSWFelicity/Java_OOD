package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicantProcessorTest {

  List<String> listOfSkills1 = new ArrayList<>();
  List<String> listOfSkills2 = new ArrayList<>();

  Applicant applicant1;
  Applicant applicant2;
  Applicant applicant3;
  Applicant applicant4;
  Applicant applicant5;
  Applicant applicant6;

  ApplicantProcessor testApplicantProcessor1;
  ApplicantProcessor testApplicantProcessor2;
  ApplicantProcessor testApplicantProcessor3;

  List<Applicant> expectedApplicants1 = new ArrayList<>();
  List<Applicant> expectedApplicants2 = new ArrayList<>();
  List<Applicant> expectedApplicants3 = new ArrayList<>();
  List<Applicant> expectedApplicants4 = new ArrayList<>();

  Map<String, List<Applicant>> expectedMap = new HashMap<>();

  @BeforeEach
  void setUp() {
    listOfSkills1.add("Software engineering");
    listOfSkills1.add("Cloud computing");
    listOfSkills1.add("Privacy engineering");
    listOfSkills1.add("MLOps");

    listOfSkills2.add("Cryptography");
    listOfSkills2.add("Rust");
    listOfSkills2.add("Pentesting");
    listOfSkills2.add("Malware analysis");

    applicant1 = new Applicant("Jane", "Doe", "Meta", 3, listOfSkills1);
    applicant2 = new Applicant("Seth", "Horvath", "Amazon", 10, listOfSkills2);
    applicant3 = new Applicant("Bo", "Ross", "Amazon", 5, listOfSkills2);
    applicant4 = new Applicant("Susanna", "Andrews", "Google", 15, listOfSkills2);
    applicant5 = new Applicant("Sarah", "Thomas", "Northeastern University", 12, listOfSkills1);
    applicant6 = new Applicant("John", "Mack", "Meta", 2, listOfSkills1);

    //Multiple applicants with the same employer
    testApplicantProcessor1 = new ApplicantProcessor(applicant1, applicant2);
    testApplicantProcessor1.addApplicant(applicant3);
    testApplicantProcessor1.addApplicant(applicant4);
    testApplicantProcessor1.addApplicant(applicant5);
    testApplicantProcessor1.addApplicant(applicant6);

    //Two applicants with the same employer
    testApplicantProcessor2 = new ApplicantProcessor(applicant2, applicant3);

    //No applicants with the same employer
    testApplicantProcessor3 = new ApplicantProcessor(applicant1, applicant4);
    testApplicantProcessor3.addApplicant(applicant5);

    //Expected list of applicants
    expectedApplicants1.add(applicant2);
    expectedApplicants1.add(applicant3);

    expectedApplicants2.add(applicant4);

    expectedApplicants3.add(applicant1);
    expectedApplicants3.add(applicant6);

    expectedApplicants4.add(applicant5);

  }

  @Test
  void processApplicants_NoApplicantsWithTheSameEmployer() {
    expectedMap.clear();

    List<Applicant> expectedMetaApplicant = new ArrayList<>();
    expectedMetaApplicant.add(applicant1);
    expectedMap.put("Meta", expectedMetaApplicant);

    List<Applicant> expectedGoogleApplicant = new ArrayList<>();
    expectedGoogleApplicant.add(applicant4);
    expectedMap.put("Google", expectedGoogleApplicant);

    List<Applicant> expectedNEUApplicant = new ArrayList<>();
    expectedNEUApplicant.add(applicant5);
    expectedMap.put("Northeastern University", expectedNEUApplicant);

    assertEquals(expectedMap, ApplicantProcessor.processApplicants(testApplicantProcessor3.getListOfApplicants()));
  }

  @Test
  void processApplicants_TwoApplicantsWithTheSameEmployer() {
    expectedMap.clear();
    expectedMap.put("Amazon", expectedApplicants1);

    assertEquals(expectedMap, ApplicantProcessor.processApplicants(testApplicantProcessor2.getListOfApplicants()));
  }

  @Test
  void processApplicants_MultipleApplicantsWithTheSameEmployer() {
    expectedMap.clear();
    expectedMap.put("Amazon", expectedApplicants1);
    expectedMap.put("Google", expectedApplicants2);
    expectedMap.put("Meta", expectedApplicants3);
    expectedMap.put("Northeastern University", expectedApplicants4);

    assertEquals(expectedMap, ApplicantProcessor.processApplicants(testApplicantProcessor1.getListOfApplicants()));
  }

  @Test
  void filterBySkillExperience_OneApplicant() {
    assertEquals(expectedApplicants2, testApplicantProcessor1.filterBySkillExperience(14, "Rust"));
  }

  @Test
  void filterBySkillExperience_NoQualifiedApplicant() {
    assertEquals(new ArrayList<>(), testApplicantProcessor1.filterBySkillExperience(16, "Rust"));
  }

  @Test
  void filterBySkillExperience_MultipleQualifiedApplicant() {
    List<Applicant> expectedApplicants = new ArrayList<>();
    expectedApplicants.add(applicant2);
    expectedApplicants.add(applicant3);
    expectedApplicants.add(applicant4);
    assertEquals(expectedApplicants, testApplicantProcessor1.filterBySkillExperience(4, "Rust"));
  }
}