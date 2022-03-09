package p2;

import java.time.LocalDate;
import java.util.ArrayList;

public class LinkedLoanProcessingSystem implements LoanProcessingSystem {

  private static final Double LOAN_AMOUNT_MIN = 50000.0;
  private static final Double APR_MIN = 0.03;
  private static final Integer YEAR_MIN = 10;

  private Node head;
  private int numNodes;

  public LinkedLoanProcessingSystem() {
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Check whether the LoanProcessingSystem is empty.
   *
   * @return true if empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return this.head == null;
  }

  /**
   * Count the number of LoanApplications in the LoanProcessingSystem
   *
   * @return number of LoanApplications in the LoanProcessing System
   */
  @Override
  public Integer size() {
    return this.numNodes;
  }

  /**
   * Add a LoanApplication to the LoanProcessingSystem. Please note that LoanProcessingSystem does
   * allow duplicate LoanApplications.
   *
   * @param application - LoanApplication to add to LoanProcessingSystem
   */
  @Override
  public void addApplication(LoanApplication application) {
    Node newNode = new Node(application, null);
    if (this.isEmpty()) {
      this.head = newNode;
    } else {
      Node curNode = this.head;
      while (curNode.getNextNode() != null) {
        curNode = curNode.getNextNode();
      }
      curNode.setNextNode(newNode);
    }
    this.numNodes++;
  }

  /**
   * Remove a specified LoanApplication from the LoanProcessingSystem. If the LoanApplication does
   * not exist in the LoanProcessingSystem, the system should throw LoanApplicationNotFoundException.
   *
   * @param application - LoanApplication to be removed
   * @throws LoanApplicationNotFoundException - thrown when LoanApplication is not found
   */
  @Override
  public void removeApplications(LoanApplication application)
      throws LoanApplicationNotFoundException {
    if (this.isEmpty()) {
      throw new LoanApplicationNotFoundException("Empty system");
    }
    boolean removed = Boolean.FALSE;
    while (this.head.getApplication().equals(application)) {
      this.head = this.head.getNextNode();
      removed = Boolean.TRUE;
      this.numNodes--;
    }

    Node curNode = this.head;
    while (curNode.getNextNode() != null) {
      if (curNode.getNextNode().getApplication().equals(application)) {
        curNode.setNextNode(curNode.getNextNode().getNextNode());
        removed = Boolean.TRUE;
        this.numNodes--;
      }
      curNode = curNode.getNextNode();
    }

    if (removed) {
      throw new LoanApplicationNotFoundException("Application Not Found");
    }
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem that were submitted on the
   * same day.
   *
   * @param date - Date we are looking for LoanApplications submitted on
   * @return - Array List of all LoanApplications with dateLoanSubmitted matching data param
   */
  @Override
  public ArrayList<LoanApplication> findSameDayApplications(LocalDate date) {
    ArrayList<LoanApplication> result = new ArrayList<>();
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getApplication().getDateLoanSubmitted().equals(date)) {
        result.add(curNode.getApplication());
      }
      curNode = curNode.getNextNode();
    }
    return result;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is greater than $50 000 per year.
   *
   * @return Array List of LoanApplications with requestedAmount greater than $50,000 per year
   */
  @Override
  public ArrayList<LoanApplication> findLoanRequestedAmount() {
    ArrayList<LoanApplication> result = new ArrayList<>();
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getApplication().getRequestedAmount() > LOAN_AMOUNT_MIN) {
        result.add(curNode.getApplication());
      }
      curNode = curNode.getNextNode();
    }
    return result;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the annual interest
   * rate is greater than 3 percent.
   *
   * @return Array List of LoanApplications with apr greater than 0.03.
   */
  @Override
  public ArrayList<LoanApplication> findLoansInterestRate() {
    ArrayList<LoanApplication> result = new ArrayList<>();
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getApplication().getAnnualAPR() > APR_MIN) {
        result.add(curNode.getApplication());
      }
      curNode = curNode.getNextNode();
    }
    return result;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   *
   * @return Array List of LoanApplications with loanDuration greater than 10 years.
   */
  @Override
  public ArrayList<LoanApplication> findLoansRepaymentPeriod() {
    ArrayList<LoanApplication> result = new ArrayList<>();
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getApplication().getLoanDurationInYears() > YEAR_MIN) {
        result.add(curNode.getApplication());
      }
      curNode = curNode.getNextNode();
    }
    return result;
  }

  /**
   * Get a LoanApplication from the LoanProcessingSystem based upon the LoanApplication's unique
   * identifier, loanID. The system throws an InvalidLoanIDException if the given number does not
   * exist.
   *
   * @param loanID - unique loanID
   * @return LoanApplication with loanID matching loanID param
   * @throws InvalidLoanIDException if loanID is not found
   */
  @Override
  public LoanApplication get(String loanID) throws InvalidLoanIDException {
    Node curNode = this.head;
    while (curNode != null) {
      if (curNode.getApplication().getLoanID().equals(loanID)) {
        return curNode.getApplication();
      }
      curNode = curNode.getNextNode();
    }
    throw new InvalidLoanIDException("Application with ID not found");
  }
}
