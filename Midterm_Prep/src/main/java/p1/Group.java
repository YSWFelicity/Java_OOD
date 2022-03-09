package p1;

import java.util.Objects;

public abstract class Group extends TaxFiler {

  protected Integer numberOfDependants;
  protected Integer numberOfMinorChildren;
  protected Double childcareExpenses;
  protected Double dependantCareExpenses;
  private static final Double HEALTH_SAVINGS = 0.65;
  private static final Double MAX_TAX = 17500.0;
  protected static final Double LAST_YEAR_EARNINGS_THRESHOLD_EDUCATION = 200000.0;
  protected static final Double EDUCATION_EXPENSES_THRESHOLD = 7500.0;
  protected static final Double EDUCATION_DEDUCTION = 2500.0;
  protected static final Double CHILDCARE_EARNINGS_THRESHOLD = 200000.0;
  protected static final Double CHILDCARE_EXPENSES_THRESHOLD = 5000.0;
  protected static final Double CHILDCARE_DEDUCTION = 1250.0;
  protected static final Double DEPENDANT_CARE_EARNINGS_THRESHOLD = 75000.0;
  protected static final Double DEPENDANT_TAX_CREDIT = 750.0;
  protected static final Double TAXABLE_INCOME_THRESHOLD = 90000.0;
  protected static final Double TAX_FACTOR_LOW = 0.145;
  protected static final Double TAX_FACTOR_HIGH = 0.19;

  public Group(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions,
      Integer numberOfDependants, Integer numberOfMinorChildren, Double childcareExpenses,
      Double dependantCareExpenses) {
    super(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        propertyTaxesPaid, studentLoanAndTuitionPaid, contributionToRetirementSavings,
        contributionToHealthSavings, charitableDonationsAndContributions);
    this.numberOfDependants = numberOfDependants;
    this.numberOfMinorChildren = numberOfMinorChildren;
    this.childcareExpenses = childcareExpenses;
    this.dependantCareExpenses = dependantCareExpenses;
  }

  @Override
  protected Double studentLoanDeduction() {
    if (this.lastYearsEarnings < LAST_YEAR_EARNINGS_THRESHOLD_EDUCATION &&
        this.studentLoanAndTuitionPaid > EDUCATION_EXPENSES_THRESHOLD) {
      return EDUCATION_DEDUCTION;
    }
    return 0.0;
  }

  @Override
  protected Double retirementAndHealthSavingsDeduction() {
    return (this.contributionToHealthSavings + this.contributionToRetirementSavings) * HEALTH_SAVINGS;
  }

  protected Double childcareDeduction() {
    if (this.lastYearsEarnings < CHILDCARE_EARNINGS_THRESHOLD &&
        this.childcareExpenses > CHILDCARE_EXPENSES_THRESHOLD) {
      return CHILDCARE_DEDUCTION;
    }
    return 0.0;
  }

  protected Double childAndDependentCareCredit() {
    if (this.lastYearsEarnings < DEPENDANT_CARE_EARNINGS_THRESHOLD) {
      return this.numberOfMinorChildren * DEPENDANT_TAX_CREDIT;
    }
    return 0.0;
  }

  @Override
  public Double calculateTaxableIncome() {
    Double curTotal = super.calculateTaxableIncome() - this.retirementAndHealthSavingsDeduction();
    if (curTotal > MAX_TAX) {
      return MAX_TAX;
    }
    return curTotal - this.studentLoanDeduction() - this.mortgageInterestAndPropertyDeduction() - this.childcareDeduction();
  }

  @Override
  public Double calculateTax() {
    //apply child credit
    if (this.calculateTaxableIncome() < TAXABLE_INCOME_THRESHOLD) {
      return this.calculateTaxableIncome() * TAX_FACTOR_LOW - this.childAndDependentCareCredit();
    }
      return this.calculateTaxableIncome() * TAX_FACTOR_HIGH - this.childAndDependentCareCredit();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(numberOfDependants, group.numberOfDependants)
        && Objects.equals(numberOfMinorChildren, group.numberOfMinorChildren)
        && Objects.equals(childcareExpenses, group.childcareExpenses)
        && Objects.equals(dependantCareExpenses, group.dependantCareExpenses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfDependants, numberOfMinorChildren,
        childcareExpenses, dependantCareExpenses);
  }

  @Override
  public String toString() {
    return super.toString() + "Group{" +
        "numberOfDependants=" + numberOfDependants +
        ", numberOfMinorChildren=" + numberOfMinorChildren +
        ", childcareExpenses=" + childcareExpenses +
        ", dependantCareExpenses=" + dependantCareExpenses +
        '}';
  }
}
