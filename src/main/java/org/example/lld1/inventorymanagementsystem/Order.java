package org.example.lld1.inventorymanagementsystem;

import java.util.Queue;

public class Order {
    private String orderId;
    private boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', express=" + isExpress + "}";
    }
}
