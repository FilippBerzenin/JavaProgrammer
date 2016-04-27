package Lesson_1.frame_5.Car;

/**
 * Created by Samsung on 27.04.2016.
 */
public class carAction {
    public carAction(Object carDescraption) {
        carDescraption car = new carDescraption();

    }

//    carDescraption car = new carDescraption();

//    public carAction (carDescraption) {
//
//    }

    public void startCar () {carDescraption car = new carDescraption();
        System.out.println ("Hello! My name "+car.getModelCar());
    }
}
