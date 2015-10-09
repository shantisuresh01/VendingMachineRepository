import exceptions.InvalidCoinException;

public class VendingMachine {
    // all the cash in the vending machine from all transactions
    static double allCash;
 
    // current transaction-related entities
    private double currentTotal;

    private final CoinInputter ci;
    private final CoinValidator cv;
    private final CoinOutputter co;
    private final DisplayManager dm;

    public VendingMachine(CoinInputter ci, CoinValidator cv, CoinOutputter co, DisplayManager dm){
        this.ci = ci;
        this.cv = cv;
        this.co = co;
        this.dm = dm;
    }
    public void acceptCoin(final Coin coin) throws InvalidCoinException {
        double value = cv.validateCoin(coin);
        addToCurrentTotal(value);
        dm.updateDisplayMsg("Paid: " + getCurrentTotal() );
         
    }

    public double getCurrentTotal() {
        return currentTotal;
    }
    public void addToCurrentTotal(double value) {
        currentTotal += value;
    }
    public Coin returnCoin(Coin aCoin) {
        return(this.co.outputCoin(aCoin));
    }
    public double evaluateCoin(Coin aCoin) {
        return(this.cv.validateCoin(aCoin));
    }
}
