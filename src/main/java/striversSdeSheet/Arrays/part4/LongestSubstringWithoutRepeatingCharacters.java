package main.java.striversSdeSheet.Arrays.part4;

import java.util.HashMap;
import java.util.Map;

/**
 * Keep adding character in a map with its index value till we get non-repeating character
 * by incrementing right pointer & calculate maxLength.
 * If we get any repeated character, move left pointer to right + 1 to skip all iterations in between.
 * Also, repeated character should be within range of considered sequence.
 * For eg: - tmmxuzt - last char 't' is out of range when 't' first occurred at index 0
 * for the longest sequence mxuzt. For this longest sequence, left will be at index 2 & right will be at 6.
 * However, first 't' found at index 0 which is out of range of 2 & 6.
 * If its not within sequence range then keep it as it is.
 * Handled by: - -> Math.max(map.get(s.charAt(right)) + 1, left) -> Math.max(1, 2) -> 2 as per above eg.
 * And update the index of repeated character index as per last occurrence.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(s.charAt(right), right++);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmxuzt"));
    }
}
