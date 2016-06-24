package Lesson_2.Frame_6.ToysShop.sell;

import Lesson_2.Frame_6.ToysShop.objects;
import Lesson_2.Frame_6.ToysShop.toys.*;
import Lesson_2.Frame_6.ToysShop.toys.stuffedToy.*;

import static Lesson_2.Frame_6.ToysShop.sell.upDateArray.bayToys;
import static Lesson_2.Frame_6.ToysShop.sell.upDateArray.sellToys;
//import static Lesson_2.Frame_6.ToysShop.sell.upDateArray.sellToys;

public class transactions {

    public static void actionBay () {
        bayToys(1, "Big black cat", 10);
        bayToys(2, "Big black cat", 10);
        bayToys(3, "Big black cat", 10);
        bayToys(1, "Little pony", 15);
        bayToys(1, "Big white cat", 7);
        bayToys(1, "Little black dog", 3);
        bayToys(1, "Bulmastif", 3);
    }

    public static void actionSells() {
        for (int i=0;i<5; i++) {
            sellToys(
                    bayers.getBayers()[i].getNameBayers(),
                    bayers.getBayers()[i].getDayOfBay(),
                    bayers.getBayers()[i].getNameOfToys(),
                    bayers.getBayers()[i].getNumberOfSell()
            );
        }
    }

}
