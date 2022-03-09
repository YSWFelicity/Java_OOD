package p1;

import java.util.Objects;

public abstract class TaxFiler implements ITaxFiler{

  protected String taxID;
  protected ContactInfo contactInfo;
  protected Double lastYearsEarnings;
  protected Double totalIncomeTaxPaid;
  protected Double mortgageInterestPaid;
  protected Double propertyTaxesPaid;
  protected Double studentLoanAndTuitionPaid;
  protected Double contributionToRetirementSavings;
  protected Double contributionToHealthSavings;
  protected Double charitableDonationsAndContributions;
  protected static final Double EARNINGS_MORTGAGE_THRESHOLD = 150000.0;
  protected static final Double MORTGAGE_INTERESTS_THRESHOLD = 12500.0;
  protected static final Double MORTGAGE_DEDUCTION = 2500.0;

  public TaxFiler(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions) {
    this.taxID = taxID;
    this.contactInfo = contactInfo;
    this.lastYearsEarnings = lastYearsEarnings;
    this.totalIncomeTaxPaid = totalIncomeTaxPaid;
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.propertyTaxesPaid = propertyTaxesPaid;
    this.studentLoanAndTuitionPaid = studentLoanAndTuitionPaid;
    this.contributionToRetirementSavings = contributionToRetirementSavings;
    this.contributionToHealthSavings = contributionToHealthSavings;
    this.charitableDonationsAndContributions = charitableDonationsAndContributions;
  }

  public String getTaxID() {
    return taxID;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public Double getLastYearsEarnings() {
    return lastYearsEarnings;
  }

  public Double getTotalIncomeTaxPaid() {
    return totalIncomeTaxPaid;
  }

  public Double getMortgageInterestPaid() {
    return mortgageInterestPaid;
  }

  public Double getPropertyTaxesPaid() {
    return propertyTaxesPaid;
  }

  public Double getStudentLoanAndTuitionPaid() {
    return studentLoanAndTuitionPaid;
  }

  public Double getContributionToRetirementSavings() {
    return contributionToRetirementSavings;
  }

  public Double getContributionToHealthSavings() {
    return contributionToHealthSavings;
  }

  public Double getCharitableDonationsAndContributions() {
    return charitableDonationsAndContributions;
  }

  protected Double retirementAndHealthSavingsDeduction() {
    return 0.0;
  }

  protected Double studentLoanDeduction() {
    return 0.0;
  }

  protected Double mortgageInterestAndPropertyDeduction() {
    if(this.lastYearsEarnings < EARNINGS_MORTGAGE_THRESHOLD &&
        this.mortgageInterestPaid > MORTGAGE_INTERESTS_THRESHOLD) {
      return MORTGAGE_DEDUCTION;
    }
    return 0.0;
  }


  protected Double calculateTaxableIncome() {
    return (this.lastYearsEarnings - this.totalIncomeTaxPaid
        - this.charitableDonationsAndContributions);
  }

  @Override
  public Double calculateTax() {
    return 0.0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxFiler taxFiler = (TaxFiler) o;
    return Objects.equals(taxID, taxFiler.taxID) && Objects.equals(contactInfo,
        taxFiler.contactInfo) && Objects.equals(lastYearsEarnings,
        taxFiler.lastYearsEarnings) && Objects.equals(totalIncomeTaxPaid,
        taxFiler.totalIncomeTaxPaid) && Objects.equals(mortgageInterestPaid,
        taxFiler.mortgageInterestPaid) && Objects.equals(propertyTaxesPaid,
        taxFiler.propertyTaxesPaid) && Objects.equals(studentLoanAndTuitionPaid,
        taxFiler.studentLoanAndTuitionPaid) && Objects.equals(
        contributionToRetirementSavings, taxFiler.contributionToRetirementSavings)
        && Objects.equals(contributionToHealthSavings, taxFiler.contributionToHealthSavings)
        && Objects.equals(charitableDonationsAndContributions,
        taxFiler.charitableDonationsAndContributions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid,
        mortgageInterestPaid, propertyTaxesPaid, studentLoanAndTuitionPaid,
        contributionToRetirementSavings, contributionToHealthSavings,
        charitableDonationsAndContributions);
  }

  @Override
  public String toString() {
    return "TaxFiler{" +
        "taxID='" + taxID + '\'' +
        ", contactInfo=" + contactInfo +
        ", lastYearsEarnings=" + lastYearsEarnings +
        ", totalIncomeTaxPaid=" + totalIncomeTaxPaid +
        ", mortgageInterestPaid=" + mortgageInterestPaid +
        ", propertyTaxesPaid=" + propertyTaxesPaid +
        ", studentLoanAndTuitionPaid=" + studentLoanAndTuitionPaid +
        ", contributionToRetirementSavings=" + contributionToRetirementSavings +
        ", contributionToHealthSavings=" + contributionToHealthSavings +
        ", charitableDonationsAndContributions=" + charitableDonationsAndContributions +
        '}';
  }
}
