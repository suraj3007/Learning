package main.java.com.pluralsight.abstractFactory;

public class VisaGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard card) {
        return false;
    }
}
