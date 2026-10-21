package org.example.lld1.inventorymanagementsystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory <T extends  Item>{
    private Map<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public Map<String, T> getItems() {
        return items;
    }

    public void setItems(Map<String, T> items) {
        this.items = items;
    }

    public void addItem(T item){
        if(items.containsKey(item.getId())) {
            throw new RuntimeException("Item already exists with id" + item.getId());
        }
        items.put(item.getId(), item);
    }

    public void removeItem(String id){
        items.remove(id);
    }

    public T getItem(String id){
        return items.get(id);
    }

    public Collection<T> getAllItems(){
        return items.values();
    }
}
