package main.java.com.pluralsight.flyweight;

import java.util.HashMap;
import java.util.Map;

//Catalog acts as a factory and cache for Item flyweight objects
public class Catalog {

    Map<String, Item> items = new HashMap<>();

    //factory method
    public Item lookup(String itemName) {
        if (!items.containsKey(itemName)){
            items.put(itemName, new Item(itemName));    //This object is created only when new item comes to place an order -> Memory utilisation
        }
        return items.get(itemName);
    }

    public int totalItemsMade() {
        return items.size();
    }
}
