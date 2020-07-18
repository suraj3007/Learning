package main.java.com.learning;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread");
        }
    }
}

public class MultiThreadingDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        //t.start();            //IllegalThreadStateException
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread");
        }
        //t.start();            //IllegalThreadStateException
    }
}



class MyRunnable implements Runnable {

    @Override
    public void run() {
        for(int i=0; i < 10; i++){
            System.out.println("child thread");
        }
    }
}

class MyRunnableDemo {
    public static void main(String[] args) {

        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);

        t.start();
        //t.run();                  //normal mtd call. O/p generated by main thread
        //r.run                     //normal mtd call. O/p generated by main thread
        for(int i=0; i < 10; i++){
            System.out.println("main thread");
        }

    }
}


interface testInt1{}

interface testInt12{}

class testInt implements testInt1,testInt12 {}

class MyThreadTest extends Thread {}

class ThreadDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        MyThreadTest test = new MyThreadTest();
        System.out.println(test.getName());

        MyThreadTest test1 = new MyThreadTest();
        System.out.println(test1.getName());

        Thread.currentThread().setName("suraj main");
        System.out.println(Thread.currentThread().getName());

        //System.out.println(10/0);


    }
}


class DemoThread {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getPriority());

        //Thread.currentThread().setPriority(17);       R.E: IllegalArgumentException
        Thread.currentThread().setPriority(7);

        MyThreadTest t = new MyThreadTest();
        System.out.println(t.getPriority());


    }
}


class childThread extends Thread {

    public void run (){
        try{
            for (int i = 0; i< 10; i++){
                System.out.println("Im lazy thread");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("I got interrupted");
        }
    }
}

class TestThread {

    public static void main(String[] args) throws InterruptedException {

        childThread t = new childThread();
        t.start();
        t.interrupt();
        System.out.println("End of main");
    }
}