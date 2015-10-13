public class CoinInputter {

        private Coin aCoin;
        private enum CoinState {HASCOIN, HASNOCOIN};
        private CoinState state;

        public CoinInputter(Coin aCoin) {
            this.aCoin = aCoin;
        }
        public CoinInputter() {
            this.state = CoinState.HASNOCOIN;
        }

        public void setCoin(Coin aCoin) {
             this.state = CoinState.HASCOIN;
             this.aCoin = aCoin;
        }
        public Coin getCoin() {
            if (this.state == CoinState.HASCOIN) 
                return aCoin;
            else
                return (Coin)(null);
        }
}
