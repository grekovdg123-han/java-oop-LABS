package com.mycompany.lab02;

public class Lab02Constructors {

    public static void main(String[] args) {

        Apartment ap = new Apartment();

        ap.setId(1);
        ap.setAddress("ул. Ленина, д. 1");
        ap.setArea(65.5);
        ap.setRooms(2);
        ap.setPrice(8500000);
        ap.setStatus(ApartmentStatus.FREE);

        System.out.println(ap.getDescription());
    }
}