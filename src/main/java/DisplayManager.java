public class DisplayManager {

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
}
