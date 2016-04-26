package Lesson_1.frame_2.ThreeInterceptionObjects;

public class thiad {

    private String name = null;

//    first f = new first("Vasya");

    thiad (String name) {
        this.name = name;
        System.out.println("Third class: "+name);
        first f = new first("Vasya");
    }
}
