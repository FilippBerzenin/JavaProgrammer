package Lesson_6.Frame_2.observer.Subscription;

public class Subscriber {

    public void inform(String name) {
        System.out.println(this.toString() + " got new edition of " + name);
    }
}
