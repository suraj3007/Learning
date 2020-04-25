package main.java.com.pluralsight.composite;

import java.util.Iterator;

public class Menu extends MenuComponent {


    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public MenuComponent add(MenuComponent menuComponent) {         //Method to add into menu
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    public MenuComponent remove(MenuComponent menuComponent) {      //Method to remove from menu
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();    //builder pattern
        builder.append(print(this));                    //To add the main menu i.e., Main:/main

        Iterator<MenuComponent> itr = menuComponents.iterator();    //Iterate over the menu components
        while (itr.hasNext()){
            MenuComponent menuComponent = itr.next();
            builder.append(menuComponent.toString());
        }

        return builder.toString();
    }
}
