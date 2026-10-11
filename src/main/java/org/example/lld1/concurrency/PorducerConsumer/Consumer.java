package org.example.lld1.concurrency.PorducerConsumer;

public class Consumer implements Runnable{
    private Store store;

    public Consumer(Store store){
        this.store = store;
    }

    public void run(){
        while(true){
            synchronized (store){
                if(store.getItems().size() > 0){
                    store.removeItem();
                }
            }
        }
    }

}
