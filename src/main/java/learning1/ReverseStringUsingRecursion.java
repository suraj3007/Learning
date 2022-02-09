package main.java.learning1;

public class ReverseStringUsingRecursion {

    public static void main(String[] args) {
        String s = "surajsingh";
        char[] ch = s.toCharArray();
        int low = 0, high = s.length() - 1;

        ch = reverseString(ch, low, high);
        s = new String(ch);
        System.out.println(s);
    }

    private static char[] reverseString (char[] arr, int low, int high) {

        if (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
            reverseString(arr, low, high);
        }

        return arr;
    }
}
