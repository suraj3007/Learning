package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    HashMap<Integer, Integer> vals;   //cache K and V
    HashMap<Integer, Integer> counts; //K and counters (frequency)
    HashMap<Integer, LinkedHashSet<Integer>> lists; //Counter and item list
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        //If key is not available at all, return -1.
        if (!vals.containsKey(key)) {
            return -1;
        }

        // Get the count from counts map
        int count = counts.get(key);
        // increase the counter
        counts.put(key, count + 1);
        // remove the element from the counter to linkedhashset
        lists.get(count).remove(key);

        // when current min does not have any data, next one would be the min
        if (count == min && lists.get(count).isEmpty()) {
            min++;
        }

        //If next counter value is not available in map, then we should create one with empty hashSet and then access it.
        //Otherwise, we will get exception.
        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }

        //Add the key in corresponding frequency list
        lists.get(count + 1).add(key);

        //finally return the value
        return vals.get(key);
    }

    public void put(int key, int value) {
        //Check for negative scenario
        if (cap <= 0) {
            return;
        }
        //If key does exist, we are returning from here
        if (vals.containsKey(key)) {
            vals.put(key, value);
            //To mark it as accessed
            get(key);
            return;
        }

        //If map is full then find the least frequency used element and in case of tie find LRU element
        if (vals.size() >= cap) {
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }

        //If the key is new, insert the value and current min should be 1 of course
        vals.put(key, value);
        min = 1;
        counts.put(key, 1);
        lists.get(1).add(key);
    }

    public static void main(String[] args) {

    }
}
