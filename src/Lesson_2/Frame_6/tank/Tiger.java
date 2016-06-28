package Lesson_2.Frame_6.tank;

public class Tiger extends Tank {

    public Tiger(ActionField af, BattelField bf) {
        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
