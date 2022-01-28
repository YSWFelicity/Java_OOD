package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    Amount amount1;
    Amount amount2;
    Amount amount3;

    public static boolean amountEquals(Amount amountA, Amount amountB){
        if (amountA == amountB) return true;
        return amountA.getDollar() == amountB.getDollar() && amountA.getCent() == amountB.getCent();
    }

    @BeforeEach
    void setUp() throws Exception {
        amount1 = new Amount(100, 55);
        amount2 = new Amount(20, 70);
        amount3 = new Amount(250000, 25);
    }

    @Test
    void getDollar() {
        assertEquals(100, amount1.getDollar());
    }

    @Test
    void getCent() {
        assertEquals(55, amount1.getCent());
    }

    @Test
    void add() {
        Amount amountUpdated = Amount.add(amount1, amount2);
        amountEquals(new Amount(121,25), amountUpdated);
    }

    @Test
    void minus() {
        Amount amountUpdated = Amount.add(amount1, amount2);
        amountEquals(new Amount(79,85), amountUpdated);
        Amount amountNull = Amount.minus(amount2, amount1);
        amountEquals(null, amountNull);
    }

    @Test
    void times() {
        assertEquals(amount3.times(), 6.250006249999999);
    }
}