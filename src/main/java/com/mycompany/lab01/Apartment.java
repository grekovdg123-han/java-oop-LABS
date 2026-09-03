public class Apartment{
    private long id;
    private String adress;
    private double area;
    private int rooms;
    private double price;
    
    
    public long getId(){
        return id;
    }
    
    public String getAddress(){
        return adress;
    }
    
    public double getArea(){
        return area;
    }
    
    public int getRooms(){
        return rooms;
    }
    
    public double getPrice(){
        return price;
    }
    public void setAdress(String adress){
        if (adress == null || adress.isEmpty()){
            throw new IllegalArgumentException("Адрес не может быть пустым"); 
        }
        this.adress =adress;
    }
    public void setArea(double area){
        if (area <= 0){
            throw new IllegalArgumentException("Цена не может быть отрицательной");  
        }
        this.area=area;
    }
    public void setRooms(int rooms){
        if(rooms < 1 || rooms >10){
            throw new IllegalArgumentException("Комнаты не соответствуют диапозону");
        }
        this.rooms=rooms;
    }
    public void setPrice(double price){
        if(price <= 0){
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price=price;
    }
    
    public void setId(long id) {
    if (id <= 0) {
        throw new IllegalArgumentException("ID должен быть больше 0");
    }
    this.id = id;
}
    
}
