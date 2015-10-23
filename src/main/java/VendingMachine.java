import exceptions.InvalidCoinException;

public class VendingMachine {
    // all the cash in the vending machine from all transactions
    static double allCash;
    static boolean inAction;
    static enum State {DONE, ACCEPTING, FREE};
 
    // current transaction-related entities
    private double currentTotal;

    private final CoinInputter ci;
    private final CoinValidator cv;
    private final CoinOutputter co;
    private final DisplayManager dm;
    private State state = State.FREE;

    public VendingMachine(CoinInputter ci, CoinValidator cv, CoinOutputter co, DisplayManager dm){
        this.ci = ci;
        this.cv = cv;
        this.co = co;
        this.dm = dm;
    }
    public void insertCoin(final Coin coin) {
        double value = cv.validateCoin(coin);
        addToCurrentTotal(value);
        dm.updateDisplayMsg("Price: " + String.format("%.02f", getCurrentTotal()));
        this.setState(State.ACCEPTING);
         
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
        return(this.cv.validateCoin(this.ci.getCoin()));
    }
    public void initialize() {
        this.currentTotal = 0.0;
        this.setState(State.FREE);
        this.dm.announceInsertCoins();
    }
    public void setState(State state) {
        this.state = state;
    }
    public String getDisplayMessage() {
        switch(this.state) {
        case DONE:
            this.setState(State.FREE);
            break;
        case FREE:
            this.dm.announceInsertCoins();
            break;
        default:
            break;
        }
        return(this.dm.getDisplayMsg());
    }
    public Item selectProduct(Item item) {
        this.setState(State.DONE);
        dm.announceThankYou();
        return(Item.COLA);
    }
}
