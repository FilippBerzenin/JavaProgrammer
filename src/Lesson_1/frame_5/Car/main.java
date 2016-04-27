package Lesson_1.frame_5.Car;

public class main {

    static carDescraption bmw = new carDescraption();

    public static void main (String[] args) {
        bmw();
        hellow();
        start();
        drive();
    }

    public static void hellow() {

        System.out.println ("Hello! My name "+bmw.getModelCar()+"! My favorite color " + bmw.getColor()+"!");
        System.out.println ("Today, my powerfull engine with "+bmw.getPowerCar()+" horses drive to anywhere!");
    }

    public static void start() {
        System.out.println ("Please, sit in car! And my " + bmw.getHowMachPassengers()+" pessengers can go!");
    }

    public static void drive() {
        System.out.println ("Today? we are srarted at "+bmw.getFromWhence()+". "+"And finishiung at "+bmw.getWhere()
        + ". "+ "Oure rouad have "+bmw.getHowFar()+" kilometrs.");
    }

    static void bmw () {
        bmw.setModelCar("BMW");
        bmw.setColor(color.DARK_GREEN);
        bmw.setTypeCar("cupe");
        bmw.setYearCreation(2014);
        bmw.setPowerCar(250);
        bmw.setMaxSpeed(240);
        bmw.setHowMachPassengers(2);
        bmw.setFromWhence("Kiev");
        bmw.setWhere("Dnepr");
        bmw.setHowFar(600);
    }

    }

