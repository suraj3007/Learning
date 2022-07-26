package main.java.striversSdeSheet.StackAndQueue.part2;
import java.util.Stack;
public class CelebrityProblem {

    static class Runner {
        public static boolean knows(int a, int b) {
            //Implemented as helper function.
            //It will return true if a knows b otherwise return false
            return false;
        }
    }

    public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int id1 = stack.pop();
            int id2 = stack.pop();

            if (Runner.knows(id1, id2)) {
                stack.push(id2);
            } else {
                stack.push(id1);
            }
        }

        int celebrityId = stack.pop();

        for (int i = 0; i < n; i++) {
            if (celebrityId != i && (Runner.knows(celebrityId, i) || !Runner.knows(i, celebrityId))) {
                return -1;
            }
        }

        return celebrityId;
    }

    public static void main(String[] args) {
    }
}
