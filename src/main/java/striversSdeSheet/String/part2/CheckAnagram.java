package main.java.striversSdeSheet.String.part2;

public class CheckAnagram {

    public boolean isAnagram(String s, String t) {
        //Negative scenario
        if (s.length() != t.length()) return false;

        int total = 0;
        for (char c : s.toCharArray()) {
            total += (c * c) % 26;
        }

        for (char c : t.toCharArray()) {
            total -= (c * c) % 26;
        }

        return total == 0;
    }

    public static void main(String[] args) {

    }
}
