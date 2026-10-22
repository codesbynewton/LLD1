package org.example.lld1.inventorymanagementsystem;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        Item i1 = new Item("1", "Bat", 3000, 5);
        Item i2 = new Item("2", "Ball", 200, 3);
        Item i3 = new Item("3", "Stumps", 500, 7);
        Item i4 = new Item("4", "food", 400, 5);

        List<Item> items = Arrays.asList(i1, i2, i3, i4);

        Collections.sort(items, new ItemComparatorQuantityAndPrice());

        for(Item item : items){
            System.out.println(item.toString());
        }


        Inventory<Book> bookInventory = new Inventory<>();
        bookInventory.addItem(new Book("1", "Harry Potter", 350, 3, "JK Rowling"));
        bookInventory.addItem(new Book("2", " Intelligent Investor", 400, 7, "B Graham"));



        OrderQueue orderQueue = new OrderQueue();

        orderQueue.addOrder(new Order("ORD-101", false));
        orderQueue.addOrder(new Order("ORD-102", true));
        orderQueue.addOrder(new Order("ORD-103", false));
        orderQueue.addOrder(new Order("ORD-104", true));

        Order order;

        while ((order = orderQueue.processOrder()) != null) {
            System.out.println(order);
        }


        // Testing for ItemWishList

        Item item1 = new Item("1", "Bat", 3000, 5);
        Item item2 = new Item("1", "Bat", 3000, 5);

        ItemWishList wishList = new ItemWishList();

        wishList.addToWishList(item1);
        wishList.addToWishList(item1);
        wishList.addToWishList(item2);

        System.out.println(wishList.getWishList().size());

    }
}
