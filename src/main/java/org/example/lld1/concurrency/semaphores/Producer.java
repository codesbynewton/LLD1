package org.example.lld1.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private int id;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int id) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.id = id;
    }

    public void run(){
        while(true){
            try{
                producerSemaphore.acquire();
                store.addItem(id);
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

        }
    }
}
