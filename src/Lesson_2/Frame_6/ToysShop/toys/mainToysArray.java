package Lesson_2.Frame_6.ToysShop.toys;

import Lesson_2.Frame_6.ToysShop.objects;
import Lesson_2.Frame_6.ToysShop.toys.stuffedToy.*;

public class mainToysArray extends toys {

    static private stuffedToys[][] main = new stuffedToys[parametrs.getNumberOfStuffedToys()][parametrs.getLongArray()];

    static cats[] cats = objects.getCats();
    static dogs[] dogs = objects.getDogs();
    static horses[] horses = objects.getHorses();

    public static void mainArrayFill() {
        if (utilities.errorArrayFoNullAndForLength(cats)==true) {
            System.arraycopy(objects.getCats(), 0, main[0], 0, objects.getCats().length);
        }
        if (utilities.errorArrayFoNullAndForLength(dogs)==true) {
            System.arraycopy(objects.getDogs(), 0, main[1], 0, objects.getDogs().length);
        }
        if (utilities.errorArrayFoNullAndForLength(horses)==true) {
            System.arraycopy(objects.getHorses(), 0, main[2], 0, objects.getHorses().length);
        }

    }

    public static stuffedToys[][] getMain() {
        return main;
    }

    public static void setMain(stuffedToys[][] main) {
        mainToysArray.main = main;
    }
}
