package Lesson_2.Frame_6.ToysShop.report;

import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;

public class katalog {
    public static void mainReport() {
        System.out.println("---------------Main catalog of our products---------------");
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k< mainToysArray.getMain()[i].length; k++) {
                if (mainToysArray.getMain()[i][k]==null) {
                    break;
                }
                else {
                    System.out.println("Name toys: "+mainToysArray.getMain()[i][k].getNameToys()+" " +"Main toys color: " +
                                    mainToysArray.getMain()[i][k].getMainColor()+" "+ "Price: "+
                                    mainToysArray.getMain()[i][k].getPrice()+" " +"Number of toys: " +
                                    mainToysArray.getMain()[i][k].getNumber()
//                            + " "+"We bay this toys: " +
//                                    mainToysArray.getMain()[i][k].getBayToys() + " "+ "We sell this toys: "
//                                    + mainToysArray.getMain()[i][k].getSellToys()
                            //+" ID"+i+""+k
                    );
                }
            }
        }
        System.out.println();
    }

    public static void speakingToys() {
        System.out.println("---------------Catalog of tolking products---------------");
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k< mainToysArray.getMain()[i].length; k++) {
                if (mainToysArray.getMain()[i][k]==null) {
                    break;
                }
                else {
                    if (mainToysArray.getMain()[i][k].getSpeak()==true) {
                        System.out.println("Name toys: " + mainToysArray.getMain()[i][k].getNameToys() + " " + "Main toys color: " +
                                        mainToysArray.getMain()[i][k].getMainColor() + " " + "Price: " +
                                        mainToysArray.getMain()[i][k].getPrice() + " " + "Number of toys: " +
                                        mainToysArray.getMain()[i][k].getNumber() + " I can say: "
                        );
                        mainToysArray.getMain()[i][k].getVoice();
                    }
                }
            }
        }
    }
}
