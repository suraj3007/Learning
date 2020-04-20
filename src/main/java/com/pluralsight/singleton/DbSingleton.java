package main.java.com.pluralsight.singleton;

public class DbSingleton extends BreakSingleton2 {

    private static volatile DbSingleton instance = null;     //Lazy-loading. Will not instantiate this at the startup.
                                                             //Volatile reason is explained below.

    private DbSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");     //To avoid new instantiation by using Reflections in java
                                                                                  // Eg. BreakSingleton class
        }
    }

    public static DbSingleton getInstance() {

        if (instance == null) {                                     //Will be instantiated only when called.
            synchronized (DbSingleton.class){                       //Thread-safe. For performance we have not synchronized the whole mtd
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();                     //To avoid new instantiation by using clone method in java
                                                                    // Eg. BreakSingleton2 class
    }

}


//If we do not make the _instance variable volatile then the Thread which is creating the instance of Singleton is not able to communicate to the other thread
//So if Thread A is creating Singleton instance and just after creation, the CPU corrupts etc, all other threads will not be able to see the value of _instance as not null and they will believe it is still assigned null
//Why does this happen?
//Because reader threads are not doing any locking and until the writer thread comes out of a synchronized block, the memory will not be synchronized and value of _instance will not be updated in main memory.
//With the Volatile keyword in Java, this is handled by Java itself and such updates will be visible by all reader threads.

//Conclusion: volatile keyword is also used to communicate the content of memory between threads.
