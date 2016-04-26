package Lesson_1.frame_2.TankPrintInfo;

import java.util.Arrays;

public class main {

    static tank[] myTank = new tank[3];

    public static void main(String[] args) {

        TankInfo();
        printTank();
    }

    static void TankInfo() {
        myTank[0] = new tank();
        myTank[0].setColor("black");
        myTank[0].setMaxSpeed(120);
        myTank[0].setCrew(4);

        myTank[1] = new tank();
        myTank[1].setColor("red");
        myTank[1].setMaxSpeed(80);
        myTank[1].setCrew(6);

        myTank[2] = new tank();
        myTank[2].setColor("blue");
        myTank[2].setMaxSpeed(260);
        myTank[2].setCrew(3);
    }

    static void printTank() {
        if (myTank == null || myTank.length == 0) {
            System.out.println("Plesae, look to your array. Error on array");
        } else {
            for (int i = 0; i < myTank.length; i++) {
                System.out.println("myTank.color :" + myTank[i].getColor());
                System.out.println("myTank.maxSpeed :" + myTank[i].getMaxSpeed());
                System.out.println("myTank.crew :" + myTank[i].getCrew());
                System.out.println();
            }
        }
    }

}
