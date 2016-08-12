package Lesson_3.Frame_3.Tank.CoffeeShop;

public class Products extends AbstractProduct {

    private Ingidienta[] product;

    Products(Ingidienta... ingidient) {
        this.product = ingidient;
    }

    Products(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    Products(String productName, Ingidienta... ingidient) {
        this.product = ingidient;
        this.productName = productName;
        this.price();
    }

    Products() {

    }

    public Ingidienta[] getProduct() {
        return product;
    }

    public void setProduct(Ingidienta[] product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double price() {
        price = 0;
        for (int i = 0; i < product.length; i++) {
            price += product[i].getPrice();
        }
        return price;
    }


}
