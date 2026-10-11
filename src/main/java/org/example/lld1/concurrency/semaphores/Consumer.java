package org.example.lld1.concurrency.semaphores;


import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Store store;
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;
    private int id;

    public Consumer(Store store, Semaphore consumerSemaphore, Semaphore producerSemaphore, int id){
        this.store = store;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
        this.id = id;
    }

    public void run(){
        while(true){
            try{
                consumerSemaphore.acquire();
                store.removeItem(id);
                producerSemaphore.release();
            } catch (InterruptedException ie){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
