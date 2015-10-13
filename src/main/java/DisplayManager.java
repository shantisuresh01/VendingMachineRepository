public class DisplayManager {

    private String insertCoins = "INSERT COINS";
    private String thankYou = "THANK YOU";
    private String inserted = "INSERTED";
    private String displayMsg;
    public DisplayManager() {
        this.displayMsg="INSERT COINS";
    }
    public void updateDisplayMsg(String msg) {
        this.displayMsg = msg;
    }
    public String getDisplayMsg() {
        return this.displayMsg;
    }
    public void announceInsertCoins() {
        this.updateDisplayMsg(this.insertCoins);
    }
    public void announceThankYou() {
        this.updateDisplayMsg(this.thankYou);
    }

}
