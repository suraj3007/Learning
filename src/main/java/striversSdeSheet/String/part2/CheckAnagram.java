package main.java.striversSdeSheet.String.part2;

public class CheckAnagram {

    public boolean isAnagram(String s, String t) {
        //Negative scenario
        if (s.length() != t.length()) return false;

        int total = 0;
        char[] s1 = s.toCharArray();
        for (char c : s1) {
            total += (c * c) % 26;
        }

        char[] t1 = t.toCharArray();
        for (char c : t1) {
            total -= (c * c) % 26;
        }

        return total == 0;
    }

    public static void main(String[] args) {

    }
}
