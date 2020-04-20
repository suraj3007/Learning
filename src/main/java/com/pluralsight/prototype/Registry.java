package main.java.com.pluralsight.prototype;


import java.util.HashMap;

public class Registry {

    private HashMap<String, Item> items = new HashMap<>();


    /**
     * This constructor will load the data for different categories.
     * This registry stores the object created by new Keyword.
     */
    public Registry() {
        loadItems();
    }


    /**
     * This will take the object stored in registry and creates the clone of that object
     * @param type
     * @return
     */
    public Item createItems(String type){
        Item item = null;
        try {
            item = (Item)(items.get(type)).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }

    private void loadItems() {

        //Only one time new keyword is used for each category
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2.4 hours");
        items.put("Movie", movie);

        Book book = new Book();
        book.setTitle("Basic Book");
        book.setPrice(19.67);
        book.setNumberOfPages(100);
        items.put("Books", book);
    }
}
