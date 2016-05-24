package Lesson_2.Frame_1.frame_5.tank;

public class BT7 extends Tank {

    private final int speed = 5;

    public BT7(ActionField af, BattelField bf) {
        super(af, bf);
    }

    public BT7(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }
}
