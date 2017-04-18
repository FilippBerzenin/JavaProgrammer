package Lesson_5.Frame_4.newToysShop.Utillites;

import Lesson_5.Frame_4.newToysShop.Objects.HotWeels;
import Lesson_5.Frame_4.newToysShop.Objects.Toys;
import Lesson_5.Frame_4.newToysShop.Enums.Type;

import java.util.List;

public class AddToStock {

    public static List<Toys[]> addToStock (List<Toys[]> stock, int sum, String name, double price, Type type) {
        Toys[] t = new HotWeels[sum];
        for (int h = 0; h<sum;h++) {
            t[h] = new HotWeels(name, price, type);
        }
        stock.add(t);
        return stock;
    }

    public static List<Toys[]> addToStock (List<Toys[]> stock, int sum, String name, double price,Type type, boolean exclusive) {
        Toys[] t = new HotWeels[sum];
        for (int h = 0; h<sum;h++) {
            t[h] = new HotWeels(name, price, type, exclusive);
        }
        stock.add(t);
        return stock;
    }
}
