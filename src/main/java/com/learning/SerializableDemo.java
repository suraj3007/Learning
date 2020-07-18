package main.java.com.learning;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws Exception {

        Test123 t1 = new Test123();

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Test123 t2 = (Test123)ois.readObject();

        System.out.println(t2.i +" .... " + t2.j);
    }
}


class Account implements Serializable {
    String username = "Suraj";
    transient String pwd = "Milan";
    transient int pin = 1234;

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();

        String epwd = 123 + username;
        oos.writeObject(epwd);

        int epin = 4444 + pin;
        oos.writeInt(epin);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();

        String epwd = (String) ois.readObject();
        pwd = epwd.substring(3);

        int epin = ois.readInt();
        pin = epin - 4444;
    }
}

class SerializableDemo2 {

    public static void main(String[] args) throws Exception {

        Account a1 = new Account();
        System.out.println(a1.username + "...." + a1.pwd + "...." + a1.pin);

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2 = (Account) ois.readObject();

        System.out.println(a2.username + "...." + a2.pwd + "...." + a2.pin);
    }
}

interface Left {
    default void m1 () {
        System.out.println("Left method");
    }
}

interface Right {
    default void m1 () {
        System.out.println("Right method");
    }
}

class Demo implements Left,Right {

    public void m1 () {
        System.out.println("Our own m1 method");
        Left.super.m1();
        Right.super.m1();
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.m1();
    }
}