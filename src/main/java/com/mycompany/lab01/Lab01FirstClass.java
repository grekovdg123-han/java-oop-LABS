package com.mycompany.lab01;

public class Lab01FirstClass {

    public static void main(String[] args) {

        Apartment ap = new Apartment();

        ap.setId(1);
        ap.setAddress("ул. Ленина, д. 1");
        ap.setArea(65.5);
        ap.setRooms(2);
        ap.setPrice(8500000);

        System.out.println(ap.getDescription());
    }
}