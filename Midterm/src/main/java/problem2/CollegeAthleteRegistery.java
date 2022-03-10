package problem2;

public class CollegeAthleteRegistery implements ICollegeAthleteRegistery{
  private Node head;
  private int numOfNode;

  public CollegeAthleteRegistery(Node head, int numOfNode) {
    this.head = null;
    this.numOfNode = 0;
  }

  public static CollegeAthleteRegistery createEmpty() {
    return new CollegeAthleteRegistery();
  }

  /**
   * Count the number of CollegeAthletes in the CollegeAthleteRegistery.
   */
  @Override
  public int count() {
    return numOfNode;
  }

  /**
   * Check if a specific CollegeAthlete is included in the CollegeAthleteRegistery.
   *
   * @param collegeAthlete
   * @return the boolean
   */
  @Override
  public Boolean checkCollegeAthletes(CollegeAthlete collegeAthlete) {
    Node cur = this.head;
    while (cur != null) {
      if (cur.getCollegeAthlete().equals(collegeAthlete)) {
        return true;
      }
      cur = cur.getNextNode();
    }
    return false;
  }

  /**
   * Add a new CollegeAthlete into the CollegeAthleteRegistery.Please note that
   * CollegeAthleteRegistery does not allow duplicate CollegeAthletes.
   *
   * @param collegeAthlete
   * @throws DuplicateCollegeAthleteException
   */
  @Override
  public void add(CollegeAthlete collegeAthlete) throws DuplicateCollegeAthleteException {
    if (collegeAthlete == null) {
      throw new DuplicateCollegeAthleteException("There's no such College Athlete");
    }
    Node newNode = new Node(collegeAthlete, null);
    if (this.head == null) {
      this.head = newNode;
    } else {
      Node curNode = this.head;
      while (curNode.getNextNode() != null) {
        curNode = curNode.getNextNode();
      }
      curNode.setNextNode(newNode);
    }
    this.numOfNode++;
  }

  /**
   * Modify information about an athlete
   *
   * @param Info
   * @return string name
   * @throws InvalidCollegeAthleteException
   */
  @Override
  public CollegeAthlete modifyInfo(String Info) throws InvalidCollegeAthleteException {
    Node cur = this.head;
    if (cur.getCollegeAthlete() == null) {
      throw new InvalidCollegeAthleteException();
    }
    return cur.getCollegeAthlete();
  }

  /**
   * Remove a specific CollegeAthlete from the CollegeAthleteRegistery.
   *
   * @param collegeAthlete
   * @throws CollegeAthleteNotFoundException
   */
  @Override
  public void remove(CollegeAthlete collegeAthlete) throws CollegeAthleteNotFoundException {
    Node dummy = new Node(null, head);
    Node cur = dummy;

    while (cur != null) {
      if (cur.getNextNode() == null || !cur.getNextNode().getCollegeAthlete().equals(collegeAthlete)) {
        cur = cur.getNextNode();
        continue;
      }

      Node next = cur.getNextNode();
      cur.setNextNode(next.getNextNode());
      next.setNextNode(null);

      this.numOfNode--;
    }
    if (cur == null) {
      throw new CollegeAthleteNotFoundException("Employee Not Found!");
    }
    this.head = dummy.getNextNode();
  }

  /**
   * Find and return anyone CollegeAthlete that competes in a discipline. provided as an input
   * argument.
   *
   * @param discipline
   * @return
   */
  @Override
  public CollegeAthleteRegistery findCollegeAthleteByDiscipline(String discipline) {
    return null;
  }

  /**
   * Find and return all CollegeAthletes whose total earnings so far are higher than the provided
   * input argument.
   *
   * @param annualEarnings
   * @return
   */
  @Override
  public CollegeAthleteRegistery findCollegeAthleteByEarnings(Double annualEarnings)
      throws DuplicateCollegeAthleteException {
    CollegeAthleteRegistery newList = createEmpty();

    Node cur = this.head;
    int i = 0;
    while (i < numOfNode) {
      i++;
      while (!cur.getCollegeAthlete().getTotalEarningsThusFar().equals(annualEarnings)) {
        cur = cur.getNextNode();
      }
      newList.add(cur.getCollegeAthlete());
    }
    return newList;
  }

  private CollegeAthleteRegistery createEmpty() {
    return new CollegeAthleteRegistery();
  }

  /**
   * Find and return all College Athletes who are attending a college specified by an input
   * argument.
   *
   * @return
   */
  @Override
  public CollegeAthleteRegistery findCollegeAthleteByAttending() {
    return null;
  }
}
