package org.example.lld1.concurrency.callables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumCalc sumCalc = new SumCalc(100);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(sumCalc);

        //Do other tasks in this main thread
        System.out.println("Task submitted, doing other work meanwhile");

        //when you need the result you can call get()
        Integer result = future.get(); // <- BLOCKS untill the result is ready
        System.out.println("Sum of 1 to 100 is " + result);

        executorService.shutdown();

    }
}
