package com.mycompany.lab3;

public abstract class Apartment {
    protected String address;
    protected double area;
    protected double basePrice;

    public Apartment(String address, double area, double basePrice) {
        this.address = address;
        this.area = area;
        this.basePrice = basePrice;
    }

    public String getAddress() { return address; }
    public double getArea() { return area; }
    public double getBasePrice() { return basePrice; }

    public abstract double calculateFinalPrice();

    @Override
    public String toString() {
        return address + " (" + area + " м²), базовая цена: " + basePrice + " руб.";
    }
}