package main.java.learning1;

public class PairOfNumbersEqualToSum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findPair(arr, 9);
    }

    private static void findPair(int[] arr, int sum) {

        int low = arr[0], high = arr.length - 1;

        while (low < high) {

            if (arr[low] + arr[high] > sum)
                high--;
            else if (arr[low] + arr[high] < sum)
                low++;
            else {
                System.out.println("Pair is : " + arr[low] + " & " + arr[high]);
//                break;
                high--;
                low++;
            }
        }
    }
}


class Parent {
    public void m1() {
        System.out.println("PArent");
    }
}

class Child extends Parent {
    public void m1() {
        System.out.println("Child");
    }
}

class TestIn {
    public static void main(String[] args) {
        Parent p = new Parent();

        Child c = new Child();

        Parent p1 = new Child();

    }
}