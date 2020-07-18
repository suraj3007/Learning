package main.java.com.learning;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {

        DisplayDemo d = new DisplayDemo();
        MyThreadDemo t1 = new MyThreadDemo(d, "Virat");
        MyThreadDemo t2 = new MyThreadDemo(d, "Rohit");

        t1.start();
        t2.start();
    }
}

class DisplayDemo {

    ReentrantLock l = new ReentrantLock();      //Using ReentrantLock of concurrent package

    public void wish(String name) {      // using lock() mtd

        l.lock();       // locking

        for (int i = 0; i <= 10; i++) {
            System.out.print("Good morning : ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        l.unlock();     // unlocking
    }
}

class MyThreadDemo extends Thread {
    DisplayDemo d;
    String name;

    public MyThreadDemo(DisplayDemo d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

// ------------------------------------------------------------------------------------------------------------


class MyThreadDemo2 extends Thread {        // using tryLock() mtd

    static ReentrantLock l1 = new ReentrantLock();

    MyThreadDemo2(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (l1.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " .... got lock and performing safe operations");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            l1.unlock();
        }else {
            System.out.println(Thread.currentThread().getName() + " .... doesnt get lock and performing alternative operations");
        }
    }
}

class ReentrantLockDemo2 {

    public static void main(String[] args) {

        MyThreadDemo2 t1 = new MyThreadDemo2("First Thread");
        MyThreadDemo2 t2 = new MyThreadDemo2("Second Thread");

        t1.start();
        t2.start();

    }
}