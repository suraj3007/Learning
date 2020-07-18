package main.java.com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> p1 = integer -> integer % 2 == 0;
        System.out.println(p1.test(10));
        System.out.println(p1.test(25));
    }
}

class Student1 {
    String name;
    int marks;

    public Student1(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}


class FunctionDemo {
    public static void main(String[] args) {

        Function<Student1, String> f = s -> {
            int marks = s.marks;
            String grade;

            grade = (marks > 75) ? "Distinction" : (marks >= 60) ? "First class" : (marks >= 35) ? "Second Class" : "Fail";
            return grade;
        };

        Student1[] s = {
                new Student1("Akash", 90),
                new Student1("Tushar", 70),
                new Student1("Abhi", 55),
                new Student1("Ranjeet", 30)
        };

        Predicate<Student1> p1 = s1 -> s1.marks >= 60;

        Consumer<Student1> c = s1 -> System.out.println(s1.name + "..." + s1.marks + "..." + f.apply(s1));

        for (Student1 s1 : s) {

            if (p1.test(s1)) {
                c.accept(s1);
            }
        }
    }
}

class Demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(75);
        marks.add(35);
        marks.add(55);
        marks.add(49);
        marks.add(86);
        marks.add(13);

        List<Integer> sorted = marks.stream().sorted().collect(Collectors.toList());
        List<Integer> sorted2 = marks.stream().sorted((a,b) -> (a < b) ? 1 : (a > b) ? -1 : 0).collect(Collectors.toList());
        System.out.println(sorted);
        System.out.println(sorted2);
    }
}

class GFG {

    // Driver code
    public static void main(String[] args)
    {

        // Creating a List of Strings
        List<String> list = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");
        System.out.println(list.stream());

        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::println);

    }
}


