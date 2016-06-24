package Lesson_2.Frame_6.ToysShop;

import Lesson_2.Frame_6.ToysShop.toys.ENUMS.age;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender;
import Lesson_2.Frame_6.ToysShop.toys.parametrs;
import Lesson_2.Frame_6.ToysShop.toys.stuffedToy.*;
import Lesson_2.Frame_6.ToysShop.toys.toys;

public class objects {

    public objects () {
    }

    private static cats[] cats = new cats[parametrs.getLongArray()];
    private static dogs[] dogs = new dogs[parametrs.getLongArray()];
    private static horses[] horses = new horses[parametrs.getLongArray()];

    private static void fillArrayObjects() {
        catsArray();
        dogsArray();
        horsesArray();
    }

    private static void catsArray() {
        cats[0] = new cats();
        cats[0].setNameToys("Big black cat");
        cats[0].setMainColor("BLACK");
        cats[0].setWeight(1.5);
        cats[0].setPrice(100);
        cats[0].setVoice("May");

        cats[1] = new cats();
        cats[1].setNameToys("Big white cat");
        cats[1].setForAge(age.FORALLAGE);
        cats[1].setMainColor("WHITE");
        cats[1].setWeight(1.5);
        cats[1].setGender(gender.UNISEX);
        cats[1].setPrice(100);
        cats[1].setVoice("May-may");

        cats[2] = new cats();
        cats[2].setNameToys("Little black cat");
        cats[2].setForAge(age.FORALLAGE);
        cats[2].setMainColor("BLACK");
        cats[2].setWeight(1.5);
        cats[2].setGender(gender.UNISEX);
        cats[2].setPrice(70);
        cats[1].setVoice("Mur-mur-may");
    }

    private static void dogsArray() {
        dogs[0] = new dogs();
        dogs[0].setNameToys("Little black dog");
        dogs[0].setForAge(age.ONEFORTHREE);
        dogs[0].setMainColor("BLACK");
        dogs[0].setWeight(0.5);
        dogs[0].setGender(gender.GIRLS);
        dogs[0].setPrice(50);
        dogs[0].setVoice("Au-au-au");

        dogs[1] = new dogs();
        dogs[1].setNameToys("Bulmastif");
        dogs[1].setForAge(age.SIXFORTEN);
        dogs[1].setMainColor("YELLOW");
        dogs[1].setWeight(3.0);
        dogs[1].setGender(gender.BOYS);
        dogs[1].setPrice(250);
        dogs[1].setVoice("R-r-r-r, Gav! Hrum-hrum!");

        dogs[2] = new dogs();
        dogs[2].setNameToys("Buldog");
        dogs[2].setForAge(age.TENFORSIXTEEN);
        dogs[2].setMainColor("BROWN");
        dogs[2].setWeight(2.0);
        dogs[2].setGender(gender.GIRLS);
        dogs[2].setPrice(150);
        dogs[2].setVoice("Gav-gav-gav!");
    }

    private static void horsesArray() {
        horses[0] = new horses();
        horses[0].setNameToys("Little pony");
        horses[0].setForAge(age.TENFORSIXTEEN);
        horses[0].setMainColor("BLUE");
        horses[0].setWeight(0.7);
        horses[0].setGender(gender.GIRLS);
        horses[0].setPrice(150);
        horses[0].setVoice("Iho-ho!");
    }

    public static cats[] getCats() {
        return cats;
    }

    public static void setCats(cats[] cats) {
        objects.cats = cats;
    }

    public static dogs[] getDogs() {
        return dogs;
    }

    public static void setDogs(dogs[] dogs) {
        objects.dogs = dogs;
    }

    public static horses[] getHorses() {
        return horses;
    }

    public static void setHorses(horses[] horses) {
        objects.horses = horses;
    }

    public static void startFillObjects() {
        fillArrayObjects();
    }
}
