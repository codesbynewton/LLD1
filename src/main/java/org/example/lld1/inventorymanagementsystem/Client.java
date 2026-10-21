package org.example.lld1.inventorymanagementsystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    }
}
