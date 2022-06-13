package main.java.dataStructures.Recursion;

public class TwoApproachOfFindingSum {

    //Here, we are carrying result as parameter
    private static void parameterizedApproach(int n, int sum) {

        if (n == 0) {
            System.out.println("Sum using parameterized approach: " + sum);
            return;
        }
        parameterizedApproach(n - 1, sum + n);
    }

    //Here, we are returning the result of sub-problem. n + f(n - 1)
    private static int functionalApproach(int n) {
        if (n == 0) {
            return 0;
        }
        return n + functionalApproach(n - 1);
    }

    private static int findingFactorialUsingFunctionalApproach(int n) {
        if(n == 1) {
            return 1;
        }
        return n * findingFactorialUsingFunctionalApproach(n - 1);
    }

    private static void findingFactorialUsingParameterizedApproach(int n, int factorial) {
        if(n == 1) {
            System.out.println("Factorial using parameterized approach: " +factorial);
            return;
        }
        findingFactorialUsingParameterizedApproach(n - 1, factorial * n);
    }

    public static void main(String[] args) {
        //finding sum
        parameterizedApproach(5, 0);
        System.out.println("Sum using functional approach: " + functionalApproach(5));
        //Finding factorial
        System.out.println("Factorial using functional approach: " + findingFactorialUsingFunctionalApproach(5));
        findingFactorialUsingParameterizedApproach(5, 1);
    }
}
