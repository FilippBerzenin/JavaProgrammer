package Lesson_2.Frame_6.ToysShop.toys;

import Lesson_2.Frame_6.ToysShop.sell.bayers;

public class utilities {

    public static int lastPositionSell (int day, int i, int k) {
        int [][] forAnaliz = mainToysArray.getMain()[i][k].getAllSellToys();
        for (int j = 0;j<forAnaliz.length; j++) {
            if (forAnaliz[day][j] == 0) {
                return j;
            }
        }
        return -100;
    }

    public static int lastPositionBay (int day, int i, int k) {
        int [][] forAnaliz = mainToysArray.getMain()[i][k].getAllBayToys();
        for (int j = 0;j<forAnaliz[day].length; j++) {
            if (forAnaliz[day][j] == 0) {
                return j;
            }
        }
        return -100;
    }


    public static boolean errorOfNumberProducts (int i, int k, int sell) {
        if ((mainToysArray.getMain()[i][k].getBayToys()-sell)>=0) {
            return true;
        }
        else {
            System.out.println("Boss! We dont have enough products. " +
            " We can sell only "+mainToysArray.getMain()[i][k].getBayToys()+" " + mainToysArray.getMain()[i][k].getNameToys());
            return false;
        }
    }

    public static boolean errorArrayFoNullAndForLength(stuffedToys[] main) {
        if (main == null) {
            return false;
        }
        return true;
    }

    public static int longArray (stuffedToys[] main)  {
        int longArray = 0;
        for (int i = 0; i<main.length; i++) {
            if (main[i] != null) {
                longArray = i+1;
            }
        }
        return longArray;
    }

    public static int longArray (bayers[] main) {
        int longArray = 0;
        for (int i = 0; i<main.length; i++) {
            if (main[i] != null) {
                longArray = i+1;
            }
        }
        return longArray;
    }

    public static int sumSellForThisDay (int day, int i, int k) {
        int[] array = mainToysArray.getMain()[i][k].getAllSellToys()[day];
        int sum = 0;
        for (int j = 0; j<array.length; j++) {
                sum += array[j];
            }
        return sum;
    }
}
