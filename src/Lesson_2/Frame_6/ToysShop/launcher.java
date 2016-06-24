package Lesson_2.Frame_6.ToysShop;

        import Lesson_2.Frame_6.ToysShop.report.*;
        import Lesson_2.Frame_6.ToysShop.toys.*;
        import Lesson_2.Frame_6.ToysShop.sell.*;

//      import static Lesson_2.Frame_6.ToysShop.toys.toys.setAllBayToys;

public class launcher{

    public static void main (String[] args) {
        filArray();
        report();
    }
        private static void report () {
 //       price.orderOfPrice();
 //       productsOnStock.orderNumbersOfProductOnStock();
//        report.mainArrayPrint();
 //       rezalultFromDays.report();
//            transactionForThisDay.report(1);
            katalog.mainReport();
            katalog.speakingToys();
    }

    private static void filArray () {
        objects.startFillObjects();
        mainToysArray.mainArrayFill();
        bayers.actionSells();
        transactions.actionBay();
        transactions.actionSells();
    }
}
