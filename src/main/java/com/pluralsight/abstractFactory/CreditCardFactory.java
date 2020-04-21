package main.java.com.pluralsight.abstractFactory;

/**
 * AbstractFactory : It contains group of factories
 * It will only provide the factory based on some criteria.
 * In this eg. it will return type of card factory based on credit score
 */
public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore) {
        if (creditScore > 650) {
            return new AmexFactory();   //American express credit card factory
        } else {
            return new VisaFactory();   //Visa credit card factory
        }
    }

    public abstract CreditCard getCreditCard(CardType type);    //Contract : Factory will have to provide the implementation

    public abstract Validator getValidator(CardType type);      //Contract : Factory will have to provide the implementation

}
