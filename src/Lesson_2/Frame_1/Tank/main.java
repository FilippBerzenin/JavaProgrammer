package Lesson_2.Frame_1.Tank;

public class main {

    static tank[] myTank = new tank[3];

    public static void main(String[] args) {

        TankInfo();
//        printTank();
        printClassExtendsTank();
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

    static void printTank(tank tank) {
                System.out.println("myTank.color :" + tank.getColor());
                System.out.println("myTank.maxSpeed :" + tank.getMaxSpeed());
                System.out.println("myTank.crew :" + tank.getCrew());
                System.out.println();
            }

    static void printClassExtendsTank() {
        T34 tankT34 = new T34();
        tankT34.setColor("Dark-green");
        tankT34.setMaxSpeed(84);
        tankT34.setCrew(4);

        BT7 tankBT7 = new BT7();
        tankBT7.setColor("Grey");
        tankBT7.setMaxSpeed(125);
        tankBT7.setCrew(2);

        Tiger tiger = new Tiger();
        tiger.setColor("Broun");
        tiger.setMaxSpeed(50);
        tiger.setCrew(5);

        printTank(tankT34);
        printTank(tankBT7);
        printTank(tiger);
    }
}
