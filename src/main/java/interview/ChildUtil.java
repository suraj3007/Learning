package main.java.interview;

import main.java.com.learning.ParentUtil;

import java.sql.Wrapper;
import java.util.HashSet;

public class ChildUtil extends ParentUtil{

    public static void main(String[] args) {
        new ChildUtil().callStuff();
    }

    void callStuff() {
        System.out.println(this.doStuff());
        ParentUtil p = new ParentUtil();
        //System.out.println(p.doStuff);
    }
}


class Pass {
    public static void main(String[] args) {
        Pass p = new Pass();
        p.start();
    }
    void start() {
        String s1 = "slip";
        String s2 = fix(s1);

        System.out.print(s1 + " " + s2);
    }

    String fix (String s1) {
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }
}


class Wrapped {
    private String s;

    public Wrapped(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        HashSet<Object> hs = new HashSet<>();

        Wrapped ws1 = new Wrapped("suraj");
        Wrapped ws2 = new Wrapped("suraj");

        String s1 = new String("suraj");
        String s2 = new String("suraj");

        hs.add(ws1);
        hs.add(ws2);
        hs.add(s1);
        hs.add(s2);

        System.out.println(hs.size());
    }
}

class CardBoard {
    Short story = 5;
    CardBoard go (CardBoard cb) {
        cb = null;
        return cb;
    }

    public static void main(String[] args) {
        CardBoard c1 = new CardBoard();
        CardBoard c2 = new CardBoard();
        CardBoard c3 = c1.go(c2);
        c1 = null;

        System.gc();

    }
}

class Abs {
    public static void main(String[] args) {
        ghi(2);
    }
    public static void ghi (int n) {
        if (n >= 0) {
            ghi (n - 1);
        }

        System.out.println(n);
    }
}

class Main
{
    // Function to calculate maximum difference between two elements in the
    // array such that smaller element appears before the larger element
    public static int diff(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
        int max_so_far = A[n-1];

        // traverse the array from right and keep track the maximum element
        for (int i = n - 2; i >= 0; i--)
        {
            // update max if current element is greater than the max element
            if (A[i] > max_so_far) {
                max_so_far = A[i];
            }
            // if the current element is less than the maximum element,
            // then update the difference if required
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
            }
        }

        // return difference
        return diff;
    }

    public static void main(String[] args)
    {
        int[] A = { 7, 1, 2, 5 };

        System.out.print("The maximum difference is " + diff(A));
    }
}