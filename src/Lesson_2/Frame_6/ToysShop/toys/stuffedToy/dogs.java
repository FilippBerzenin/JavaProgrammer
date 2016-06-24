package Lesson_2.Frame_6.ToysShop.toys.stuffedToy;

import Lesson_2.Frame_6.ToysShop.toys.ENUMS.age;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender;
import Lesson_2.Frame_6.ToysShop.toys.stuffedToys;

public class dogs extends stuffedToys {

    @Override
    public boolean getSpeak() {
        return true;
    }

    @Override
    public void setVoice(String voice) {
        super.setVoice(voice + " My name "+getNameToys());
    }

    @Override
    public String toString() {
        return "Stuffed dogs";
    }
}
