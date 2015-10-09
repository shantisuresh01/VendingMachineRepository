import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// import exceptions.InvalidCoinException;

public class VendingMachineTest {

    // New Junit 4.7 @Rule annotation
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private CoinInputter ci;
    private CoinValidator cv;
    private CoinOutputter co;
    private DisplayManager dm;
    private Coin penny;
    private Coin quarter;
    private Coin aCoin;
    private VendingMachine vm;

    @Before
    public void setUp() {
        cv = new CoinValidator();
        penny = new Coin(2.5, 0.75);
        quarter = new Coin(5.67, 0.955);
        ci = new CoinInputter(penny);
        co = new CoinOutputter();
        dm = new DisplayManager();
        vm = new VendingMachine(ci,cv, co, dm);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void CoinInputterReturnsACoin() {
        ci.setCoin(quarter);
        aCoin = ci.getCoin();
        assertThat(aCoin, is(Coin.class));
    }
/*
    @Test(expected=InvalidCoinException.class)
    public void CoinValidatorRejectsPennies() throws InvalidCoinException {
            cv.validateCoin(penny);
        }
*/
    @Test(expected=RuntimeException.class)
    public void CoinValidatorRejectsPennies() {
            cv.validateCoin(penny);
        }
   
    // Same test as before - just using the newer syntax
    @Test
    public void whenInvalidCoinsAreInsertedCoinValidatorThrowsInvalidCoinException() {
//        exception.expect(InvalidCoinException.class);
        exception.expect(RuntimeException.class);
        cv.validateCoin(penny);
    }
    @Test
    public void vendingMachineReturnsACoin() {
        // System.err.print("hello again");
        // assertEquals("hello again", errContent.toString());
        // assertThat(result, containsString("Hello again"));
        assertEquals(penny, vm.returnCoin(penny));
    }
    @Test
    public void vendingMachineCalculatesCoinValue() {
        assertEquals(0.25, vm.evaluateCoin(quarter), 0.00); 
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}

