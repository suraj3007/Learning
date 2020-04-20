package main.java.learning;

/**
 * Use Case 1 : Automatic promotion in overloading
 */

public class OverloadingTest {

    public void msg(int i) {
        System.out.println("Int arg");
        System.out.println(i);
    }

    public void msg(float f) {
        System.out.println("Float arg");
        System.out.println(f);
    }

    public static void main(String[] args) {
        OverloadingTest test = new OverloadingTest();
        test.msg(10);
        test.msg(10.5F);
        test.msg('a');
        test.msg(10l);
        //test.msg(10.5);   CE: No suitable method found for msg(double)
    }
}

/**
 * Use Case 2: If Parent and child method gets matched,
 * then, preference goes to child method
 */

class OverlaodingEx2 {

    public void msg(Object o) {
        System.out.println("Object version");
        System.out.println(o);
    }

    public void msg(String s) {
        System.out.println("String version");
        System.out.println(s);
    }

    public static void main(String[] args) {
        OverlaodingEx2 test = new OverlaodingEx2();
        test.msg(new Object());
        test.msg("Suraj");
        test.msg(null);     //Preference will go to child class. I.e. String in this case.
    }
}

/**
 * UseCase 3 : When no relation b/w 2 classes & both method get matched then CE stating Ambiguous method
 */


class OverloadingEx3 {

    public void msg(String s) {
        System.out.println("String version");
        System.out.println(s);
    }

    public void msg(StringBuffer sb) {
        System.out.println("StringBuffer version");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        OverloadingEx3 test = new OverloadingEx3();
        test.msg("Avani");
        test.msg(new StringBuffer("Suraj"));
        //test.msg(null);   CE: Ambiguous. Both method matched
    }
}


/**
 * UseCase 4: Variable arg methods have least priority.
 * Whensoever there is a fight among older version concept and newer version concept,
 * then older version concept will win the fight
 */
class OverloadingEx4 {

    public void msg(int i) {            //Introduced in Java 1.0 version
        System.out.println("General method");
        System.out.println(i);
    }

    public void msg(int... ints) {      //Introduced in Java 1.5 version
        System.out.println("Var-agrs method");
        System.out.println(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        OverloadingEx4 test = new OverloadingEx4();
        test.msg();                 //It can take zero argument as well
        test.msg(10, 20);
        test.msg(10);            //Preference goes to gen method as it is older version concept
    }
}


/**
 * UseCase 5
 */
class OverloadingEx5 {

    public void msg(int i, float f) {
        System.out.println("Int-Float version");
    }

    public void msg(float f, int i) {
        System.out.println("Float-int version");
    }

    public static void main(String[] args) {
        OverloadingEx5 test = new OverloadingEx5();
        test.msg(10, 10.5f);
        test.msg(10.5f, 10);
        //test.msg(10,10);              CE: Ambiguous. Both method matched
        //test.msg(10.5f, 10.5f);       CE: No suitable method found for msg(float, float)
    }
}

/**
 * UseCase 6: In overloading mtd resolution is taken care by Compiler on the basis of reference.
 */

class Animal {
}

class Monkey extends Animal {
}


class OverloadingEx6 {

    public void msg(Animal a) {
        System.out.println("Animal version");
        System.out.println(a);
    }

    public void msg(Monkey m) {
        System.out.println("Monkey Version");
        System.out.println(m);
    }

    public static void main(String[] args) {
        OverloadingEx6 test = new OverloadingEx6();
        test.msg(new Animal());

        Animal an = new Animal();
        test.msg(an);

        Monkey m = new Monkey();
        test.msg(m);

        Animal ani = new Monkey();
        test.msg(ani);              //Reference is used by compiler for method execution and not object. But in output
        //it will mention the name of Monkey class
    }
}

/**
 * UseCase 7 : Overloading static method and main method
 */


class OverloadingStaticMethod {

    public static void main(String[] args) {
        System.out.println("Main method");
        OverloadingStaticMethod.main("Suraj");
    }

    public static void main(String args) {
        System.out.println("Hi " + args);
        OverloadingStaticMethod.main("Avani", "Suraj");
    }

    public static void main(String args1, String agrs2) {
        System.out.println(args1 + " Loves " + agrs2);

    }

}

/**
 * UseCase 8: int or Integer usecase for handling null scenarios
 */

class OverLoadingEx7 {

    public void msg(int i) {                 //But if used "Integer" (Class Data type) then, it will throw an error.
        System.out.println("Int version");
    }

    public void msg(String s) {
        System.out.println("String version");
    }

    public static void main(String[] args) {
        OverLoadingEx7 test = new OverLoadingEx7();
        test.msg(null);
    }
}