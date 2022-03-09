package p1;

import java.util.Objects;

public class BusinessTaxFilers extends TaxFiler {

  private Integer numberOfEmployees;
  private Double employeeBenefitsExpenses;
  private Double businessExpenses;
  private static final Double TAX_CREDIT = 2500.0;
  private static final Double FINAL = 0.15;

  public BusinessTaxFilers(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions) {
    super(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        propertyTaxesPaid, studentLoanAndTuitionPaid, contributionToRetirementSavings,
        contributionToHealthSavings, charitableDonationsAndContributions);
    this.numberOfEmployees = numberOfEmployees;
    this.employeeBenefitsExpenses = employeeBenefitsExpenses;
    this.businessExpenses = businessExpenses;
  }

  private Double getTaxCredit() {
    return TAX_CREDIT * this.numberOfEmployees;
  }

  @Override
  protected Double calculateTaxableIncome() {
    return super.calculateTaxableIncome() - this.businessExpenses -
        this.employeeBenefitsExpenses - this.getTaxCredit();
  }

  @Override
  public Double calculateTax() {
    return this.calculateTaxableIncome() * FINAL;
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
    BusinessTaxFilers that = (BusinessTaxFilers) o;
    return Objects.equals(numberOfEmployees, that.numberOfEmployees)
        && Objects.equals(employeeBenefitsExpenses, that.employeeBenefitsExpenses)
        && Objects.equals(businessExpenses, that.businessExpenses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfEmployees, employeeBenefitsExpenses,
        businessExpenses);
  }

  @Override
  public String toString() {
    return super.toString() + "Business" +
        "numberOfEmployees=" + numberOfEmployees +
        ", employeeBenefitsExpenses=" + employeeBenefitsExpenses +
        ", businessExpenses=" + businessExpenses +
        '}';
  }
}
