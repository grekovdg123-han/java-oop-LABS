// Lab03Main.java
package com.mycompany.lab3;

import java.util.ArrayList;
import java.util.List;

public class Lab03Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Демонстрация полиморфизма ===");
        
        Apartment[] apartments = {
            new NewBuildingApartment("ЖК Солнечный", 65.5, 8000000, true),
            new SecondaryApartment("ул. Ленина, д. 1", 45.0, 5000000, true),
            new SecondaryApartment("пр. Мира, д. 10", 80.0, 12000000, false)
        };

        for (Apartment apt : apartments) {
            System.out.println("Адрес: " + apt.getAddress() + 
                               ", Итоговая цена: " + apt.calculateFinalPrice() + " руб.");
        }

        System.out.println("\n=== 2. Работа с интерфейсом ===");
        
        List<Advertizable> reports = new ArrayList<>();
        reports.add((Advertizable) apartments[0]); 
        reports.add((Advertizable) apartments[1]);

        for (Advertizable item : reports) {
            System.out.println(item.generateReport());
        }
    }
}