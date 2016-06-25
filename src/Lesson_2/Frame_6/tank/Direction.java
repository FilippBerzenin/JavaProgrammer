package Lesson_2.Frame_6.tank;

/**
 * Created by Samsung on 17.05.2016.
 */
public enum Direction {

    LEFT(3), RIGHT(4), TOP(1), BOTTOM(2);

    private static int id;

    private Direction (int id) {
    }

    public static int getId () {
        return id;
    }
}
