package problem3;

public class Account {
    private Amount amount;
    private String userName;
    private String yearCreated;
    private String countryCreated;

    public Account(Amount amount, String userName, String yearCreated, String countryCreated) {
        this.amount = amount;
        this.userName = userName;
        this.yearCreated = yearCreated;
        this.countryCreated = countryCreated;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getUserName() {
        return userName;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public String getCountryCreated() {
        return countryCreated;
    }

    public Account deposit(Amount amount) {
        Amount amountUpdated = amount.add(this.amount, amount);
        return new Account(amountUpdated, this.userName, this.yearCreated, this.countryCreated);
    }

    public Account withdrawal(Amount amount) {
        Amount amountUpdated = amount.minus(this.amount, amount);
        return new Account(amountUpdated, this.userName, this.yearCreated, this.countryCreated);
    }

    public Double convert(Amount amount) {
        return amount.times();
    }
}
