package main.java.com.pluralsight.abstractFactory;

/**
 * Factory method for American express credit card.
 * Now that we have super classes and sub-classes ready, we can write our factory class.
 * Here, it will create an object for various of credit card type and validator.
 */
public class AmexFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType type) {
        switch (type) {
            case GOLD: {
                return new AmexGoldCreditCard();
            }
            case PLATINUM: {
                return new AmexPlatinumCreditCard();
            }
            default: return null;
        }
    }

    @Override
    public Validator getValidator(CardType type) {
        switch (type) {
            case GOLD: {
                return new AmexGoldValidator();
            }
            case PLATINUM: {
                return new AmexPlatinumValidator();
            }
            default: return null;
        }
    }
}
