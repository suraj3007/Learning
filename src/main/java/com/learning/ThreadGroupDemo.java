package main.java.com.learning;

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("First Group");
        ThreadGroup group1 = new ThreadGroup(group, "Second group");

        System.out.println(group.getParent().getName());    // main
        System.out.println(group1.getParent().getName());   // First Group

    }
}


class ThreadGroupPriorityDemo {
    public static void main(String[] args) {

        ThreadGroup tg = new ThreadGroup("tg");

        Thread t1 = new Thread(tg, "Thread-1");
        Thread t2 = new Thread(tg, "Thread-2");

        tg.setMaxPriority(3);

        Thread t3 = new Thread(tg, "Thread-3");

        System.out.println(t1.getPriority());   // 5
        System.out.println(t2.getPriority());   // 5
        System.out.println(t3.getPriority());   // 3

    }
}


class ThreadGroupDemo2 {

    public static void main(String[] args) {

        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] threads = new Thread[system.activeCount()];

        system.enumerate(threads);

        for (Thread t : threads) {
            System.out.println(t.getName() + " ------ " + t.isDaemon());
        }
    }
}