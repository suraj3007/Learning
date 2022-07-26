package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {

    Stack<Integer> stack;
    ArrayList<Integer> list;

    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int currentIndex = list.size() - 1;

        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }

        if(stack.isEmpty()) {
            stack.push(currentIndex);
            return list.size();
        } else {
            int top = stack.peek();
            stack.push(currentIndex);
            return currentIndex - top;
        }
    }

    public static void main(String[] args) {
        StockSpanner st = new StockSpanner();
        System.out.println(st.next(100));
        System.out.println(st.next(80));
        System.out.println(st.next(60));
        System.out.println(st.next(70));
        System.out.println(st.next(60));
        System.out.println(st.next(75));
        System.out.println(st.next(85));
    }
}
