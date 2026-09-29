package com.mycompany;



import java.util.Objects;

public class Apartment {
    private long id;
    private String address;
    private double area;
    private int rooms;
    private double price;

    public Apartment(long id, String address, double area, int rooms, double price) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.rooms = rooms;
        this.price = price;
    }

    public long getId() { return id; }
    public String getAddress() { return address; }
    public double getArea() { return area; }
    public int getRooms() { return rooms; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Кв. #%d: %s, %.1f м², %d комн., %.0f руб.", id, address, area, rooms, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return id == apartment.id && 
               Double.compare(apartment.area, area) == 0 && 
               rooms == apartment.rooms && 
               Double.compare(apartment.price, price) == 0 && 
               Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, area, rooms, price);
    }
}