package main.java.com.pluralsight.abstractFactory;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard card) {
        return false;
    }
}
