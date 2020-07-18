package main.java.com.learning;

public class equalsDemo {
}

class Student {
    String name;
    int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Suraj", 101);
        Student s2 = new Student("Milan", 102);
        Student s3 = new Student("Suraj", 101);
        Student s4 = s1;
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals("Suraj"));
        System.out.println(s1.equals(null));

    }

    @Override
    public boolean equals(Object obj) {
        //System.out.println(obj);    //main.java.com.learning.Student@2c7b84de
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (name.equals(s.name) && rollno == s.rollno) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}


class TestString {

    public static void main(String[] args) {

        String s1 = "suraj";
        String s2 = s1.toUpperCase();
        String s3 = s1.toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}

class Testf {

    public static void main(String[] args) {
        Float f = new Float("10.5f");
        System.out.println(f);

        Boolean b = new Boolean("FAlse");
        System.out.println(b);

        Integer i = Integer.valueOf("10");


        Character c = new Character('a');
        System.out.println(c.charValue());


    }
}

class TestBoxing {

    static Integer I = 10;

    public static void main(String[] args) {
        int i = I;
        m1(i);
    }

    private static void m1(Integer J){
        int m = J;
        System.out.println(m);

    }
}


