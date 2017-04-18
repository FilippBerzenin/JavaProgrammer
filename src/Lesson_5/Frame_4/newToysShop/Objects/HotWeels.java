package Lesson_5.Frame_4.newToysShop.Objects;

import Lesson_5.Frame_4.newToysShop.Enums.Type;

public class HotWeels extends Toys {

    public HotWeels(String name, double price, Type type) {
        super(name, price, type);
    }

    public HotWeels(String name, double price, Type type, boolean exclusive) {
        super(name, price, type, exclusive);
    }
}
