package exceptions;

public class InvalidCoinException extends Exception{
        
        public InvalidCoinException(final String message){
                super(message);
        }

        public InvalidCoinException(){
                this("Invalid Coin!, Insert nickels, dimes or quarters");
        }
}

