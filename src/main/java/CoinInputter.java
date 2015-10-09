public class CoinInputter {

        private Coin aCoin;

        public CoinInputter(Coin aCoin) {
            this.aCoin = aCoin;
        }

        public void setCoin(Coin aCoin) {
             this.aCoin = aCoin;
        }
        public Coin getCoin() {
             return aCoin;
        }
}
