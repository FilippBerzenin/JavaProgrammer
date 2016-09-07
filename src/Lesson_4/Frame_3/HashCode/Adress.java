package Lesson_4.Frame_3.HashCode;

public class Adress {
    private String city;
    private String street;
    private int house;

    Adress (){

    }

    Adress (String city, String street, int house) {
        if (city == null || street == null || house <=0) {
            System.out.println("Error");
        }
        else {
            this.city = city;
            this.street = street;
            this.house = house;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Adress) {
            Adress a = (Adress) obj;
             if (city.equals(a.getCity()) && street.equals(a.getStreet()) && house == a.getHouse()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int rezult = 25;
        rezult = 37*rezult+city.hashCode();
        rezult = 37*rezult+street.hashCode();
        rezult = 37*rezult+ (Integer) house;
        return rezult;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }
}
