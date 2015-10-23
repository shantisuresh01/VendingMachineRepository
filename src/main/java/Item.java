public enum Item {
        COLA(1.00),
        CHIPS(0.50),
        CANDY(0.65);

        Item(double price) {
            this.price = price;
        }
        private final double price;
        public double getPrice() {
            return this.price;
        }
}

