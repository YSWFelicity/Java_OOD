package problem3;

/**
 * Amount class has dollar and cent.
 * */
public class Amount {
    private int dollar;
    private int cent;
    public static final int DOLLAR_TO_CENT = 100;
    public static final double Cent_TO_Bitcoins = 0.00000025;

    /**
     * Constructor that creates a new Amount object with the specified dollar and cent.
     * @param dollar - dollar of the new Amount object.
     * @param cent - cent of the new Amount object.
     * */
    public Amount(int dollar, int cent){
        this.dollar = dollar;
        this.cent = cent;
    }

    /**
     * Returns the dollar of the Amount
     * @return the dollar of the Amount
     * */
    public int getDollar() {
        return dollar;
    }

    /**
     * Returns the cent of the Amount
     * @return the cent of the Amount
     * */
    public int getCent() {
        return cent;
    }

    /**
     * Static method.
     * Returns the Amount object after adding another amount object.
     * @param amount1 - an amount object.
     * @param amount2 - another amount object.
     * @return the Amount object after adding another amount object.
     * */
    public static Amount add(Amount amount1, Amount amount2){
        int sumDollar = amount1.dollar + amount2.dollar;
        int sumCent = amount1.cent + amount2.cent;
        if(sumCent >= DOLLAR_TO_CENT){
            sumDollar += 1;
            sumCent -= DOLLAR_TO_CENT;
        }
        return new Amount(sumDollar,sumCent);
    }

    /**
     * Static method.
     * Returns the Amount object after deducting amount2 from amount1.
     * @param amount1 - an amount object.
     * @param amount2 - another amount object.
     * @return the Amount object after deducting amount2 from amount1. If amount2 is larger than amount1,
     * throw an exception.
     * */
    public static Amount minus(Amount amount1, Amount amount2){
        int resDollar = amount1.dollar - amount2.dollar;
        int resCent = amount1.cent - amount2.cent;
        if(resDollar * DOLLAR_TO_CENT + resCent >= 0){
            if(resCent < 0){
                resDollar -= 1;
                resCent += DOLLAR_TO_CENT;
            }
            return new Amount(resDollar,resCent);
        }else{
            return null;
        }

    }

    /**
     * Double method.
     * Returns the Amount object after converting dollar & cents to Bitcoins.
     * @return the Amount object after converting dollar & cents to Bitcoins. Convert dollar to cents first then
     * convert cents to bitcoins.
     * */
    public Double times() {
        double bitcoins = (this.dollar * DOLLAR_TO_CENT + this.cent) * Cent_TO_Bitcoins;
        return bitcoins;
    }
}
