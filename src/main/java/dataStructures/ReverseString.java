package main.java.dataStructures;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String s = "Suraj";
        System.out.println("Before reversal of string: " + s);
        char[] c = s.toCharArray();
        char temp;
        int j = s.length() - 1, i = 0;

        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        s = new String(c);
        System.out.println("After reversal of string: " + s);
    }
}

class ReverseStringUsingStack {

    public static void main(String[] args) {
        String s = "Roshni";
        System.out.println("Before reversal of string: " + s);
        StringBuilder builder = new StringBuilder();
        Stack stack = new Stack();
        //char [] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            //arr[i] = (char) stack.pop();
            builder.append(stack.pop());
        }
        //s = new String(arr);
        System.out.println("After reversal of string: " + builder);
    }
}

class SwapWithoutTemp {
    public static void main(String args[]) {
        String a = "Love";
        String b = "You";
        System.out.println("Before swap: " + a + " " + b);
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println("After : " + a + " " + b);
    }
}