package Lesson_1.frame_2.ThreeInterceptionObjects;

public class first {

    private String name = null;

    public static void main(String[] args) {

        runF();
    }

    public static void runF () {
        second s = new second("Fil");
    }

    first(String name) {
        this.name = name;
        System.out.println("First class; " + name);

    }
}

