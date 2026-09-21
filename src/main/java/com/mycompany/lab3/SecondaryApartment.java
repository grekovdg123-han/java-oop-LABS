package com.mycompany.lab3;

public class SecondaryApartment extends Apartment implements Advertizable {
    private boolean needsRenovation;

    public SecondaryApartment(String address, double area, double basePrice, boolean needsRenovation) {
        super(address, area, basePrice);
        this.needsRenovation = needsRenovation;
    }

    @Override
    public double calculateFinalPrice() {
        return needsRenovation ? basePrice * 0.9 : basePrice;
    }

    @Override
    public String generateReport() {
        return "ВТОРИЧКА: " + super.toString() + 
               ". Требует ремонта: " + (needsRenovation ? "Да (скидка 10%)" : "Нет") + 
               ". Итоговая цена: " + calculateFinalPrice() + " руб.";
    }
}