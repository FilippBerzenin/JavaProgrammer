package Lesson_2.Frame_6.ToysShop.report;

import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.utilities;

import java.sql.Array;
import java.util.Arrays;

public class productsOnStock {

    public static void orderNumbersOfProductOnStock () {
        int allToysOfClass = 0;
        int allToys = 0;
        System.out.println("----------------ORDER OF PRODUCTS ON STOCK--------------------");
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < utilities.longArray(mainToysArray.getMain()[i]); k++) {
                if (mainToysArray.getMain()[i][k] == null) {
                    break;
                } else {
                    System.out.println("Name toys: " + mainToysArray.getMain()[i][k].getNameToys() + " " + "Number of toys: " +
                            mainToysArray.getMain()[i][k].getNumber());
                    allToysOfClass += mainToysArray.getMain()[i][k].getNumber();
                    allToys += mainToysArray.getMain()[i][k].getNumber();
                }
            }
            System.out.println("All toys of class: " + allToysOfClass);
            allToysOfClass = 0;
            System.out.println("---------------------------------------");
        }
        System.out.println("All toys: " + allToys);
        System.out.println("----------------END OF ORDER--------------------");
        System.out.println();
    }
}
