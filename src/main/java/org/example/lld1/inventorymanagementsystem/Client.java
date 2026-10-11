package org.example.lld1.inventorymanagementsystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Item i1 = new Item("1", "Bat", 3000, 5);
        Item i2 = new Item("2", "Ball", 200, 3);
        Item i3 = new Item("3", "Stumps", 500, 7);

        List<Item> items = Arrays.asList(i1, i2, i3);

        Collections.sort(items);

        for(Item item : items){
            System.out.println(item.toString());
        }

    }
}
