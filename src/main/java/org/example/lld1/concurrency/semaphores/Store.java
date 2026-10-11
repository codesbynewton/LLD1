package org.example.lld1.concurrency.semaphores;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private Queue<Object> items;

    public Store(){
        this.items = new ConcurrentLinkedDeque<>();
    }

    public Queue<Object> getItems(){
        return items;
    }

    public void addItem(int id){
        items.add(new Object());
        System.out.println("producer added the item. The size is :" + items.size() + " by Thread: " + id );
    }

    public void removeItem(int id){
        items.remove(items.size() - 1);
        System.out.println("The cosumer removde the item. The size is : "+ items.size() + " By Thread: " + id);
    }


}
