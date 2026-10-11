package org.example.lld1.concurrency.PorducerConsumer;

import java.util.HashMap;

public class Producer implements Runnable{
    private Store store;

    Producer(Store store){
        this.store = store;
    }


    public void run(){
        while(true){
            synchronized (store){
                if(store.getItems().size() < store.getMaxSize()){
                    store.addItem(new Object());
                }
            }

        }
    }
}
