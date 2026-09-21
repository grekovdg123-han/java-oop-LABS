package com.mycompany.lab3;

public class NewBuildingApartment extends Apartment implements Advertizable {
    private boolean hasParking;

    public NewBuildingApartment(String address, double area, double basePrice, boolean hasParking) {
        super(address, area, basePrice);
        this.hasParking = hasParking;
    }

    @Override
    public double calculateFinalPrice() {
        return hasParking ? basePrice + 500000 : basePrice;
    }

    @Override
    public String generateReport() {
        return "НОВОСТРОЙКА: " + super.toString() + 
               ". Парковка: " + (hasParking ? "Есть" : "Нет") + 
               ". Итоговая цена: " + calculateFinalPrice() + " руб.";
    }
}