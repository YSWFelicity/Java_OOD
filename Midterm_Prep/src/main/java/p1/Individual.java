package p1;

public abstract class Individual extends TaxFiler {

  private static final Double HEALTH_REDUCTION = 0.7;
  protected static final Double LAST_YEARS_EARNINGS_THRESHOLD_EDUCATION = 75000.0;
  protected static final Double EDUCATION_EXPENSES_THRESHOLD = 5000.0;
  protected static final Double EDUCATION_DEDUCTION = 1500.0;
  protected static final Double TAXABLE_INCOME_THRESHOLD = 55000.0;
  protected static final Double TAX_FACTOR_LOW = 0.15;
  protected static final Double TAX_FACTOR_HIGH = 0.19;

  public Individual(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions) {
    super(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        propertyTaxesPaid, studentLoanAndTuitionPaid, contributionToRetirementSavings,
        contributionToHealthSavings, charitableDonationsAndContributions);
  }

  @Override
  protected Double retirementAndHealthSavingsDeduction() {
    return (this.contributionToHealthSavings + this.contributionToRetirementSavings) * HEALTH_REDUCTION;
  }

  @Override
  protected Double studentLoanDeduction() {
    if (this.lastYearsEarnings < LAST_YEARS_EARNINGS_THRESHOLD_EDUCATION &&
        this.studentLoanAndTuitionPaid > EDUCATION_EXPENSES_THRESHOLD) {
      return EDUCATION_DEDUCTION;
    }
    return 0.0;
  }

  @Override
  public Double calculateTaxableIncome() {
    return super.calculateTaxableIncome() - this.retirementAndHealthSavingsDeduction() -
        this.studentLoanDeduction() - this.mortgageInterestAndPropertyDeduction();
  }

  @Override
  public Double calculateTax() {
    if (this.calculateTaxableIncome() < TAXABLE_INCOME_THRESHOLD) {
      return this.calculateTaxableIncome() * TAX_FACTOR_LOW;
    } // Assuming >=
    else {
      return this.calculateTaxableIncome() * TAX_FACTOR_HIGH;
    }
  }
}
