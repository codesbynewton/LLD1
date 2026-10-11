package org.example.lld1.concurrency.PorducerConsumer;

public class Client {

    public static void main(String[] args) {
        Store store = new Store(10);



        //Hire 8 factory workers
        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store);
            Thread td = new Thread(producer);
            td.start();
        }


        //Open doors for 20 Customers
        for(int i = 0; i < 20; i++){
            Consumer consumer = new Consumer(store);
            Thread td = new Thread(consumer);
            td.start();
        }
    }
}
