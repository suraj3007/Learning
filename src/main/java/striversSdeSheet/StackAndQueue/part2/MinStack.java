package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.Stack;

public class MinStack {

    Stack<Long> stack;
    Long mini;

    public MinStack() {
        stack = new Stack<>();
        //Converting to long because range is given as 2 ^ 31 and also we are multiplying by 2.
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = (long) val;
        if (stack.isEmpty()) {
            stack.push(value);
            mini = value;
            return;
        }

        //If val is less then, push the modified value as 2 * val - min and assign actual value as min
        if (mini > value) {
            stack.push((2 * value) - mini);
            mini = value;
        } else {
            //Normal push if value > mini
            stack.push(value);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Long val = stack.pop();
            //If val is smaller it means we are popping out modified value.
            //So, we have to get the prev mini which can be calculated as 2 * mini - val
            if (val < mini) {
                mini = (2 * mini - val);
            }
        }
    }

    public int top() {
        Long top = stack.peek();
        //If top is smaller it means we have modified value at the top which is not actual element.
        //Hence, return mini
        if (top < mini) {
            return mini.intValue();
        }
        return top.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
