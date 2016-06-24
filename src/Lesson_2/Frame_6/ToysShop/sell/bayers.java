package Lesson_2.Frame_6.ToysShop.sell;

import Lesson_2.Frame_6.ToysShop.toys.ENUMS.age;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;

public class bayers {

    private static bayers[] bayers = new bayers[parametrs.getHowManyBayersWeHad()];

    private String nameBayers;
    private int dayOfBay;
    private gender gender;
    private age ageOfBayers;
    private String nameOfToys;
    private int numberOfSell;

    public static void actionSells() {
        bayers[0] = new bayers();
        bayers[0].setNameBayers("Filipp");
        bayers[0].setDayOfBay(1);
        bayers[0].setNameOfToys("Big black cat");
        bayers[0].setNumberOfSell(1);

        bayers[1] = new bayers();
        bayers[1].setNameBayers("Kantik");
        bayers[1].setDayOfBay(2);
        bayers[1].setNameOfToys("Little black dog");
        bayers[1].setNumberOfSell(2);

        bayers[2] = new bayers();
        bayers[2].setNameBayers("Viktoria");
        bayers[2].setDayOfBay(1);
        bayers[2].setNameOfToys("Little pony");
        bayers[2].setNumberOfSell(1);

        bayers[3] = new bayers();
        bayers[3].setNameBayers("Tima");
        bayers[3].setDayOfBay(1);
        bayers[3].setNameOfToys("Bulmastif");
        bayers[3].setNumberOfSell(1);

        bayers[4] = new bayers();
        bayers[4].setNameBayers("Vasya");
        bayers[4].setDayOfBay(2);
        bayers[4].setNameOfToys("Big white cat");
        bayers[4].setNumberOfSell(1);

    }

    public int getNumberOfSell() {
        return numberOfSell;
    }

    public void setNumberOfSell(int numberOfSell) {
        this.numberOfSell = numberOfSell;
    }

    public String getNameOfToys() {
        return nameOfToys;
    }

    public void setNameOfToys(String nameOfToys) {
        this.nameOfToys = nameOfToys;
    }

    public static bayers[] getBayers() {
        return bayers;
    }

    public void setBayers(bayers[] bayers) {
        this.bayers = bayers;
    }

    public String getNameBayers() {
        return nameBayers;
    }

    public void setNameBayers(String nameBayers) {
        this.nameBayers = nameBayers;
    }

    public int getDayOfBay() {
        return dayOfBay;
    }

    public void setDayOfBay(int dayOfBay) {
        this.dayOfBay = dayOfBay;
    }

    public gender getGender() {
        return gender;
    }

    public void setGender(Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender gender) {
        this.gender = gender;
    }

    public age getAgeOfBayers() {
        return ageOfBayers;
    }

    public void setAgeOfBayers(age ageOfBayers) {
        this.ageOfBayers = ageOfBayers;
    }
}
