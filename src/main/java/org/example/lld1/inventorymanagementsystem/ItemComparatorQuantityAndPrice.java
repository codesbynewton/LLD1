package org.example.lld1.inventorymanagementsystem;

import java.util.Comparator;

public class ItemComparatorQuantityAndPrice implements Comparator<Item> {

    // sort based on quantity - ASC
    // sort based on name - DESC

    @Override
    public int compare(Item o1, Item o2){
        if(o1.getQuantity() > o2.getQuantity()) return 1;
        else if(o1.getQuantity() < o2.getQuantity()) return -1;
        else {
            if(o1.getName().compareTo(o2.getName()) > 0 ) return -1;
            else return 1;
        }
    }
}
