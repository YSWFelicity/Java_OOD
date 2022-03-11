package problem2;


import java.net.CookieHandler;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;

public interface ICollegeAthleteRegistery {

  /**
   * Count the number of CollegeAthletes in the CollegeAthleteRegistery.
   */
  int count();

  /**
   * Check if a specific CollegeAthlete is included in the CollegeAthleteRegistery.
   * @param collegeAthlete
   * @return the boolean
   */
  Boolean checkCollegeAthletes(CollegeAthlete collegeAthlete);

  /**
   * Add a new CollegeAthlete into the CollegeAthleteRegistery.Please note that CollegeAthleteRegistery
   * does not allow duplicate CollegeAthletes.
   * @param collegeAthlete
   * @throws DuplicateCollegeAthleteException
   */
  void add(CollegeAthlete collegeAthlete) throws DuplicateCollegeAthleteException;

  /**
   * Modify information about an athlete
   * @param medals, totalEarningsThusFar, corporateDeals
   * @return string name
   * @throws InvalidCollegeAthleteException
   */
  CollegeAthlete modifyInfo(String[] medals, Double totalEarningsThusFar, String[] corporateDeals) throws InvalidCollegeAthleteException;

  /**
   * Remove a specific CollegeAthlete from the CollegeAthleteRegistery.
   * @param collegeAthlete
   * @throws CollegeAthleteNotFoundException
   */
  void remove(CollegeAthlete collegeAthlete) throws CollegeAthleteNotFoundException;

  /**
   * Find and return anyone CollegeAthlete that competes in a discipline. provided as an input argument.
   * @param discipline
   * @return
   */
  CollegeAthleteRegistery findCollegeAthleteByDiscipline(String discipline);

  /**
   * Find and return all CollegeAthletes whose total earnings so far are higher than the provided input argument.
   * @param totalEarningsThusFar
   * @return
   */
  CollegeAthleteRegistery findCollegeAthleteByEarnings(Double totalEarningsThusFar)
      throws DuplicateCollegeAthleteException;

  /**
   * Find and return all College Athletes who are attending a college specified by an input argument.
   * @return
   */
  CollegeAthleteRegistery findCollegeAthleteByAttending();
}
