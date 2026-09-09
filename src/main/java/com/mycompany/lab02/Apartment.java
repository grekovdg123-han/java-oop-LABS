package com.mycompany.lab02;

public class Apartment {

    private static int apartmentCounter = 0;

    private long id;
    private String address;
    private double area;
    private int rooms;
    private double price;
    private ApartmentStatus status;

    public Apartment() {
        this(0, "Адрес не указан", 1, 1, 1, ApartmentStatus.FREE);
    }

    public Apartment(String address, double area, int rooms, double price, ApartmentStatus status) {
        this(0, address, area, rooms, price, status);
    }

    public Apartment(String address, double area) {
        this(0, address, area, 1, 1, ApartmentStatus.FREE);
    }
    
    public Apartment(long id, String address, double area, int rooms, double price, ApartmentStatus status) {
        apartmentCounter++;
        this.id = (id <= 0) ? apartmentCounter : id;

        setAddress(address);
        setArea(area);
        setRooms(rooms);
        setPrice(price);
        this.status = status;
    }


    public static int getCounter() {
        return apartmentCounter;
    }

    public static Apartment createApartment(String address, double area, int rooms, double price, ApartmentStatus status) {
        return new Apartment(address, area, rooms, price, status);
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getRooms() {
        return rooms;
    }

    public double getPrice() {
        return price;
    }

    public ApartmentStatus getStatus() {
        return status;
    }

    public void setStatus(ApartmentStatus status) {
        this.status = status;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Адрес не может быть пустым");
        }
        this.address = address;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь не может быть отрицательной или нулевой");
        }
        this.area = area;
    }

    public void setRooms(int rooms) {
        if (rooms < 1 || rooms > 10) {
            throw new IllegalArgumentException("Комнаты не соответствуют диапазону");
        }
        this.rooms = rooms;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или нулевой");
        }
        this.price = price;
    }
    
    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }
        this.id = id;
    }
    public String getStatusMessage() {
        switch (status) {
            case FREE:
                return "Свободна — доступна для покупки";
            case SOLD:
                return "Продана — недоступна";
            case RENTED:
                return "Сдана в аренду";
            default:
                return "Статус неизвестен";
        }
    }

    public String getDescription() {
        return "Квартира по адресу " + address + ": " +
                area + " м², " + rooms + " комн., " +
                getStatusMessage() +
                ", цена " + price + " руб.";
    }

    public String getDescription(boolean withStatus) {
        if (withStatus) {
            return getDescription();
        }
        return "Квартира по адресу " + address + ": " +
                area + " м², " + rooms + " комн., цена " + price + " руб.";
    }
}