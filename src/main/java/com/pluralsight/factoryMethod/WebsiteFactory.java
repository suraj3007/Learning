package main.java.com.pluralsight.factoryMethod;

/**
 * Factory method for website.
 * Now that we have super classes and sub-classes ready, we can write our factory class
 * Here, it will create an object for the different type of website.
 */
public class WebsiteFactory {

    //This should be static. so that we can call WebsiteFactory.getWebsite("");
    //Notice that based on the input parameter, different subclass is created and returned.
    public static Website getWebsite(String siteType) {
        switch (siteType) {
            case "blog" : {
                return new Blog();
            }
            case "shop" : {
                return new Shop();
            }
            default: {
                return null;
            }
        }
    }
}


//A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate.
//In other words, subclasses are responsible to create the instance of the class

//The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class.
//This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.

//Factory Design Pattern Advantages: -
    // - Factory design pattern provides approach to code for interface rather than implementation.
    // - Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change shop class implementation because client program is unaware of this.
    // - Factory pattern provides abstraction between implementation and client classes through inheritance.