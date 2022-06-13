package main.java.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesesUsingStack {

    static Map<Character, Character> map = new HashMap(){
        {
            put('}','{');
            put(')','(');
            put(']','[');
        }
    };

    private static boolean isBalancedParantheses(String exp) {
        Stack stack = new Stack();
        char[] ch = exp.toCharArray();
        for (int i = 0; i < exp.length(); i++) {
            if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
                stack.push(ch[i]);
                continue;
            } else if (stack.isEmpty() || !(map.get(ch[i]) == stack.peek())) {
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String exp = "{([([{]})])}";
        String exp = "{([([{]})])}";
        System.out.println(isBalancedParantheses(exp) ?
                "Parantheses are balanced" : "Parantheses are not balanced");
    }
}
