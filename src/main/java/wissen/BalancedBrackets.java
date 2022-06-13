package main.java.wissen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        // Write your code here
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        Stack stack = new Stack();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            } else if (!stack.empty() && bracketsMap.get(charArray[i]) == stack.peek()) {
                stack.pop();
            } else {
                return "NO";
            }
        }
        return stack.empty() ? "YES" : "NO";
    }

}
