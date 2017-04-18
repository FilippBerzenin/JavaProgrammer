package Lesson_5.Frame_4.newToysShop.Objects;

import Lesson_5.Frame_4.newToysShop.Enums.Type;

public class ToyCars extends Toys {
    public ToyCars(String name, double price, Type type) {
        super(name, price, type);
    }

    public ToyCars(String name, double price, Type type, boolean exclusive) {
        super(name, price, type, exclusive);
    }
}
