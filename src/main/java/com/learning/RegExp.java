package main.java.com.learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(args[0]);
        if(m.find() && m.group().equals(args[0])){
            System.out.println("Valid mobile number");
        }else {
            System.out.println("Invalid mobile number");
        }
    }
}

class TestNPE {
    public static void main(String[] args) {
        System.out.println("A".compareTo("Z"));
        System.out.println("Z".compareTo("K"));
        System.out.println("A".compareTo("A"));
        System.out.println("A".compareTo(null));
    }
}

class A{
    private void m1(){
        System.out.println("A method m1");
    }

    public void m2(){
        System.out.println("A method m1");
    }
}

class B extends A {
    private void m1(){
        System.out.println("A method m1");
    }

    public final void m2() {
        System.out.println("B method m1");
    }
}

class AB {
    public static void main(String[] args) {
        A a = new B();
        a.m2();
    }
}