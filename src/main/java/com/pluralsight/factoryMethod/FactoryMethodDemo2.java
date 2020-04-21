package main.java.com.pluralsight.factoryMethod;

/**
 * We are creating a website which have list of pages by using factory method
 * A simple test client program that uses above factory design pattern implementation.
 */

public class FactoryMethodDemo2 {

    public static void main(String[] args) {
        Website site = WebsiteFactory.getWebsite("blog");
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite("shop");
        System.out.println(site.getPages());
    }
}
