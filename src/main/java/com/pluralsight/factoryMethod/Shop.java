package main.java.com.pluralsight.factoryMethod;

//Subclass : Shop website which contains these set of pages. Here, subclasses will decide which class to instantiate
public class Shop extends Website{

    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
