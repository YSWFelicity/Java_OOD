package p2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interface for LoanProcessingSystem ADT, which will be used to store and process the
 * received loan applications.
 */
public interface LoanProcessingSystem {

  /**
   * Check whether the LoanProcessingSystem is empty.
   * @return true if empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Count the number of LoanApplications in the LoanProcessingSystem
   * @return number of LoanApplications in the LoanProcessing System
   */
  Integer size();

  /**
   * Add a LoanApplication to the LoanProcessingSystem. Please note that LoanProcessingSystem does
   * allow duplicate LoanApplications.
   * @param application - LoanApplication to add to LoanProcessingSystem
   */
  void addApplication(LoanApplication application);

  /**
   * Remove a specified LoanApplication from the LoanProcessingSystem. If the LoanApplication does
   * not exist in the LoanProcessingSystem, the system should throw
   * LoanApplicationNotFoundException.
   * @param application - LoanApplication to be removed
   * @throws LoanApplicationNotFoundException - thrown when LoanApplication is not found
   */
  void removeApplications(LoanApplication application) throws LoanApplicationNotFoundException;

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem that were submitted on the
   * same day.
   * @param date - Date we are looking for LoanApplications submitted on
   * @return - Array List of all LoanApplications with dateLoanSubmitted matching data param
   */
  ArrayList<LoanApplication> findSameDayApplications(LocalDate date);

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is greater than $50 000 per year.
   * @return Array List of LoanApplications with requestedAmount greater than $50,000 per year
   */
  ArrayList<LoanApplication> findLoanRequestedAmount();

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the annual
   * interest rate is greater than 3 percent.
   * @return Array List of LoanApplications with apr greater than 0.03.
   */
  ArrayList<LoanApplication> findLoansInterestRate();

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   * @return Array List of LoanApplications with loanDuration greater than 10 years.
   */
  ArrayList<LoanApplication> findLoansRepaymentPeriod();

  /**
   * Get a LoanApplication from the LoanProcessingSystem based upon the LoanApplication's unique
   * identifier, loanID. The system throws an InvalidLoanIDException if the given number does not
   * exist.
   * @param loanID - unique loanID
   * @return LoanApplication with loanID matching loanID param
   * @throws InvalidLoanIDException if loanID is not found
   */
  LoanApplication get(String loanID) throws InvalidLoanIDException;
}
