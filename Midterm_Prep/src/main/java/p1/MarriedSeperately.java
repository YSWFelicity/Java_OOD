package p1;

public class MarriedSeperately extends Group {

  public MarriedSeperately(String taxID, ContactInfo contactInfo, Double lastYearsEarnings,
      Double totalIncomeTaxPaid, Double mortgageInterestPaid, Double propertyTaxesPaid,
      Double studentLoanAndTuitionPaid, Double contributionToRetirementSavings,
      Double contributionToHealthSavings, Double charitableDonationsAndContributions,
      Integer numberOfDependants, Integer numberOfMinorChildren, Double childcareExpenses,
      Double dependantCareExpenses) {
    super(taxID, contactInfo, lastYearsEarnings, totalIncomeTaxPaid, mortgageInterestPaid,
        propertyTaxesPaid, studentLoanAndTuitionPaid, contributionToRetirementSavings,
        contributionToHealthSavings, charitableDonationsAndContributions, numberOfDependants,
        numberOfMinorChildren, childcareExpenses, dependantCareExpenses);
  }
}
