package main.java.com.pluralsight.factoryMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Crux of factory pattern:
 * Super class : in factory design pattern can be an interface, abstract class or a normal java class
 * The stuff required for any website creation is pages. (subclasses)
 * Concrete classes i.e. Blog & Shop are responsible for providing the implementation
 */

public abstract class Website {

    //Pages
    List<Page> pages = new ArrayList<>();

    //No arg constructor will be called by Blog and Shop website
    public Website(){
        this.createWebsite();
    }

    public List<Page> getPages() {
        return pages;
    }

    public abstract void  createWebsite();
}
