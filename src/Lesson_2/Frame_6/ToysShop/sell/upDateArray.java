package Lesson_2.Frame_6.ToysShop.sell;

import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.toys;
import Lesson_2.Frame_6.ToysShop.toys.utilities;

import java.lang.reflect.Array;
import java.util.Arrays;

import static Lesson_2.Frame_6.ToysShop.toys.utilities.errorOfNumberProducts;

public class upDateArray {

    protected static void sellToys (String nameBayers, int day, String nameToys, int numberOfSell) {
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < mainToysArray.getMain()[i].length; k++) {
                if (mainToysArray.getMain()[i][k] == null) {
                    break;
                } else {
                    if (mainToysArray.getMain()[i][k].getNameToys().equals(nameToys)) {
                        fillSetAllSellToys (day, i, k, numberOfSell);
                        mainToysArray.getMain()[i][k].setSellToys(allSellToys (i, k));
//                        System.out.println(Arrays.toString(mainToysArray.getMain()[i][k].getAllSellToys())+" Sell");
                        mainToysArray.getMain()[i][k].setNumber(numberOfToys (i, k));
                    }
                }
            }
        }
    }

    private static int numberOfToys (int i, int k) {
        int number;
        number = mainToysArray.getMain()[i][k].getBayToys()-mainToysArray.getMain()[i][k].getSellToys();
        return number;
    }

    private static int allSellToys (int i, int k) {
        int sum = 0;
        for (int j = 0; j<mainToysArray.getMain()[i][k].getAllSellToys().length; j++) {
            for (int g = 0; g<mainToysArray.getMain()[i][k].getAllSellToys()[j].length; g++) {
                sum += mainToysArray.getMain()[i][k].getAllSellToys()[j][g];
            }
        }
        return sum;
    }


    private static int fillSetAllSellToys (int day, int i, int k, int numberOfSell) {
        if (errorOfNumberProducts (i, k, numberOfSell)) {
            int number = utilities.lastPositionSell(day, i, k);
            mainToysArray.getMain()[i][k].setAllSellToys(day, number, numberOfSell);
        }
        return numberOfSell;
    }

    protected static void bayToys (int day, String nameToys, int numberOfBay) {
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k < mainToysArray.getMain()[i].length; k++) {
                if (mainToysArray.getMain()[i][k] == null) {
                    break;
                } else {
                    if (mainToysArray.getMain()[i][k].getNameToys().equals(nameToys)) {
                        fillSetAllBayToys (day, i, k, numberOfBay);
                        mainToysArray.getMain()[i][k].setBayToys(allBayToys (i, k));
//                        System.out.println(Arrays.toString(mainToysArray.getMain()[i][k].getAllBayToys())+" Bay");
                        mainToysArray.getMain()[i][k].setNumber(numberOfToys (i, k));
                    }
                }
            }
        }
    }

    private static int fillSetAllBayToys (int day, int i, int k, int numberOfBay) {
            int number = utilities.lastPositionBay(day, i, k);
            mainToysArray.getMain()[i][k].setAllBayToys(day, number, numberOfBay);
        return numberOfBay;
    }

    private static int allBayToys (int i, int k) {
        int sum = 0;
        for (int j = 0; j<mainToysArray.getMain()[i][k].getAllBayToys().length; j++) {
            for (int g = 0; g<mainToysArray.getMain()[i][k].getAllBayToys()[j].length; g++) {
                sum += mainToysArray.getMain()[i][k].getAllBayToys()[j][g];
            }
        }
        return sum;
    }
}
