// import exceptions.InvalidCoinException;

public class CoinValidator {

    enum ValidCoin {
        QUARTER(5.67, 0.955, 0.25),
        DIME(2.25, 0.705, 0.10), 
        NICKEL(5.00, 0.835, 0.05); 
    
        ValidCoin(Double weight, Double diameter, Double value) { // constructor
             this.weight = weight;
             this.diameter = diameter;
             this.value = value;
        }
        private double weight;      // an instance variable
        private double diameter;      // an instance variable
        private double value;      // an instance variable

        public double getWeight() {
             return weight;
        }
        public double getDiameter() {
             return diameter;
        }
        public double getValue() {
             return value;
        }
    }
    public  static double getValidCoinValue(Coin aCoin) {
 
        double aCoinValue = -1.0;
        for (ValidCoin c : ValidCoin.values()) {
            if((c.getWeight() == aCoin.getWeight()) && (c.getDiameter() == aCoin.getDiameter())) { 
                aCoinValue = c.getValue();
            }
        }
        return(aCoinValue); 
    }


//    public static double validateCoin(Coin aCoin) throws InvalidCoinException { 
    public static double validateCoin(Coin aCoin) { 
        double aCoinValue = 0.0;
        aCoinValue = getValidCoinValue(aCoin);
        if(aCoinValue == -1) {
            throw new RuntimeException(); 
        }               
        else
            return(aCoinValue);
    }

    public static void main(String[] args) {

        Coin penny = new Coin(2.5, 0.75);
        double value;
        value = validateCoin(penny);
/*
        try{
            value = validateCoin(penny);
        }
        catch (InvalidCoinException e) {
            System.err.println("InvalidCoinException thrown - weight and diamater are: " + penny.getWeight() + penny.getDiameter());
            value = -1.0;
        }
*/
        System.out.println("Obtained for penny: " + value);
    }
}
