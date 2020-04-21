package main.java.com.pluralsight.abstractFactory;

public class AmexPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard card) {
        return false;
    }
}
