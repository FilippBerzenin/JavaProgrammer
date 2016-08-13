package Lesson_3.Frame_3.Tank.CoffeeShop;

public enum Ingidienta {

    WATER(0.5), COFFEE(3), MILK(2), SUGAR(0.25), TEA(3), BERGAMOT(1.5), GREENTEA(3), CHOCOLATE(0.5), WORK(2);

    private double price;

    Ingidienta(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
