package org.example.lld1.concurrency.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //This is the old way
//        for(int i = 0; i < 100; i++){
//            NumberPrinter np = new NumberPrinter(i);
//            Thread thread = new Thread(np);
//            thread.start();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executorService.execute(np);
        }
    }
}
