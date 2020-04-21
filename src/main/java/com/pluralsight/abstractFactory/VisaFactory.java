package main.java.com.pluralsight.abstractFactory;

/**
 * Factory method for Visa credit card.
 * Now that we have super classes and sub-classes ready, we can write our factory class
 * Here, it will create an object for various of credit card type and validator.
 */
public class VisaFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type) {
            case GOLD: {
                return new VisaGoldCreditCard();
            }
            case PLATINUM: {
                return new VisaPlatinumCreditCard();
            }
            default: return null;
        }
    }

    @Override
    public Validator getValidator(CardType type) {
        switch (type) {
            case GOLD: {
                return new VisaGoldValidator();
            }
            case PLATINUM: {
                return new VisaPlatinumValidator();
            }
            default: return null;
        }
    }
}
