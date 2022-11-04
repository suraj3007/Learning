package main.java.striversSdeSheet.String.part1;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return res.toString();
        }

        int index = 0;
        for (char c : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return res.toString();
                }
            }
            res.append(c);
            index++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(input));
    }
}
