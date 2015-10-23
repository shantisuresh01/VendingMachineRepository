public class DisplayManager {

    private static String insertCoins = "INSERT COINS";
    private static String thankYou = "THANK YOU";
    private static String inserted = "INSERTED";
    private static boolean wasDisplayRead = false;
    private String displayMsg;
    public DisplayManager() {
        this.displayMsg="INSERT COINS";
    }
    public void updateDisplayMsg(String msg) {
        this.displayMsg = msg;
    }
    public void initialize() {
        this.announceInsertCoins();
        this.wasDisplayRead = false;
    }
    public String getDisplayMsg() {
    // if the display has been read initialize and return insert coins.
        if (this.wasDisplayRead) {
            this.initialize();
        }
        else {
            this.wasDisplayRead = true;
        }
        return this.displayMsg;
    }
    public void announceInsertCoins() {
        this.updateDisplayMsg(this.insertCoins);
    }
    public void announceThankYou() {
        this.updateDisplayMsg(this.thankYou);
    }

}
