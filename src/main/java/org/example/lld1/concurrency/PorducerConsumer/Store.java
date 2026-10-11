package org.example.lld1.concurrency.PorducerConsumer;

import java.util.*;

public class Store {
    private int maxSize;
    private List<Object> items;

    public Store(int maxSize){
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public int getMaxSize(){
        return maxSize;
    }

    public List<Object> getItems(){
        return items;
    }

    public void addItem(Object item){
        items.add(item);
        System.out.println("Producer added item. Current size is : " + items.size());
    }

    public void removeItem(){
        Object item = items.remove(items.size() - 1);
        System.out.println("Consumer removed items. Current size : " + items.size());
    }

}
