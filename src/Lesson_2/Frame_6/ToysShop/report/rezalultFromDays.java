package Lesson_2.Frame_6.ToysShop.report;

import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.utilities;

/**
 * Created by Samsung on 23.06.2016.
 */
public class rezalultFromDays {

    public static void report() {
        System.out.println("----------------REPORT FOR WORK OF DAY--------------------");
        int sum = 0;
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < utilities.longArray(mainToysArray.getMain()[i]); k++) {
                if (mainToysArray.getMain()[i][k] == null) {
                    break;
                } else {
                    System.out.print("Name toys: " + mainToysArray.getMain()[i][k].getNameToys() + " " + "sell all:" +
                            mainToysArray.getMain()[i][k].getSellToys()+" For each days:"+" ");
                    for (int y = 0; y<mainToysArray.getMain()[i][k].getAllSellToys().length;y++) {
                        System.out.printf("%-2s", utilities.sumSellForThisDay(y, i, k)+", ");
                        sum += utilities.sumSellForThisDay(y, i, k);
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("-----------------------------");
        System.out.println("All sells toys: "+sum+" items"+"\n");
    }
}


