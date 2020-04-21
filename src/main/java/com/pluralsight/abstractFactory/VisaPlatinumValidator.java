package main.java.com.pluralsight.abstractFactory;

public class VisaPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard card) {
        return false;
    }
}
