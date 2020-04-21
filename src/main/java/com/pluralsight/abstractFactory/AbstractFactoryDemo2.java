package main.java.com.pluralsight.abstractFactory;

//Client side
public class AbstractFactoryDemo2 {

    public static void main(String[] args) {

        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard creditCard = abstractFactory.getCreditCard(CardType.PLATINUM);
        Validator validator = abstractFactory.getValidator(CardType.PLATINUM);

        System.out.println(creditCard.getClass());
        System.out.println(validator.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        CreditCard creditCard2 = abstractFactory.getCreditCard(CardType.GOLD);
        Validator validator2 = abstractFactory.getValidator(CardType.GOLD);

        System.out.println(creditCard2.getClass());
        System.out.println(validator2.getClass());
    }
}
