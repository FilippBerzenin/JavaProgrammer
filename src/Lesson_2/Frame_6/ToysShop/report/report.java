package Lesson_2.Frame_6.ToysShop.report;
import Lesson_2.Frame_6.ToysShop.objects;
import Lesson_2.Frame_6.ToysShop.report.price;
import Lesson_2.Frame_6.ToysShop.report.productsOnStock;
import Lesson_2.Frame_6.ToysShop.toys.mainToysArray;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;

public class report {

    public static void mainArrayPrint() {
        for (int i = 0; i < parametrs.getNumberOfStuffedToys(); i++) {
            for (int k = 0; k< mainToysArray.getMain()[i].length; k++) {
                if (mainToysArray.getMain()[i][k]==null) {
                    break;
                }
                else {
                    System.out.println("Name toys: "+mainToysArray.getMain()[i][k].getNameToys()+" " +"Main toys color: " +
                            mainToysArray.getMain()[i][k].getMainColor()+" "+ "Price: "+
                            mainToysArray.getMain()[i][k].getPrice()+" " +"Number of toys: " +
                            mainToysArray.getMain()[i][k].getNumber() + " "+"We bay this toys: " +
                            mainToysArray.getMain()[i][k].getBayToys() + " "+ "We sell this toys: "
                            + mainToysArray.getMain()[i][k].getSellToys()
                            //+" ID"+i+""+k
                    );
                }
            }
        }
    }
}
