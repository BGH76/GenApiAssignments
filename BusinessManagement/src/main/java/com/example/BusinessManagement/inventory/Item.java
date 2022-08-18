package com.example.BusinessManagement.inventory;

public class Item {

    private String itemNumber;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private int min;
    private int max;

    public Item() {
    }

    public Item(String itemNumber, String itemName, int itemQuantity, double itemPrice, int min, int max) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.min = min;
        this.max = max;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNumber='" + itemNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemPrice=" + itemPrice +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
