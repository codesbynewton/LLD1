package org.example.lld1.inventorymanagementsystem;

public class Item implements Comparable<Item>{
    private String id;
    private String name;
    private int price;
    private int quantity;

    public Item(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //this to come first -> return -ve value
    // second object to come first -> return +value
    @Override
    public int compareTo(Item o) {
        if(this.getPrice() < o.getPrice()) return -1;
        else if(o.getPrice() < this.getPrice()) return 1;
        return 0;
    }

    @Override
    public String toString(){
        return "Item{" + "id= " +  this.id + " name=" + this.name + " price= " + this.price + " quantity=" + this.quantity;
    }
}
