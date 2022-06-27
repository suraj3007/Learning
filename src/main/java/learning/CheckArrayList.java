package main.java.learning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Iterator<Integer> itr = list.iterator();
        //list.add(50);   //throws CME
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}

class DateCheck {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().plusYears(10));
        System.out.println(LocalDate.of(LocalDate.now().plusYears(11).getYear(), 01, 01));
    }
}
