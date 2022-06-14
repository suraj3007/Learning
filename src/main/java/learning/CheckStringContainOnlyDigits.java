package main.java.learning;

public class CheckStringContainOnlyDigits {

    public static void main(String[] args) {
        String s = "123456789098765432s";
        char[] arr = s.toCharArray();
        System.out.println(checkIfOnlyDigitPresent(arr) ?
                "String contain only digits" :
                "String does not only contain  digits");
    }

    private static boolean checkIfOnlyDigitPresent(char[] arr) {
        for (char c : arr) {
//            if (!Character.isDigit(c)) {
//                return false;
//            }
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}