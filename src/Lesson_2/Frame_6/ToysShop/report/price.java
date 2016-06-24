package Lesson_2.Frame_6.ToysShop.report;
import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.utilities;

public class price {

    price () {

    }

    public static void orderOfPrice () {
        System.out.println("----------------ORDER OF PRICE--------------------");
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < utilities.longArray(mainToysArray.getMain()[i]); k++) {
                if (mainToysArray.getMain()[i][k] == null) {
                    break;
                } else {
                    System.out.println("Name toys: " + mainToysArray.getMain()[i][k].getNameToys() + " " + "Price: " +
                            mainToysArray.getMain()[i][k].getPrice());
                }
            }
            System.out.println("---------------------------------------");
        }
        System.out.println("----------------END OF ORDER--------------------");
        System.out.println();
    }
}
