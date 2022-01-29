package problem3;

/**
 * Account is a simple object that has amount, username, the year is created and the country is created.
 * */
public class Account {
    private Amount amount;
    private String userName;
    private String yearCreated;
    private String countryCreated;

    /**
     * Constructor that creates a new Account object with the specified amount, username, the year is created and the country is created.
     * @param amount - amount of the new Amount object.
     * @param userName - username of the new Amount object.
     * @param yearCreated - the year that is created of the new Amount object.
     * @param countryCreated - the country that is created of the new Amount object.
     * */
    public Account(Amount amount, String userName, String yearCreated, String countryCreated) {
        this.amount = amount;
        this.userName = userName;
        this.yearCreated = yearCreated;
        this.countryCreated = countryCreated;
    }

    /**
     * Returns the amount of the Account
     * @return the amount of the Account
     * */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Returns the username of the Account
     * @return the username of the Account
     * */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the year that is created of the Account
     * @return the year that is created of the Account
     * */
    public String getYearCreated() {
        return yearCreated;
    }

    /**
     * Returns the country that is created of the Account
     * @return the country that is created of the Account
     * */
    public String getCountryCreated() {
        return countryCreated;
    }

    /**
     * Deposit amount of money into account.
     * @param amount - amount of the deposit.
     * @return the new Account object with the updated balance.
     * */
    public Account deposit(Amount amount) {
        Amount amountUpdated = amount.add(this.amount, amount);
        return new Account(amountUpdated, this.userName, this.yearCreated, this.countryCreated);
    }

    /**
     * Withdrawal amount of money from account.
     * @param amount - amount of the withdrawal.
     * @return the new Account object with the updated balance.
     * */
    public Account withdrawal(Amount amount) {
        Amount amountUpdated = amount.minus(this.amount, amount);
        return new Account(amountUpdated, this.userName, this.yearCreated, this.countryCreated);
    }

    /**
     * Convert amount of money from account.
     * @param amount - amount of the conversion.
     * @return the amount with the conversion balance.
     * */
    public Double convert(Amount amount) {
        return amount.times();
    }
}
