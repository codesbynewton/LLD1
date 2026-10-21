package org.example.lld1.inventorymanagementsystem;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems {

    private LinkedList<Item> items;
    private final int MAX_SIZE = 10;

    public RecentlyViewedItems(){
        this.items = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item){
        items.remove(item);

        items.addFirst(item);
        if(items.size() > MAX_SIZE) items.removeLast();
    }

    public List<Item> getRecentlyViewedItems(){
        return new ArrayList<>(items);
    }
}
