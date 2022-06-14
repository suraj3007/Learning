package main.java.learning;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacter {
    public static void main(String[] args) {
        String s = "Avani Suraj Singh";
        char[] ch = s.toCharArray();

        Integer count;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : ch) {
            count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        System.out.print("Repeating characters are : ");

        for (Map.Entry<Character, Integer> m : entrySet) {
            if (m.getValue() > 1 && m.getKey() != 32) {
                System.out.print(m.getKey().toString().toLowerCase() + " ");
            }
        }
    }
}
