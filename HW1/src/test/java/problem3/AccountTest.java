package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;
    Amount amount;
    Amount amount2;
    Amount amount3;

    public static boolean accountEquals(Account accountA, Account accountB){
        if (accountA == accountB) return true;
        return accountA.getUserName() == accountB.getUserName() && accountA.getYearCreated() == accountB.getYearCreated()
                && accountA.getCountryCreated() == accountB.getCountryCreated()
                && AmountTest.amountEquals(accountA.getAmount(),accountB.getAmount());
    }

    @BeforeEach
    void setUp() {
        amount = new Amount(100,50);
        amount2 = new Amount(20,10);
        amount3 = new Amount(250000, 25);
        account = new Account(amount, "abc", "2021", "US");
    }

    @Test
    void getAmount() {
        AmountTest.amountEquals(new Amount(100,50), account.getAmount());
    }

    @Test
    void getUserName() {
        assertEquals("abc", account.getUserName());
    }

    @Test
    void getYearCreated() {
        assertEquals("2021", account.getYearCreated());
    }

    @Test
    void getCountryCreated() {
        assertEquals("US", account.getCountryCreated());
    }

    @Test
    void deposit() {
        Account updatedAccount = account.deposit(amount2);
        AccountTest.accountEquals(new Account(new Amount(120,60),"abc","2021", "US"),updatedAccount);
    }

    @Test
    void withdrawal() {
        Account updatedAccount = account.withdrawal(amount2);
        AccountTest.accountEquals(new Account(new Amount(80,40),"abc","2021", "US"),updatedAccount);
    }

    @Test
    void convert() {
        assertEquals(account.convert(amount3), 6.250006249999999);
    }
}