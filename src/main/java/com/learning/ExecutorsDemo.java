package main.java.com.learning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {

    public static void main(String[] args) {

        PrintJob[] jobs = {
                new PrintJob("Virat"),
                new PrintJob("Rohit"),
                new PrintJob("Bumrah"),
                new PrintJob("Dhoni"),
                new PrintJob("Rahul"),
                new PrintJob("Pant")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (PrintJob job : jobs) {
            service.submit(job);
        }
        service.shutdown();
    }
}


class PrintJob implements Runnable {    //Using Runnable interface

    String name;

    public PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " job started by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " job completed by thread " + Thread.currentThread().getName());
    }
}

// ------------------------------------------------------------------------------------------------------------


class MyCallable implements Callable {      //Using Callable interface

    int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {

        System.out.println(Thread.currentThread().getName() + " is responsible to calculate sum of first " + num + " numbers");

        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

class CallableDemo {
    public static void main(String[] args) throws Exception {

        Callable[] jobs = {
                new MyCallable(10),
                new MyCallable(20),
                new MyCallable(30),
                new MyCallable(40),
                new MyCallable(50),
                new MyCallable(60)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (Callable job : jobs) {
            Future f = service.submit(job);     // In this case, output returned by service.subbmit() can be held by Future object
            System.out.println(f.get());
        }
        service.shutdown();
    }
}

// ------------------------------------------------------------------------------------------------------------

class ThreadLocalDemo {

    public static void main(String[] args) {

        ThreadLocal local = new ThreadLocal();
        System.out.println(local.get());        //null

        local.set("suraj");
        System.out.println(local.get());        //suraj

        local.remove();
        System.out.println(local.get());         //null
    }
}

// ------------------------------------------------------------------------------------------------------------


class ThreadLocalDemo1 {

    public static void main(String[] args) {       //using ThreadLocal

        ThreadLocal local = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "abc";
            }
        };
        System.out.println(local.get());        //null

        local.set("suraj");
        System.out.println(local.get());        //suraj

        local.remove();
        System.out.println(local.get());         //null
    }
}

// ------------------------------------------------------------------------------------------------------------


class CustomerThread extends Thread {

    CustomerThread(String name) {
        super(name);
    }

    static int custId = 0;

    static ThreadLocal t = ThreadLocal.withInitial(() -> ++custId);         // alternative for line 122

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing with customer id : " + t.get());
    }
}

class CustomerThreadDemo {

    public static void main(String[] args) {

        CustomerThread[] threads = {
                new CustomerThread("Customer Thread-1"),
                new CustomerThread("Customer Thread-2"),
                new CustomerThread("Customer Thread-3"),
                new CustomerThread("Customer Thread-4"),
        };

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (CustomerThread thread : threads) {
            service.submit(thread);
        }
        service.shutdown();
    }
}

// ------------------------------------------------------------------------------------------------------------

class ParentThread extends Thread {     // using InheritableThreadLocal

    static InheritableThreadLocal tl = new InheritableThreadLocal(){
        @Override
        protected Object childValue(Object parentValue) {
            return "cc";
        }
    };

    @Override
    public void run() {
        tl.set("pp");
        System.out.println("Parent Thread value ---> " + tl.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}


class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println("child thread value ---> " + ParentThread.tl.get());
    }
}

class InhertitableThreadLocalDemo {
    public static void main(String[] args) {
        ParentThread pt = new ParentThread();
        pt.start();
    }
}