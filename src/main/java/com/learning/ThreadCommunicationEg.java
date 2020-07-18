package main.java.com.learning;

public class ThreadCommunicationEg {
}


class mainThread {

    public static void main(String[] args) {



        ChildThreadd t = new ChildThreadd();
        t.start();

        synchronized (t){
            try {
                System.out.println("Main thread calling wait method.. Going into waiting state");
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread got notified");

        System.out.println("Total : " + t.total);
    }
}


class ChildThreadd extends Thread {

    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Child thread is starting calculation");
            for (int i = 0 ; i <=100 ; i++){
                total = total + i;
            }
            System.out.println("Child thread completed execution...Notifying main thread..");
            this.notify();
        }
    }
}