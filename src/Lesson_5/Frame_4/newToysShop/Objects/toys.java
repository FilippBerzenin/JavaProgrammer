package Lesson_5.Frame_4.newToysShop.Objects;

import Lesson_5.Frame_4.newToysShop.Enums.Type;

public abstract class Toys implements InterfaceToys {

    private String name;

    private double price;

//    private String model;

    private boolean exclusive;

//    private boolean newToys;
//
//    private boolean stock;
//
//    private boolean hit;

    private Type type;

    public Toys(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
//        this.model = model;
    }

    public Toys(String name, double price, Type type,  boolean exclusive) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    public boolean isNewToys() {
//        return newToys;
//    }
//
//    public void setNewToys(boolean newToys) {
//        this.newToys = newToys;
//    }
//
//    public boolean isStock() {
//        return stock;
//    }
//
//    public void setStock(boolean stock) {
//        this.stock = stock;
//    }
//
//    public boolean isHit() {
//        return hit;
//    }
//
//    public void setHit(boolean hit) {
//        this.hit = hit;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


