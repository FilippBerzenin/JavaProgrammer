package Lesson_3.Frame_3.Tank.CoffeeShop;

public abstract class AbstractProduct implements PriceInterface {

    protected String productName;
    protected double price;

    AbstractProduct() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
