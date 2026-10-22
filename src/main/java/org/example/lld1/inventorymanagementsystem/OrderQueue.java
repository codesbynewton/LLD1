package org.example.lld1.inventorymanagementsystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> orderQueue;

    public OrderQueue() {
        this.orderQueue = new PriorityQueue<>((a,b) -> Boolean.compare(b.isExpress(), a.isExpress()));
    }

    public void addOrder(Order order){
        orderQueue.add(order);
    }

    public Order processOrder(){
       return orderQueue.poll();
    }
}
