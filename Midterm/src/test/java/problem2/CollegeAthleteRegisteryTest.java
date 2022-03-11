package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CollegeAthleteRegisteryTest {

  private Name athletesName;
  private LocalDate dateOfBirth;
  private String discipline;
  private String representedCountry;
  private Integer[] yearsOnNationalTeam;
  private String college;
  private String collegeTeam;
  private String[] medals;
  private Double totalEarningsThusFar;
  private String[] corporateDeals;
  private CollegeAthlete expectedCollegeAthlete;
  private CollegeAthlete expectedCollegeAthlete2;
  private CollegeAthleteRegistery testCollegeAthleteRegistry;
  private CollegeAthleteRegistery testCollegeAthleteRegistry2;

  @BeforeEach
  void setUp() {
    Name name = new Name("Ying", "Shu", "Wang", "Vivian");
    athletesName = name;
    dateOfBirth = LocalDate.of(2022, 3, 10);
    discipline = "Perfect";
    representedCountry = "US";
    yearsOnNationalTeam = new Integer[]{2021};
    college = "NEU";
    collegeTeam = "NEU husky";
    medals = new String[]{"3"};
    totalEarningsThusFar = 80000d;
    corporateDeals = new String[]{"23"};
  }


  @Test
  void count() {
    assertEquals(4, CollegeAthleteRegistery.createEmpty());

  }

  @Test
  void checkCollegeAthletes() throws Exception {
    asertTrue(CollegeAthlete.checkCollegeAthletes(CollegeAthlete));
  }

  @Test
  void remove() throws CollegeAthleteNotFoundException {
    assertEquals(testCollegeAthleteRegistry, testCollegeAthleteRegistry.remove(expectedCollegeAthlete);

  }

  @Test
  void findCollegeAthleteByDiscipline() {
    discipline = "Perfect";
    expectedCollegeAthlete2 = new CollegeAthlete(athletesName, dateOfBirth, discipline, representedCountry, yearsOnNationalTeam, college, collegeTeam, medals, totalEarningsThusFar,
        corporateDeals);
    testCollegeAthleteRegistry = testCollegeAthleteRegistry.add();
  }
}