package Lesson_2.Frame_6.ToysShop.toys;

import Lesson_2.Frame_6.ToysShop.toys.ENUMS.age;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender;
import Lesson_2.Frame_6.ToysShop.toys.ENUMS.materials;

public class toys {
    public toys() {
    }

    private String nameToys;
    private String mainColor;
    private double weight;
    private int price;
    private int number;
    private boolean speak = false;
    private String voice;
    private int bayToys;
    private int sellToys;
    private int[][] allBayToys = new int [parametrs.getHowManyDaysShopsWork()][parametrs.getHowMachOrderForDay()];
    private int[][] allSellToys = new int [parametrs.getHowManyDaysShopsWork()][parametrs.getHowMachOrderForDay()];
    private materials materials;
    private age forAge;
    private gender gender;

    public boolean getSpeak() {
        return speak;
    }

    public void setSpeak(boolean speak) {
        this.speak = speak;
    }

    public Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender getGender() {
        return gender;
    }

    public void setGender(Lesson_2.Frame_6.ToysShop.toys.ENUMS.gender gender) {
        this.gender = gender;
    }

    public age getForAge() {
        return forAge;
    }

    public void setForAge(age forAge) {
        this.forAge = forAge;
    }

    public materials getMaterials() {
        return materials;
    }

    public void setMaterials(materials materials) {
        this.materials = materials;
    }

    public int[][] getAllBayToys() {
        return allBayToys;
    }

    public void setAllBayToys(int day, int number, int bay) {
        this.allBayToys[day][number] = bay;
    }

    public int[][] getAllSellToys() {
        return allSellToys;
    }

    public void setAllSellToys(int day, int number, int sell) {
        this.allSellToys[day][number] = sell;
    }

    public int getBayToys() {
        return bayToys;
    }

    public void setBayToys(int bay) {
        this.bayToys = bay;
    }

    public int getSellToys() {
        return sellToys;
    }

    public void setSellToys(int sellToys) {
        this.sellToys = sellToys;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void getVoice() {
        System.out.println(toString()+". "+"My name "+getNameToys()+": "+voice+"!");
    }

    public String getNameToys() {
        return nameToys;
    }

    public void setNameToys(String name) {
        this.nameToys = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
