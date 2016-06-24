package Lesson_2.Frame_6.ToysShop.toys.stuffedToy;

import Lesson_2.Frame_6.ToysShop.toys.ENUMS.age;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender;
import Lesson_2.Frame_6.ToysShop.toys.stuffedToys;
import Lesson_2.Frame_6.ToysShop.toys.toys;

public class cats extends stuffedToys {

    @Override
    public boolean getSpeak() {
        return true;
    }

    @Override
    public void getVoice() {
        System.out.println("Big mya");
    }

    @Override
    public String toString() {
        return "Stuffed Cats";
    }



}
