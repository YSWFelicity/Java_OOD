package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CollegeAthleteRegisteryTest {

  CollegeAthleteRegistery car;
  CollegeAthlete c1;

  @BeforeEach
  void setUp() {
    car = new CollegeAthleteRegistery();

    Name name = new Name("Ying", "Shu", "Wang", "Vivian");
//    CollegeAthlete collegeAthlete = new CollegeAthlete(name, LocalDate.of(2022, 3, 10),
//        "Perfect", "US", new Integer[]{2021}, "NEU", "NEU husky", new String[]{"3"}, 80000d,
//        new String[]{"23"});

  }

  @Test
  void count() {
    Name name = new Name("Ying", "Shu", "Wang", "Vivian");
    CollegeAthlete collegeAthlete = new CollegeAthlete(name, LocalDate.of(2022, 3, 10),
        "Perfect", "US", new Integer[]{2021}, "NEU", "NEU husky", new String[]{"3"}, 80000d,
        new String[]{"23"});
    assertEquals(2,);
  }

  @Test
  void checkCollegeAthletes() {
  }

  @Test
  void remove() {
  }

  @Test
  void findCollegeAthleteByDiscipline() {
  }
}