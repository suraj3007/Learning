package main.java.com.learning;

class Display {

    /**
     * synchronized mtd -> thread requires object level lock. Always check object level status
     * static synchronized mtd -> thread requires class level lock. Always check class level lock status
     * @param name
     */
    public static synchronized void wish(String name) {
        for (int i = 0; i < 10; i++){
            System.out.print("Good morning : ");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
            }
            System.out.println(name);
        }
    }
}

class MyThread1 extends Thread {
    
    Display d;
    String name;

    public MyThread1(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class demosynch1 {
    public static void main(String[] args) {

        Display d = new Display();

        //for same object.. to get ordered output use synchronized keyword
        MyThread1 t1 = new MyThread1(d, "Kohli");
        MyThread1 t2 = new MyThread1(d, "Rohit");

        t1.start();
        t2.start();

    }
}

class demosynch2 {
    public static void main(String[] args) {

        Display d1 = new Display();
        Display d2 = new Display();

        //for different object.. to get ordered output use "static synchronized"
        MyThread1 t1 = new MyThread1(d1, "Kohli");
        MyThread1 t2 = new MyThread1(d2, "Rohit");

        t1.start();
        t2.start();
    }
}