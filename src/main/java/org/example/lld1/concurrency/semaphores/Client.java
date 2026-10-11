package org.example.lld1.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store();
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumeSemaphore = new Semaphore(0);

        for(int i =0; i< 5; i++){
            Producer producer = new Producer(store, producerSemaphore, consumeSemaphore, i);
            Thread td = new Thread(producer);
            td.start();
        }

        for(int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(store, consumeSemaphore, producerSemaphore, i);
            Thread td = new Thread(consumer);
            td.start();
        }
    }
}
