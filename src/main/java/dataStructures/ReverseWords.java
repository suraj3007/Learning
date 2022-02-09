package main.java.dataStructures;

import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        String value = "I love watching cricket";
        System.out.println(value.toCharArray());
        String result = reverse(value);
        System.out.println(result);
    }

    private static String reverse(String value) {
        StringBuilder builder = new StringBuilder();
        String[] res = value.split(" ");
        Stack stack = new Stack();
        for (String s : res) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        return builder.toString();
    }
}


class ReverseWords2 {
    public static void main(String[] args) {
        String value = "I love watching cricket";
        System.out.println(value.toCharArray());
        String result = reverse(value);
        System.out.println(result);
    }

    private static String reverse(String str) {
        String[] values = str.split(" ");
//        StringBuilder builder = new StringBuilder();
        String res = "";
        for (int i = values.length - 1; i >= 0; i--) {
//            builder.append(values[i]).append(" ");
            res += values[i] + " ";
        }

//        return builder.toString();
        return res;
    }
}
