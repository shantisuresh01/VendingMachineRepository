public class Coin {

    private double weight;
    private double diameter;
    Coin(final double weight, final double diameter) {
        this.weight = weight;
        this.diameter = diameter;
    }
    public double getWeight() {
        return this.weight;
    }
    public double getDiameter() {
        return this.diameter;
    }
    @Override // Force the compiler to check that this is truly an override
    public boolean equals(Object other){
        if ((other instanceof Coin) && (((Coin)other).getWeight() == this.weight) && (((Coin)other).getDiameter() == this.diameter)) {
            return(true);
        }
        else {
            return(false);
        }
    }

}
