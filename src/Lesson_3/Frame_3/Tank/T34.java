package Lesson_3.Frame_3.Tank;

public class T34 extends AbstractTank {

    public T34(ActionField af, BattelField bf) {
        super(af, bf);
    }

    public T34(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }
}
