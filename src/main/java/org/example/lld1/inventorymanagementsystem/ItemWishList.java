package org.example.lld1.inventorymanagementsystem;

import java.util.HashSet;
import java.util.Set;

public class ItemWishList {
    private Set<Item> wishList;

    public ItemWishList() {
        this.wishList = new HashSet<>();
    }

    public Set<Item> getWishList() {
        return wishList;
    }

    public void addToWishList(Item item){
        wishList.add(item);
    }

    public void removeFromWishList(Item item){
        wishList.remove(item);
    }
}
