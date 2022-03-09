package p2;

import java.time.LocalDate;
import java.util.Objects;
import p1.ContactInfo;

public class LoanApplication {

  private Name loanApplicant;
  private Name loanCoApplicant;
  private ContactInfo applicantsContactInfo; private String loanID;
  private LocalDate dateLoanSubmitted; private Double requestedAmount;
  private Double annualAPR;
  private Integer loanDurationInYears;

  public LoanApplication(Name loanApplicant, Name loanCoApplicant,
      ContactInfo applicantsContactInfo, String loanID, LocalDate dateLoanSubmitted,
      Double requestedAmount, Double annualAPR, Integer loanDurationInYears) {
    this.loanApplicant = loanApplicant;
    this.loanCoApplicant = loanCoApplicant;
    this.applicantsContactInfo = applicantsContactInfo;
    this.loanID = loanID;
    this.dateLoanSubmitted = dateLoanSubmitted;
    this.requestedAmount = requestedAmount;
    this.annualAPR = annualAPR;
    this.loanDurationInYears = loanDurationInYears;
  }

  public LoanApplication(Name loanApplicant, ContactInfo applicantsContactInfo,
                        String loanID, LocalDate dateLoanSubmitted, Double requestedAmount,
                        Double annualAPR, Integer loanDurationInYears) {
    this.loanApplicant = loanApplicant;
    this.loanCoApplicant = null;
    this.applicantsContactInfo = applicantsContactInfo;
    this.loanID = loanID;
    this.dateLoanSubmitted = dateLoanSubmitted;
    this.requestedAmount = requestedAmount;
    this.annualAPR = annualAPR;
    this.loanDurationInYears = loanDurationInYears;
  }

  public Name getLoanApplicant() {
    return loanApplicant;
  }

  public Name getLoanCoApplicant() {
    return loanCoApplicant;
  }

  public ContactInfo getApplicantsContactInfo() {
    return applicantsContactInfo;
  }

  public String getLoanID() {
    return loanID;
  }

  public LocalDate getDateLoanSubmitted() {
    return dateLoanSubmitted;
  }

  public Double getRequestedAmount() {
    return requestedAmount;
  }

  public Double getAnnualAPR() {
    return annualAPR;
  }

  public Integer getLoanDurationInYears() {
    return loanDurationInYears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LoanApplication)) return false;
    LoanApplication that = (LoanApplication) o;
    return Objects.equals(getLoanApplicant(), that.getLoanApplicant()) &&
        Objects.equals(getLoanCoApplicant(), that.getLoanCoApplicant()) && Objects.equals(getApplicantsContactInfo(), that.getApplicantsContactInfo()) && Objects.equals(getLoanID(), that.getLoanID()) && Objects.equals(getDateLoanSubmitted(), that.getDateLoanSubmitted()) && Objects.equals(getRequestedAmount(), that.getRequestedAmount()) && Objects.equals(getAnnualAPR(), that.getAnnualAPR()) && Objects.equals(getLoanDurationInYears(), that.getLoanDurationInYears());
  }
  @Override
  public int hashCode() {
    return Objects.hash(getLoanApplicant(),
        getLoanCoApplicant(), getApplicantsContactInfo(), getLoanID(), getDateLoanSubmitted(), getRequestedAmount(), getAnnualAPR(), getLoanDurationInYears());
  }

}
