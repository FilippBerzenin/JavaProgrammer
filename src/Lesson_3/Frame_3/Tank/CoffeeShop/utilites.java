package Lesson_3.Frame_3.Tank.CoffeeShop;

public class Utilites {

    public static int lastElementInArrar(Products[] array) {
        int lastI = 0;
        int i = 0;
        for (Products t : array) {
            i++;
            lastI = i;
            if (array[i] == null) {
                return lastI;
            }
        }
        return lastI;
    }
}
