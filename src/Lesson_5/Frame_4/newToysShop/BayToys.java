package Lesson_5.Frame_4.newToysShop;

import Lesson_5.Frame_4.newToysShop.Utillites.AddToStock;
import Lesson_5.Frame_4.newToysShop.Objects.Toys;
import Lesson_5.Frame_4.newToysShop.Enums.Type;

import java.util.ArrayList;
import java.util.List;

public class BayToys {

    List<Toys[]> stock = new ArrayList<>();

    public BayToys () {
        stock = AddToStock.addToStock(stock, 10, "BMW M3", 59.90, Type.CARS);
        stock = AddToStock.addToStock(stock, 10, "Ferrari 512", 59.90, Type.CARS);
        stock = AddToStock.addToStock(stock, 10, "Dodge Viper V12", 59.90, Type.CARS);
        stock = AddToStock.addToStock(stock, 10, "Mini", 59.90, Type.CARS);
        stock = AddToStock.addToStock(stock, 10, "Aston Martin", 99.90, Type.CARS, true);

        for (int i = 0; i<stock.size();i++) {
            System.out.println("Toys type "+stock.get(i)[0].getType()+", Cars model "+stock.get(i)[0].getName()+", Price, UAH "
                    +stock.get(i)[0].getPrice());
        }

    }

    public List<Toys[]> getStock() {
        return stock;
    }

    public void setStock(List<Toys[]> stock) {
        this.stock = stock;
    }
}
