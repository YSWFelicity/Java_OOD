package p1;

public class SelfEmployeed extends Individual{

  private Double homeOfficeExpenses;
  private Double healthInsuranceExpenses;
  private Double travelAndVehicleExpenses;
  private Double businessAndInsuranceExpenses;


  public SelfEmployeed(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions) {
    super(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        propertyTaxesPaid, studentLoanAndTuitionPaid, contributionToRetirementSavings,
        contributionToHealthSavings, charitableDonationsAndContributions);
  }
}
