package main.java.com.learning;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(2);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable consumer = () -> {
            while (true) {
                try {
                    int num = queue.take();
                    System.out.println("Number Consumed : " + num);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable producer = () -> {
            while (true) {
                Random random = new Random();
                int num = random.nextInt(1000);
                System.out.println("Number produced : " + num);
                try {
                    queue.put(num);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.execute(producer);
        service.execute(consumer);
    }
}