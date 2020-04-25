package main.java.com.pluralsight.composite;

import java.util.ArrayList;
import java.util.List;


/**
 * Composite Pattern:
 */
public abstract class MenuComponent {

    String name, url;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public abstract String toString();

    String print(MenuComponent component) {             //Adding the main menu. i.e.: Main:/main
        StringBuilder builder = new StringBuilder(name);
        builder.append(":");
        builder.append(url);
        builder.append("\n");
        return builder.toString();
    }
}
