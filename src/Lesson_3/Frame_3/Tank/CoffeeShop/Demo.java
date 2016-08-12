package Lesson_3.Frame_3.Tank.CoffeeShop;


import java.util.Arrays;


public class Demo {

    public static void main(String[] args) {

        printMenu(new Menu());
    }

    public static void printMenu(Menu m) {
        for (int i = 0; i < Utilites.lastElementInArrar(m.getName()); i++) {
            System.out.println(" Name of product " + m.getName()[i].getProductName() +
                    " Ingridients " + Arrays.toString(m.getName()[i].getProduct()) +
                    " Price: " + m.getName()[i].price);
        }

    }
}

