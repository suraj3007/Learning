package main.java.learning;

public class NumberOfVowelsAndConsonants {

    public static void main(String[] args) {
        String s = "aeiouuioea";
        int vowelCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                vowelCount++;
            }
        }
        System.out.println("No. of Vowels in a String : " +vowelCount);
        System.out.println("No. of Consonants in a String : " +(s.length() - vowelCount));
    }
}
