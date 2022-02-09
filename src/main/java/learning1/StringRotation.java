package main.java.learning1;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "AACD";
        String s2 = "ACDA";

        System.out.println(isRotation(s1, s2) ?
        "Strings are rotation of each other" :
        "Strings are not rotation of each other");
    }

    private static boolean isRotation(String s1, String s2) {
//        (s1 + s1).contains(s2);
        return ((s1.length() == s2.length()) && (s1 + s1).indexOf(s2) != -1);
    }
}
