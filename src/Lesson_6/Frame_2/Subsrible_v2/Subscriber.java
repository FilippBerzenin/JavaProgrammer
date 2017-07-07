package Lesson_6.Frame_2.Subsrible_v2;

import java.util.*;

public class Subscriber implements java.util.Observer {

    public void inform(String name) {
        System.out.println(this.toString() + " got new edition of " + name);
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println(this.toString() + " got new edition of " + o.getClass().getSimpleName() + " " + arg);
    }
}
