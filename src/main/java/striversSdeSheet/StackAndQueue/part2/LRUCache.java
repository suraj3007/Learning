package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int size;
    private LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.size = capacity;
    }

    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        int value = map.get(key);
//        map.remove(key);
//        map.put(key, value);
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() == size) {
            int firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
