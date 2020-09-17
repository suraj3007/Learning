package main.java.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

    static Map<Character, Integer> map = new HashMap() {
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }
    };

    static int prec (char c) {

        switch (c) {
            case '+' :
            case '-' : return 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        // E.g: - ((A+B)*C-D)*E
        //((A*B)+(C*D)+E)

        String exp = "((A+B)*C-D)*E"; //ABC*+
        String result = infixToPostfixConversion(exp);
        System.out.println("Postfix Expression : " + result);
    }

    private static String infixToPostfixConversion(String exp) {
        Stack stack = new Stack();
        String res = "";
        char c;

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                res += c;
                continue;
            } else if (c == ')') {

                while (!stack.isEmpty() && (char) stack.peek() != '(') {
                    res += (char) stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && hasHigherPrecedence(c, (char) stack.peek())) {
                    res += (char) stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            res += (char) stack.pop();
        }

        return res;
    }

    private static boolean hasHigherPrecedence(char c, char top) {
        if (c != '(' && top != '(') {
            return map.get(top) >= map.get(c) ? true : false;
        }
        return false;
    }
}
