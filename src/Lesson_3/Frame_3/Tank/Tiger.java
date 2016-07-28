package Lesson_3.Frame_3.Tank;

public class Tiger extends AbstractTank {

    public Tiger(ActionField af, BattelField bf) {
        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }

    @Override
    public void tankDestroy() {
        super.tankDestroy();
    }

    @Override
    public void draw() {
        af.repaint();
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
