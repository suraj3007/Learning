package main.java.com.pluralsight.abstractFactory;

public abstract class CreditCard {

    protected int creditCardNumberLength;
    protected int csvNumber;

    public int getCreditCardNumberLength() {
        return creditCardNumberLength;
    }

    public void setCreditCardNumberLength(int creditCardNumberLength) {
        this.creditCardNumberLength = creditCardNumberLength;
    }

    public int getCsvNumber() {
        return csvNumber;
    }

    public void setCsvNumber(int csvNumber) {
        this.csvNumber = csvNumber;
    }
}
