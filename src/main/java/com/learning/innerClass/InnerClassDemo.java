package main.java.com.learning.innerClass;

public class InnerClassDemo {

}

class Outer {

    class Inner {

        public void m1() {
            System.out.println("Imnner class method");
        }
    }

    public static void main(String[] args) {

        Outer.Inner i = new Outer().new Inner();
        i.m1();
        //new Outer().new Inner().m1();
    }
}


class MethodInnerClassDemo {

    public void m1() {
        class Inner {
            public void sum(int x, int y) {
                System.out.println("The sum is : " + (x + y));
            }
        }

        Inner i = new Inner();
        i.sum(10, 20);
        ;
        ;
        ;
        i.sum(100, 200);
        ;
        ;
        ;
        i.sum(1000, 2000);
    }

    public static void main(String[] args) {
        MethodInnerClassDemo t = new MethodInnerClassDemo();
        t.m1();
    }
}


class MethodInnerClassDemo2 {
    int x = 10;
    static int y = 20;

    public void m1() {
        class Inner {
            public void m2() {
                System.out.println(x);
                System.out.println(y);
            }
        }
        Inner i = new Inner();
        i.m2();
    }

    public static void main(String[] args) {
        MethodInnerClassDemo2 t = new MethodInnerClassDemo2();
        t.m1();
    }
}


class Popcorn{

    public void saltyTaste() {
        System.out.println("salty popcorn");
    }

    public void spicyTaste() {
        System.out.println("spicy popcorn");
    }
}

class AnonymousDemo {
    public static void main(String[] args) {
        Popcorn p1 = new Popcorn() {
            public void saltyTaste() {
                System.out.println("medium salty popcorn");
            }
        };
        p1.saltyTaste();    //medium salty popcorn
        p1.spicyTaste();    //spicy popcorn

        Popcorn p2 = new Popcorn();
        p2.saltyTaste();    //salty popcorn
    }
}