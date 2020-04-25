package main.java.com.pluralsight.composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeDemo {

    public static void main(String[] args) {
        Map<String, String> personAttributes = new HashMap<>();
        personAttributes.put("site_role", "person");
        personAttributes.put("access_role", "limited");
        System.out.println(personAttributes);

        Map<String, String> groupAttributes = new HashMap<>();
        groupAttributes.put("group_roles", "claims");
        System.out.println(groupAttributes);

        Map<String, String> secAttributes = new HashMap<>();
        secAttributes.putAll(personAttributes);
        secAttributes.putAll(groupAttributes);

        System.out.println(secAttributes);
    }
}
