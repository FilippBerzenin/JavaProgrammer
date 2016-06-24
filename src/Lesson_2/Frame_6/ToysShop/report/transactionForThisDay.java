package Lesson_2.Frame_6.ToysShop.report;

import Lesson_2.Frame_6.ToysShop.sell.bayers;
import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.utilities;

public class transactionForThisDay {

    public static void report(int day) {
        int longArray = utilities.longArray(bayers.getBayers());
        System.out.println("----------------REPORT FOR WORK OF DAY (Bayers)--------------------");
        int id = 1;
        int sum = 0;
        int totalItem = 0;
        System.out.println("ID  "+"Name of bayers  "+"Name of toys       "+"Price of toys  "+"Number of toys");
        for (int i = 0; i < longArray; i++) {
            if (bayers.getBayers() == null) {
                break;
            } else {
                if (bayers.getBayers()[i].getDayOfBay() == day) {
                    System.out.printf((id++) + "\t");
                    System.out.printf("%-16s", bayers.getBayers()[i].getNameBayers());
                    System.out.printf("%-22s",bayers.getBayers()[i].getNameOfToys()+"\t");
                    System.out.printf("%-10s",priceOfToys(bayers.getBayers()[i].getNameOfToys())+"\t");
                    System.out.printf(bayers.getBayers()[i].getNumberOfSell()+"\n");

                    sum += priceOfToys(bayers.getBayers()[i].getNameOfToys());
                    totalItem += bayers.getBayers()[i].getNumberOfSell();
                }
             }
        }
        System.out.println("----------------");
        System.out.println("Total: " + "$, incom: " + sum + ". Total, item: " + totalItem+".");
    }

    private static int priceOfToys(String name) {
        int price = 0;
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < utilities.longArray(mainToysArray.getMain()[i]); k++) {
                if (mainToysArray.getMain()[i][k].getNameToys() == name) {
                    price = mainToysArray.getMain()[i][k].getPrice();
                }

            }
        }
        return price;
    }
}
