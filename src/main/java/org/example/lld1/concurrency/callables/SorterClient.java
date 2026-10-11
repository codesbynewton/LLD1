package org.example.lld1.concurrency.callables;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SorterClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hi Hari");
        List<Integer> arr = Arrays.asList(5,2,1,6,7,3,9,8,4);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Sorter sorter = new Sorter(arr, executorService);
        Future<List<Integer>> listFuture = executorService.submit(sorter);

        List<Integer> sortedList = listFuture.get();

        System.out.println("SOrted list is " + sortedList);
        executorService.shutdown();


    }
}
